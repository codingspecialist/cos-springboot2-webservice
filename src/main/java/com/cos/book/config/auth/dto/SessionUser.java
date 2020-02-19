package com.cos.book.config.auth.dto;

import java.io.Serializable;

import com.cos.book.domain.user.User;

import lombok.Getter;

@Getter
public class SessionUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String picture;
	
	public SessionUser(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		this.picture = user.getPicture();
	}
	
	
}
