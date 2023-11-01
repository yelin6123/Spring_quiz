<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가 화면</title>
<!-- bootstrap CDN link -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<!-- AJAX를 사용하려면 반드시 jquery 원본 필요 (slim 제거) -->
	<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		
		<div class="form-group">
			<label for="name">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		
		<div class="form-group">
			<label for="url">주소</label>
			<div class="d-flex">
			<input type="text" id="url" class="form-control">
			<input type="button" id="checkBtn" class="btn btn-info ml-2" value="중복확인">
			</div>
		</div>
		<input type="button" id=addBtn class="btn btn-success w-100" value="추가">
	</div>
	
	<script>
		$(document).ready(function() {
			$('#addBtn').on('click', function() {
				//alert('클릭')
				
				//validation
				let name = $('#name').val().trim();
				let url = $('#url').val().trim();
				
				console.log(name);
				console.log(url);
				
				if(!name) {
					alert('제목을 입력하세요.')
					return
				}
				if(!url) {
					alert('주소를 입력하세요.')
					return
				}
				
				//조건2 
				if(url.startsWith('http://') == false &&
						url.startsWith('https://') == false) {
					alert('주소를 다시 입력하세요.')
				}
				
				//AJAX서버 요청
				$.ajax({
					//request
					type:"post"
					, url:"/lesson06/quiz02/add-bookmark"
					, data:{"name":name, "url":url}
						
					//response
					, success:function(data){
						if(data.code==200) {
							location.href =  "/lesson06/quiz02/add-bookmark-list";
						}
					}
					, error:function(request, status, error){
						alert('에러가 났습니다.')
					}
												
				});
			});
		});
		
		
	
	</script>
</body>
</html>