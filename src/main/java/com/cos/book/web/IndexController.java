package com.cos.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.book.config.auth.LoginUser;
import com.cos.book.config.auth.dto.SessionUser;
import com.cos.book.service.posts.PostsService;
import com.cos.book.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final PostsService postsService;

	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("posts", postsService.findAllDesc());
		
		// 스프링 로그인 시 DefaultOAuth2User 객체가 Spring-Security-Context라는
		// session에 저장됨.
		// 그리고 이동욱 저자는 user라는 session에 SessionUser라는 객체 저장.
		// 현재 두 곧의 세션에 내 정보가 관리되는 중.
		// logout하면 세션 자체를 invalidate() 하기 때문에 두 세션 모두 사라져서 로그아웃됨.
		
		return "index";
		
	}
	
	@GetMapping("/posts/save")
	public String postsSave() {
		return "/posts/save";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		
		return "posts/update";
	}
	
}






