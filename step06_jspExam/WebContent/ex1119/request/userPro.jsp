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
<%

	request.setCharacterEncoding("UTF-8");
	//모든 parameter name을 가져오기
	Enumeration<String> e = request.getParameterNames();
	while(e.hasMoreElements()){ //요소가 있는지 없는지 체크(있는동안 반복)
		String name = e.nextElement();//꺼내기
		String value = request.getParameter(name);
		out.println(name+":"+ value +"<br>");
	}
%>
</body>
</html>