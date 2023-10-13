package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;

@RestController
public class lesson03Quiz04RestController {

	
	@Autowired
	private RealEstateBO realEstateBo;
	
//	delete
//	parameter로 받은 id의 행을 삭제하세요.
//	삭제 성공한 행의 수를 출력 예시처럼 Response String으로 브라우저에서 출력하세요.
//	요청 URL 예시
//	출력 예시
//	삭제 성공 : 1

//	http://localhost:8080/lesson03/quiz04/1?id=9
	@RequestMapping("/lesson03/quiz04/1")
	public String quiz04_1 (
			@RequestParam("id") int id) {
		int rowCount = realEstateBo.deleteRealEstateByid(id);
		return "삭제 성공 :" + rowCount;
	}

	



}
