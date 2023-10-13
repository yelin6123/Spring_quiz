package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.RealEstate;
import com.quiz.lesson03.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	//input : id(정수)
	//output : RealEstate
	public RealEstate getRealEstateById(int id) {
		return realEstateMapper.selectRealEstateById(id);
	}
	
	//input : rentPrice
	//output :List<RealEstate>
	public List<RealEstate> getRealEstateByRentPrice(int rentPrice) {
		return realEstateMapper.selectRealEstateByRentPrice(rentPrice);
	}
	
	//input : area, price
	//output : List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price){ //bo의 입장에서꼭 받아야 하는 값이 있다면 int,null도 가능하다면 Integer
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	//quiz02_1
	//input : realestate 객체
	//output : 입력성공한 값 int
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate) ;
	}
	
	//quiz02_2
	//input : realtorId, "썅떼빌리버 오피스텔 814호", 45, "월", 100000, 120 
	//output : int
	//BO의 입장에서 생각할 경우 어디서 요청을 받아도 rentPrice는 null허용되도록 Integer로 선언
	public int addRealEstateAsField(
			int realtorId , String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	//quiz03_1
	//input : id, type, price
	//output : int (수정성공한 값)
	public int updateRealEstateById(
			int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	//quiz04_1
	public int deleteRealEstateByid(int id) {
		return realEstateMapper.deleteRealEstateByid(id);
	}
	
	
	
}
