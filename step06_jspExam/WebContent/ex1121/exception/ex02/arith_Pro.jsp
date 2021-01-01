<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
	//전송된 데이터로 나누기
	int num1 = Integer.parseInt(request.getParameter("num1"));

	int result = 100/num1;
%>
web.mal설정<p>
<h1> 나눈 결과 : 100/<%=num1 %> = <%=result %></h1>
</body>
</html>