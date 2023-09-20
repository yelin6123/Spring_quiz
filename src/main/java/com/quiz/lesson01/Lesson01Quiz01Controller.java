package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/lesson01/quiz01")
@Controller 
public class Lesson01Quiz01Controller {

	// 요청 URL : http://localhost:8080/lesson01/quiz01/1
	@ResponseBody
	@RequestMapping("/1")
	public String quiz01_1() {
		String text = "<h1>텍스트 프로젝트 완성</h1> <br>" 
				+ "<h4>해당 프로젝트를 통해서 문제풀이를 진행 합니다.</h4>";
		return text;
	}
	
	//요청 URL : http://localhost:8080/lesson01/quiz01/2
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Object> quiz01_2() {
		Map<String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("영어", 90);
		map.put("수학", 85);
		
		return map;
 	}
}
