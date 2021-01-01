<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> request Header 정보 가져오기 </h1>
<%
	Enumeration<String> e = request.getHeaderNames();
	while(e.hasMoreElements()){
		String name = e.nextElement();
		String value = request.getHeader(name);
		out.println(name+ "=" + value +"<br>");
	}
%>
<hr>

request.getContextPath() : <%=request.getContextPath() %><p>
request.getRealPath("/") : <%=request.getRealPath("/") %><p>
request.getRequestURL() : <%=request.getRequestURL() %><p>

</body>
</html>