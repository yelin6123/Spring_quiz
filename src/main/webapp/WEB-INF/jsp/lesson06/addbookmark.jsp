<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 jquery 원본 필요 (slim 제거) -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="ml-3 container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="url">주소</label>
			<input type="text" id="url" name="url" class="form-control">
		</div>
		<input type="button" id="addBtn" class="btn btn-success w-100" value="추가">
	</div>
	
	<script>
		//제이쿼리로 인터넷 연결!
		$(document).ready(function() {
			//jquery의 AJAX 통신 이용하기 
			$("#addBtn").on('click', function() {
				//alert("버튼 클릭");
				

				//validation (검증) 체크 
				let name = $("#name").val().trim();
				let url = $("#url").val().trim();
				
				console.log(name);
				console.log(url);

				if(!name) {
					alert("제목을 입력하세요.");
					return; //form 이벤트로 잡았을 경우 return false;로 끝내야함!
				}
				if(!url) {
					alert("주소를 입력하세요.");
					return;
				}
				
				
				// 조건 2) http *또는* https 프로토콜까지 모두 입력되었는지 validation 코드를 추가하세요.
				if(url.startsWith("http://") == false &&
						url.startsWith("https://") == false) {
					alert("주소 형식이 잘못 되었습니다.")
					return;
				}
				
				
				// AJAX 서버 요청
				$.ajax({
					//request (요청)
					type:"post"
					, url:"/lesson06/quiz01/add-bookmark" //새로 만들어야함 jsp
					, data:{"name":name, "url":url} //내가 파라미터를 보낸다! json형식으로!
					
					//response (응답)
					//call back 함수!!!!
					//일반 String일 때
					/* , success:function(data) { //data : response 응답값(String)
						if(data =="성공") {
							location.href = "/lesson06/quiz01/bookmark-list-view"
						}
					} */
					//JSON String으로 내릴때 
					, success:function(data) { //data : response 응답값(JSON String) => Dictory Object
						//data 는 JSON String = > Object 변환된 형태로 사용할 수 있따
						//jquerydml ajax 함수 기능임
							/* alert(data.code);
							alert(data.result); */
						if(data.code == 200) { //date.result == 'success'
							location.href = "/lesson06/quiz01/bookmark-list-view"
						}
					}
					//call back 함수!!!!
					, error:function(request, status, error) {
						alert("추가에 실패했습니다. 관리자에게 문의해주세요.");
					}
				})
				
			});
		});
	
	</script>
	
	
</body>
</html>