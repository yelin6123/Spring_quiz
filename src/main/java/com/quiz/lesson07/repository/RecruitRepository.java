package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;
@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer> {
	
	//quiz02_2
	//@Query(value ="select re from recruit re where re.companyId = :companyId")
	//public List<RecruitEntity> findByCompanyId(@Param("companyId") int companyId);
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	
	//quiz02_3
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	//quiz02_4
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	//quiz02_5
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	//quiz02_6
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	//quiz02_7
	//native Query 조회 => DB에 직접 조회
	@Query(value ="select * from `recruit` "
			+ "where `deadline` > :deadline "
			+ "and salary >= :salary "
			+ "and `type` = :type "
			+ "order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline, 
			@Param("salary") int salary,
			@Param("type") String type
			); //스프링 프레임워크로 임포트하기
	
}
