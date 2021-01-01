<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3>
<% //post방식 한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");
%>
이름 : <%=request.getParameter("name") %><br>
나이 : <%=request.getParameter("age") %><br>
취미 : 
	<%
		String hobbys[] = request.getParameterValues("hobby");
		for(String h : hobbys){
			out.println(h+",");
		}
	%><br>
	
접속자 IP : <%=request.getRemoteAddr() %>
	
</h3>

</body>
</html>