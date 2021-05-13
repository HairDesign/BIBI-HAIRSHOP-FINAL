<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Template</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./resources/css/normalize.css">
<link rel="stylesheet" href="./resources/css/layoutCom.css">
<!-- <link rel="stylesheet" href="./css/imgUpload.css"> -->
<link rel="shortcut icon" href="./resources/img/favicon.ico" type="image/x-icon">
<link rel="icon" href="./resources/img/favicon.ico" type="image/x-icon">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<style>
.drag-over { background-color: #ff0; }
.helper {width:0px; height:100%; display: table-cell; vertical-align:middle;}
.thumb { width:250px; padding:1px; float:none; display: inline-block;}
.thumb > img { width:100%; }
.thumb > .close { position:absolute; background-color:black; cursor:pointer; }
.drop{display: table;}
</style>
</head>
<body>
<a href="/main" class="return">홈으로 </a>

<div class="wrapperPink">
		<section class="layer">
				<div id="drop" style="position:relative; top:50px; left:900px; border:2px dashed white; width:300px; height:300px; padding:3px">
				<div id="helper">
				<div id="thumbnails">
				</div>
				</div>	
				</div>
				</br>
				</br>
				</br>
				<h2 class="txt1">
					이미지를 올려보세요!
				</h2>
				<input type="button" class="button" id="btnSubmit" value="업로드"/>
			<h3 class="txt2">
				딥러닝 기반 인공지능 모델이<br> 당신의 얼굴형을 찾아 줄 거예요.
			</h3>
			<h3 class="txt3">* 업로드한 사진은 저장되지 않습니다.</h3>
			<form action="/facetypeLoading" method="post">
				<input type="submit" class="button" value="결과 보기"></input>
			</form>
		</section>

	</div>
	
<div id="drop" style="border:1px solid black; width:800px; height:300px; padding:3px">
이미지를 올려보세요!
<div id="thumbnails">
</div>
</div>
</br>
<form action="/facetypeLoading" method="post">
	<input type="submit" value="결과 보기"></input>
</form>
<script>
var uploadFiles = [];
var $drop = $("#drop");
$drop.on("dragenter", function(e) { //ëëê·¸ ììê° ë¤ì´ììë
$(this).addClass('drag-over');
}).on("dragleave", function(e) { //ëëê·¸ ììê° ëê°ìë
$(this).removeClass('drag-over');
}).on("dragover", function(e) {
e.stopPropagation();
e.preventDefault();
}).on('drop', function(e) { //ëëê·¸í í­ëª©ì ë¨ì´ë¨ë ¸ìë
e.preventDefault();
$(this).removeClass('drag-over');
var files = e.originalEvent.dataTransfer.files; //ëëê·¸&ëë í­ëª©
if (files.length > 1) {
    alert('하나의 이미지만 올려주세요.');
    return;
}
for(var i = 0; i < files.length; i++) {
var file = files[i];
var size = uploadFiles.push(file); //ìë¡ë ëª©ë¡ì ì¶ê°
preview(file, size - 1); //ë¯¸ë¦¬ë³´ê¸° ë§ë¤ê¸°
}
if (files[0].type.match(/image.*/)) {
    
}else{
    alert('이미지가 아닙니다.');
    return;
}
});
function preview(file, idx) {
var reader = new FileReader();
reader.onload = (function(f, idx) {
return function(e) {
var div = '<div class="thumb"> \
<div class="close" data-idx="' + idx + '">X</div> \
<img src="' + e.target.result + '" title="' + escape(f.name) + '"/> \
</div>';
$("#thumbnails").append(div);
};
})(file, idx);
reader.readAsDataURL(file);
}
$("#btnSubmit").on("click", function() {
var formData = new FormData();
$.each(uploadFiles, function(i, file) {
if(file.upload != 'disable') //ì­ì íì§ ìì ì´ë¯¸ì§ë§ ìë¡ë í­ëª©ì¼ë¡ ì¶ê°
formData.append('upload-file', file, file.name);
});
$.ajax({
url: '/imgUpload/post',
data : formData,
type : "POST",
contentType : false,
processData: false,

});
});
$("#thumbnails").on("click", ".close", function(e) {
var $target = $(e.target);
var idx = $target.attr('data-idx');
uploadFiles[idx].upload = 'disable'; //ì­ì ë í­ëª©ì ìë¡ëíì§ ìê¸° ìí´ íëê·¸ ìì±
$target.parent().remove(); //íë¦¬ë·° ì­ì 
});
</script>
</body>
</html>