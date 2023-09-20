package com.quiz.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@ResponseBody
	@RequestMapping("/test1") //웹 서블릿 어노테이션이랑 동일함
	public String test1() {
		return "Hello world~";
	
	}
}
