<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신의 얼굴형은...?</title>
<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/layoutCom.css">
<link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">
</head>
<body>
	<a href=/main class="return">홈으로 </a>
	<div class="wrapperPink">
		<section class="layer">
			<div class="contents">
				<!-- <div class="faceShapeImg">
					얼굴형 결과
					<h2 class="txt1">이미지를 <br>올려보세요!</h2>
				</div> -->
				<img src="./resources/img/${imgsrc }">
				</img> 
				</br>
				</br>
				<h3 class="txt1">당신의 얼굴형은...!</h3>
			</div>
			<h3 class="faceShapeResult">" ${result } "</h3>
			<h3 class="txt3">
			<c:forEach begin="1" end="1" var ="fs" items="${face_style }">
				${fs.f_exp }
			</c:forEach>
			</h3>
			<form action="/facetypeHairrec" method="get">
			<button class="button" name="button">추천 헤어스타일 보기</button>
			</form>
		</section>

	</div>
</body>
</html>