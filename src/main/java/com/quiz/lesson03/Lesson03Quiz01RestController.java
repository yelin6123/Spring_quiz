package com.quiz.lesson03;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {

	@Autowired
	private RealEstateBO realestateBO;

	//1) 
	// mapper.xml 에 mapper 안붙임 ㅠ 
	
	// 요청 URL : http://localhost:8080/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public RealEstate quiz01_1(@RequestParam("id") int id) {
		return realestateBO.getRealEstateById(id);
	}

	
	//2)
	// list 인거 못 봄......봤어도 잘 했으려나^^
	//RealEstateMapper.java
		//public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice1") int rentPrice);
	//realEstateMapper.xml
		//parameterType="map"
		//<![CDATA[
		//	`rentPrice` < #{rentPrice1}
		//]]> 
	
	// 요청 url : http://localhost:8080/lesson03/quiz01/2?rent_price=90 나는 300정도로 설정...
	@RequestMapping("/2")
	public	List<RealEstate> quiz01_2(@RequestParam("rent_price") int rentPrice) {
		return realestateBO.getRealEstateByRentPrice(rentPrice);
	}

}



