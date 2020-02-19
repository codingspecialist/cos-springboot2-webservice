package com.cos.book.domain.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long>{
	
	// JPA naming Method를 사용하는 것보다 Query가 가독성이 더 좋음.
	@Query(value="SELECT * FROM posts ORDER BY id DESC", nativeQuery = true)
	List<Posts> findAllDesc();
}
