package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07quiz02RestController {
	
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
//	public Optional<RecruitEntity> quiz02_1() {
//		return recruitRepository.findById(8);
//	}
	//선생님 답변
	public RecruitEntity quiz02_1() {
	return recruitRepository.findById(8).orElse(null);
}
	
	@GetMapping("/2")
//	public List<RecruitEntity> quiz02_2() {
//		return recruitRepository.findByCompanyId(1);
//	}
	
	public List<RecruitEntity> quiz02_2(
			@RequestParam("companyId") int companyId) {
		return recruitRepository.findByCompanyId(1);
	}
	//=> url : localhost:8080/lesson07/quiz02_2?companyId=1 
	
	
	@GetMapping("/3")
	//웹 back-end 개발자 이고 정규직인 공고를 조회하고 아래와 같이 출력하세요.
	public List<RecruitEntity> quiz02_3() {
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	//정규직이거나 연봉이 9000 이상인 공고를 조회하고 아래와 같이 출력하세요.
	//메소드명 규칙을 검색해서 찾아보세요.
//	public List<RecruitEntity> quiz02_4() {
//		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
//	}
	
	public List<RecruitEntity> quiz02_4() {
		return recruitRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	} 
	//GreaterThan < / Equal = 
	//복잡한 식은 mysql에서 하는게 낫다고 함...
	
	
	@GetMapping("/5")
	//계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회하세요.
	public List<RecruitEntity> quiz02_5() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	//성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회하고 아래와 같이 출력하세요.
	public List<RecruitEntity> quiz02_6() {
		return recruitRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	//Native query로 마감일이 2026-04-10 이후이고 
	//	연봉이 8100 이상인 정규직 공고를 
	//  연봉 내림차순으로 조회하세요.
	public List<RecruitEntity> quiz02_7() {
		return recruitRepository.findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc("2026-04-10",8100, "정규직");
		//크기비교 Salary GreaterThanEqula
		//내림차순 : Desc
		
	}
	
	
	
}
