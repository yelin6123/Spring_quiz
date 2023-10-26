package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookmarkBO;
import com.quiz.lesson06.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;

	//------ quiz01 -------
//	아래 입력 화면을 통해서 새로운 즐겨 찾기 목록을 추가하세요.
//	모든 칸에 입력되었는지 validation 코드를 추가하세요.
//	http 또는 https 프로토콜까지 모두 입력되었는지 validation 코드를 추가하세요.
//	form submit 을 사용하지 않고 ajax 를 이용해서 수행하세요.
	
	//즐겨찾기 화면 
	//url : http://localhost:8080/lesson06/quiz01/add-bookmark-view
	@GetMapping("/quiz01/add-bookmark-view")
	public String addbookmarkView() {
		return "/lesson06/addbookmark";
	}
	
	//add-bookmark 즐겨찾기 추가 로직 추가!!! - AJAX가 하는 요청 
	@ResponseBody
	@PostMapping("/quiz01/add-bookmark")
	public Map<String, Object> addBookmark( 
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
			
		//DB insert
		bookmarkBO.addBookmark(name, url);
		
		//응답값 : String -> JSON(map) String 으로 ==> jsp (AJAX 서버 요청 success도 바껴야함)
//		{
//			"code":200,
//			"result":"success"
//		}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result; //JSON String >> 
		
	}
	
	//즐겨찾기 목록 화면 
	@GetMapping("/quiz01/bookmark-list-view")
	public String bookmarkListView(Model model) {
		List <Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return	"lesson06/bookmarkList";
	}
	
	//------ quiz01 끝 -------
	
	//즐겨찾기 화면과 목록화면에 대해 mapping, jsp 연결 완료
	//List<Bookmark> bookmarkList 만들고 model.addAttribute 해주기
	//model 에 일단 담기
	//bookmark DB domain에 추가 => controller에 import 가능 
	// BO, Mapper, xml(select)연결
	// bo => controller에서 불러오기,model 에 저장 확인
	// 결과 확인페이지에서 c:forEach 해 불러오기
	//<td><a href="${bookmark.url} target="_blank">${bookmark.url}</a></td> 
	//  ㄴ a태그는 utl사이트와 연결 / target="_blank" : 새탭으로 띄우기
//	<div class="form-group">
//		<label for="name">제목</label>
//		<input type="text" id="name" class="form-control col-9">
//			- Id : ajax 에이젝스를 위해 필요함
//			- form-control : 모양을 꾸며주기 위해
//	</div>
	//<script> 제이쿼리로 인터넷 연결! : $(document).ready(function(){}
	//jquery의 AJAX 통신 이용하기  : $("#addBtn").on('click', function() {
	//틈틈히 alert으로 통신이되는지 확인!!!
	//validation (검증) 체크 
	// AJAX 서버 요청 $.ajax({ request, response !!!!!!})  > 확인까지!
	//add-bookmark 즐겨찾기 추가 로직 추가!!! - AJAX가 하는 요청 
	//db insert 
	
	
	
}
