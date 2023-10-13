package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	//input : 3개 파라미
	//output : x
	public void addSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	//input : x
	//output : Seller (최신유저정보 1명)
	public Seller getLastSeller() {
		return sellerMapper.selectLastSeller();
	}
	
}