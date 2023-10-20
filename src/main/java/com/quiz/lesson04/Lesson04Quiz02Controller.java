package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
//	입력 form을 이용해서 새로운 공인중개사를 DB에 추가하세요.
//	@ModelAttribute 를 이용해서 parameter를 받으세요.
//	submit 후 useGeneratedKeys 를 이용해서 insert한 내용의 id를 얻어내고 이를 이용해서 새롭게 select 하고 그 결과를 출력하세요.
//	입력 form URL : http://localhost:8080/lesson04/quiz02/add-realtor-view
//	입력 action URL : http://localhost:8080/lesson04/quiz02/add-realtor
	
	@Autowired
	private RealtorBO realtorBO;
	
	
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		
		return "lesson04/addRealtorView";
	}
	
	@PostMapping("/add-realtor")
	public String addRealtor() {
		return "lesson04/addRealtor";
	}
	
}
