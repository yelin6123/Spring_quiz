package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.CompanyBO;
import com.quiz.lesson07.entity.CompanyEntity;

@RequestMapping("/lesson07/quiz01")
@RestController
public class Lesson07Quiz01RestController {
	
	@Autowired
	private CompanyBO companyBO;
	
	@GetMapping("/save1")
	public CompanyEntity save1() { //CompanyEntity 의 객체로 리턴한다.
		//회사명 : 넥손
		//사업내용 : 컨텐츠 게임
		//규모 : 대기업
		//사원수 : 3585명
		//옛날 방식?
//		String name = "넥손";
//		String business = "컨텐츠 게임";
//		String scale = "대기업";
//		int headcount = 3585;
//		
//		return companyBO.addCompany(name, business, scale, headcount);
		
		return companyBO.addCompany("넥손", "컨텐츠 게임", "대기업", 3585);
		
	}
	
	@GetMapping("/save2")
	public CompanyEntity save2() {
//		회사명 : 버블팡
//		사업내용 : 여신 금융업
//		규모 : 대기업
//		사원수 : 6834명
		
		return companyBO.addCompany("버블팡", "여신 금융업", "대기업", 6834);
	}
	
	@GetMapping("/update")
	public CompanyEntity update() {
		{
//			  "id": 9,
//			  "name": "버블팡",
//			  "business": "여신 금융업",
//			  "scale": "중소기업",
//			  "headcount": 34,
//			  "createdAt": "2023-06-01T20:17:50.9305192+09:00",
//			  "updatedAt": "2023-06-01T20:17:50.9305192+09:00"
		return companyBO.updateCompanyScaleHeadcountById(9, "중소기업", 34);
			
			}
	}
	
	@GetMapping("/delete")
	public String dalete() {
		companyBO.deleteCompanyById(9);
		return "삭제완료";
	}
	
	
	
	
	
}
