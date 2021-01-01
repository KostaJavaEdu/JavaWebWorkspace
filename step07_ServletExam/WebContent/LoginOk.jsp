<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> <%=request.getParameter("userName") %>님 로그인 성공 </h1>

<%
 List<String> list = (List<String>)request.getAttribute("fruits");
	out.println("<select>");
	for(String fruit : list){
		out.println("<option value="+fruit+">");
		out.println(fruit);
		out.println("</option>");
	}
	out.println("</select>");
%>
</body>
</html>