package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.RealEstate;

@Repository
public interface RealEstateMapper {
	
	//1)
	public RealEstate selectRealEstateById(int id);
	
	//2)
	public List<RealEstate> selectRealEstateByRentPrice(@Param("rentPrice1") int rentPrice);
	
	//3)
	public List<RealEstate> selectRealEstateListByAreaPrice(
			//파라미터가 2개 이상 일 경우
			//@Param 사용 시 하나의 map 이 되어 @Param ("key 명") int/Integer value명 가 된다.	
			//key명으로 넘어오기 떄문에 value명은 아무거나 써도 괜춘 
			@Param ("area") int area,
			@Param ("price") int price);
	
	//2-1
	public int insertRealEstate(RealEstate realEstate);
	
	//2-2
	// 파라미터 2개 이상이면 map으로 만든다(@Param)
	//param의 키명과 xml의 변수명이 동일해야함 (value명은 상관 없음)
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price,
			@Param("rentPrice") Integer rentPrice);	
	
	//3-1
	public int updateRealEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	//4
	public int deleteRealEstateByid(int id);
	
}
