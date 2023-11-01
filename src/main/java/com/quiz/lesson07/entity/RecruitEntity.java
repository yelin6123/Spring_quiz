package com.quiz.lesson07.entity;

import java.time.LocalDate;
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

@ToString //바로 출력 가능!
@AllArgsConstructor //모든 항목들이 있는 생성자
@NoArgsConstructor
@Builder//업데이트 할꺼면 ToBuilder
@Getter
@Entity(name = "recruit")
@Table(name = "recruit")
public class RecruitEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int companyId;
	
	private String position;
	
	private String responsibilities;
	
	private String qualification;
	
	private String type;
	
	private String region;
	
	private int salary;
	
	private LocalDate deadline; //시분초 없음 
	
	@UpdateTimestamp
	@Column(name = "createdAt", updatable = false)
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
}
