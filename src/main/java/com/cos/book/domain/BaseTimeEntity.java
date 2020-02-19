package com.cos.book.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
// 다른 클래스에서 BaseTimeEntity 상속시에 해당 클래스의 필드도 칼럼으로 인식하게 함.
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
	
	@CreatedDate // Entity 생성시 시간이 자동 저장됨.
	private LocalDateTime createDate;
	
	@LastModifiedDate // Entity 수정시 시간이 자동 저장됨.
	private LocalDateTime modifiedDate;
}
