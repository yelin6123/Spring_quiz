package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository; //jpa 
	
	//input: 4개 파라미터 output : 방금 인서트 된 엔티티
	public CompanyEntity addCompany(String name, 
			String business, String scale, int headcount) {
		
		//Company repository 만들고와 
		//이전 방법
//		CompanyEntity company = CompanyEntity.builder()
//				.name(name)
//				.business(business)
//				.scale(scale)
//				.headcount(headcount)
//				.build();
//		
//		return companyRepository.save(company);
		
		//한번에 할 수 있는 방법
		return companyRepository.save(
				CompanyEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build());
	}
	
	//update
	public CompanyEntity updateCompanyScaleHeadcountById(int id, String scal, int headcount) {
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		if(company != null) {
			return companyRepository.save(
					company.toBuilder()
					.scale(scal)
					.headcount(headcount)
					.build());
		}
		return null ;
	}
	
	//delete
	public void deleteCompanyById(int id) {
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
	
}
