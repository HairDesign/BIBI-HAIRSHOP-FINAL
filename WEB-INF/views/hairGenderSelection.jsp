<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성별을 선택해주세요.</title>
<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/maleFemale.css">
<!-- <link rel="stylesheet" href="./css/layoutCom.css">
 -->
<link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">
</head>
<body>
	<a href="/main" class="return">홈으로 </a>

	<div class="wrapperGray">
		<a href="/hairMale" class="maleWrapper">
			<section class="maleGray">
				<div class="maleImg">남성</div>
				<div class="maleTxt">남성입니다</div>
			</section>
		</a> <a href="/hairFemale" class="femaleWrapper">
			<section class="femaleGray">
				<div class="femaleImg">여성</div>
				<div class="femaleTxt">여성입니다</div>
			</section>
		</a>

	</div>
</body>
</html>