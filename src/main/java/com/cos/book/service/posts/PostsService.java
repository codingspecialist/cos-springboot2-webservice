package com.cos.book.service.posts;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.book.domain.posts.Posts;
import com.cos.book.domain.posts.PostsRepository;
import com.cos.book.web.dto.PostsListResponseDto;
import com.cos.book.web.dto.PostsResponseDto;
import com.cos.book.web.dto.PostsSaveRequestDto;
import com.cos.book.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		// update할 때는 해당 entity를 영속화 시킨 후
		Posts post = postsRepository.findById(id)
				.orElseThrow(() -> {
					return new IllegalArgumentException("해당 사용자가 없습니다. id="+id);
				});
		// 영속화 된 entity만 수정하면 된다.
		post.update(requestDto.getTitle(), requestDto.getContent());
		
		return id;
	}
	
	@Transactional(readOnly = true)
	public PostsResponseDto findById(Long id) {
		Posts post = postsRepository.findById(id)
		
				.orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));
		return new PostsResponseDto(post);
	}
	
	// 트랜잭션 범위는 유지하되 조회 기능만 남겨두어 조회 속도가 개선됨.
	@Transactional(readOnly = true)
	public List<PostsListResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().stream()
				.map((post) -> new PostsListResponseDto(post))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void delete(Long id) {
		Posts post = postsRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
		postsRepository.delete(post);
	}
}



