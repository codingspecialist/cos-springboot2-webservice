package com.cos.book.config.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cos.book.domain.user.Role;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final CustomOAuth2UserService customOAuth2UserService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.headers().frameOptions().disable()
			.and()
				.authorizeRequests()
				.antMatchers("/","/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile")
				.permitAll()
				.antMatchers("/api/v1/**").hasRole(Role.USER.name()) // 테스트 후 USER로 변경하기 
				.anyRequest().authenticated()
			.and()
				.logout()
					.logoutSuccessUrl("/")
			.and()
				.oauth2Login()
					.userInfoEndpoint()
						.userService(customOAuth2UserService);
				
		
	}
}
