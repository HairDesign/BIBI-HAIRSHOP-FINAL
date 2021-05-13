<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이 머리 뭐에요?</title>
<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/layoutCom.css">
<link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">
</head>
<body>
	<a href=/main class="return">홈으로 </a>
	<div class="wrapperGray">
		<section class="layer">
			<div class="contents">
				<div class="faceShapeImg">
					헤어스타일 분석 결과
					<!--<h2 class="txt1">이미지를 <br>올려보세요!</h2> -->
				</div>
				<h3 class="txt1">업로드한 헤어스타일은</h3>
			</div>
			<h3 class="faceShapeResult">" ${result } "</h3>
			<h3 class="txt3">
			</h3>
			<form action="selectLocation" method="post">
			<button class="button" name="button">추천 미용실 보기</button>
			</form>
		</section>

	</div>
</body>
</html>