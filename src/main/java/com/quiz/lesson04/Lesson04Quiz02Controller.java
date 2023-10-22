package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;
@RequestMapping("/lesson04/quiz02")
@Controller
public class Lesson04Quiz02Controller {
//	입력 form을 이용해서 새로운 공인중개사를 DB에 추가하세요.
//	@ModelAttribute 를 이용해서 parameter를 받으세요.
//	submit 후 useGeneratedKeys 를 이용해서 insert한 내용의 id를 얻어내고 이를 이용해서 새롭게 select 하고 그 결과를 출력하세요.
//	입력 form URL : http://localhost:8080/lesson04/quiz02/add-realtor-view
//	입력 action URL : http://localhost:8080/lesson04/quiz02/add-realtor
	
	//순서
	//1. GetMapping => jsp => PostMapping => @ModelAttribute, Realtor realtor 작성 => domain realtor 추가
	//2. realtorBO 

	@Autowired
	private RealtorBO realtorBO;
	
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtorView";
	} 
	
	
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, 
			Model model) {
		
		//DB insert
		realtorBO.addRealtor(realtor);  //breakpoint 이유 : 리퀘스트파라미터가 잘 넘어오는지, id가 잘 들어가는지, 잘 돌아가는지 알기 위해 
		
		//DB select
		Realtor newRealtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("realtor", newRealtor);
		
		return "lesson04/afterAddRealtor";
	}
	
}
