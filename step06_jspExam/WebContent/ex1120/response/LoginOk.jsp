<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3><%=request.getParameter("name")%> 님 로그인 되었습니다.</h3>

<!-- forward방식으로 이동 할때는 userName으로 쓰고 redirect방식으로 할때는 name 써야함 -->

</body>
</html>