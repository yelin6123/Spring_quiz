package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.domain.Realtor;
import com.quiz.lesson04.mapper.RealtorMapper;

@Service
public class RealtorBO {
	
	@Autowired
	private RealtorMapper realtorMapper;
	
	//input : Realtor 객체
	//output : x
	public void addRealtor(Realtor realtor) {
		realtorMapper.insertRealtor(realtor);
	}
	
	//input : realtor id
	//output : realtor 객체 (마지막객체보여주기)
	public Realtor getRealtorById(int id) { 
		return realtorMapper.selectRealtorById(id);
	}
	
	
}
