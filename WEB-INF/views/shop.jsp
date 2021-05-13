<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:forEach var ="shop" items="${shoplist }">
	<tr>
	<td>${shop.shopname }</td>
	<td>${shop.topic1 }</td>
	
	</tr>

</c:forEach>



</body>
</html>