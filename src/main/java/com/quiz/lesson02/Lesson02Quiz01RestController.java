package com.quiz.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;

@RestController
public class Lesson02Quiz01RestController {
	
	@Autowired
	private StoreBO storeBO; //DI
	
	
	//요청 URL : http://localhost:8080/lesson02/quiz01
	@RequestMapping("/lesson02/quiz01")
	//store import시 이상한 걸로 되어있는지 확인필요
	public List<Store> quiz01() {
		return storeBO.getStoreList();
		//return : responsebody에 내려감 
	}
}
