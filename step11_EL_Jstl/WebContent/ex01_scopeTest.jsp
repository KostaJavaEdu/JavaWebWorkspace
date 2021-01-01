<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3>Scope에 있는 정보 표현언어로 가져오기 </h3>
<h3>
 id : ${id }<br>
 message : ${message }<br>
 hobby : ${hobby }<br>
 message : ${applicationScope.message }<br></h3>
</body>
</html>