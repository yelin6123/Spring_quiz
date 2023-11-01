package com.quiz.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

//필드 먼저 추가 후 어노테이션 함


@ToString
@AllArgsConstructor
@NoArgsConstructor //Constructor(생성자)args (아규먼트?)
@Getter
@Builder(toBuilder = true) //setter의 대용
@Entity
@Table(name="company") //테이블명 작성
public class CompanyEntity {
	@Id //얘는 아이디다 라는걸 알려줌 
	@GeneratedValue(strategy = GenerationType.IDENTITY) //자동으로 숫자 들어감, GenerationType.IDENTITY: 숫자 겹치지 않게
	private int id;
	
	private String name;
	
	@Column(name = "business") //컬럼명...안하시네?
	private String business;
	
	@Column(name = "scale")
	private String scale;
	
	@Column(name = "headcount")
	private int headcount;
	
	@UpdateTimestamp //현재시간
	@Column(name = "createdAt", updatable = false) //다시 변경안되도록!
	private ZonedDateTime createdAt; 
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;

}
