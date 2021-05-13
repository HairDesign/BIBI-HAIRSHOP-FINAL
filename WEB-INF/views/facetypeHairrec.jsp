<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>얼굴형에 따른 헤어추천!</title>
<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/layoutCom.css">
<link rel="stylesheet" href="./resources/faceShapeReco.css">
<link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">
</head>
<body>
	<a href=/main class="return">홈으로 </a>
	<div class="wrapperPink">
		<section class="layer">
			<div class="contents">
				<section class="hairReco">
					<div class="faceShapeImg1">추천1</div>
					<div class="faceShapeImg2">추천2</div>
					<div class="faceShapeImg3">추천3</div>
				</section>

				<h3 class="txt1">
					${result } 얼굴형을 가진 당신! <br> {C컬펌}, {허그컷}, {빌드펌} <br> 추천 드려요!
				</h3>
			</div>
			<h3 class="txt3">
				{계란형 얼굴형은 세로의 길이가 가로의 길이보다 <br> 길어 머리가 길어 보일 수 있으니 앞머리를 추천드려요
				ㅎㅎ}
			</h3>

		</section>

	</div>
</body>
</html>