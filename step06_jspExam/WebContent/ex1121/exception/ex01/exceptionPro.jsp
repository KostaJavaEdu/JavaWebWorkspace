<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%
int num1=0;
int num2=0;

	//넘어오는 두개의 값을 받아서 합계를 구한다.
	 num1 = Integer.parseInt(request.getParameter("num1"));
	 num2 = Integer.parseInt(request.getParameter("num2"));
	
%>
<h1> <%=num1 %>+<%=num2 %>=<%=num1+num2 %></h1>
</body>
</html>