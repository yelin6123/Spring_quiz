package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
	//JpaRepository : String Data JPA 기능을 별도로 사용 => 자동적으로 메소드가 만들어져 제공받을 수 있음  
	//제네릭문법 추가 : <엔티티 문법이랑 맵핑 될 거다, 엔티티 키가 되는 타입이 무엇인지?,맵퍼클래스를 사용하기 때문에 integer사용?> 
	//insert 할 때 save(엔티티 객체) 라는 메소드를 사용하는데, 이런 기능이 구현이 될 수 있게 만들어줌
	
}
