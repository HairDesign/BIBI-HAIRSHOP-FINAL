<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>지역을 선택 해주세요.</title>
<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/layoutCom.css">
<link rel="stylesheet" href="./resources/css/regionSelection.css">
<link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">
</head>
<body>
<a href=/hairShops/main.jsp class="return">홈으로 </a>
<div class="wrapperGray">
		<section class="layer">
			<div class="contents">

				<h3 class="txt1">지역을 선택 해주세요.</h3>
				<ul class="regionSelection">
					<li class="gubun1"><a href="/dosim">도심권</a><li>
					<li class="gubun2"><a href="/dongnam">동남권</a><li>
					<li class="gubun3"><a href="/dongbuk">동북권</a><li>
					<li class="gubun4"><a href="/seonam">서남권</a><li>
					<li class="gubun5"><a href="/seobuk">서북권</a><li>
				</ul>				
				<div class="regionImg">지역 선택</div>

			</div>

		</section>

	</div>
	
<h1> 지역을 선택 해주세요</h1>
</br>
<img src = "./resources/img/region.png"></img>
</br>
<form action="/hairshopList" method="post">
	<select name ="location">
		<option value="도심권">도심권</option>
		<option value="동남권">동남권</option>
		<option value="동북권">동북권</option>
		<option value="서남권">서남권</option>
		<option value="서북권">서북권</option>
	</select>
	</br>
	<input type="submit" value="추천 헤어샵 보기"></input>
</form>
</body>
</html>