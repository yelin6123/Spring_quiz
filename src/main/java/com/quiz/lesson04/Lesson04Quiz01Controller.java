package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	//1번문제 :판매자 추가 화면
	//요청 url : http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	//1번문제 : 판매자DB에 추가 => 입력성공페이지 이동
	//입력 action URL : http://localhost:8080/lesson04/quiz01/add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required=false) String profileImageUrl,
			@RequestParam(value = "temperature", required=false) Double temperature) {
		
		//DB insert -> bo 한테 시켜야함
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	
	//순서
	//1. 객체 생성 후 domain에 Seller 불러오기(getter/setter 다 생성) 
	//2. Controller에서 Seller불러오기 (임포트)
	//3. getSellerInfo.jsp 생성 후 부트스트랩, div등 생성
	//4. 조회하는 BO, Mapper, Mapper.xml 생성 - 다 연결시켜주고 b.p 걸어줘서 오류 없는지 확인  
	//참고 : 만약 오류가 발생한다면 요상한 targetException 어찌구가 뜬다..
		//이때 variables에서 f6번을 눌러서 새로운 targetException 탭이 뜨고 눌러보면
		// 메세지가 뜨는데, 메세지를 확인해보면 오류에 대한 메세지 확인 가넝
	// seller 안에 데이터가다 들어있는지 확인해야함
	
	//2번문제 : 가장 최근에 추가된 seller의 정보
	// http://localhost:8080/lesson04/quiz01/seller-info
//	@GetMapping("/seller-info") //주소치면 바로 나오니까 무조건 getMapping? 
//	public String sellerinfo(Model model) {
//		Seller seller = sellerBO.getLastSeller(); //1. 객체 생성 (sellerBO에게 요청) Seller 도메인 객체에서 한 행을 가져오게끔 필요! 
//		model.addAttribute("result", seller);
//		model.addAttribute("title", "판매자 정보");
//		return "lesson04/getSellerInfo";
//	}
	
	
	//3번 문제 : seller 검색 출력
	//2번 문제에서 만든 컨트롤러의 메소드를 재사용해서 id를 parameter로 받아서 해당하는 seller를 출력하세요.
	//id parameter가 없는 경우와 있는 경우 모두 처리 가능하도록 구현하세요.
	// URL : http://localhost:8080/lesson04/quiz01/seller-info?id=1
	@GetMapping("/seller-info") //주소치면 바로 나오니까 무조건 getMapping? 
	public String sellerinfo(
			@RequestParam(value="id", required=false) Integer id,
			Model model) {
		Seller seller = null;
		if (id==null) {
			seller = sellerBO.getLastSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		model.addAttribute("result", seller);
		model.addAttribute("title", "판매자 정보");
		return "lesson04/getSellerInfo";
	}
	
}















