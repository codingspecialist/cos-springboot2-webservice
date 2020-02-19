package com.cos.book.domain.posts;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.cos.book.domain.BaseTimeEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

// Entity 클래스에는 절대 Setter를 만들지 않는다(불변 규칙)
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;
	
	private String author;

	@Builder
	public Posts(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	// 더티 체킹을 위한 함수.
	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}
}
