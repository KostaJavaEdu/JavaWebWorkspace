<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>파일이름 : <%=application.getInitParameter("fileName") %></h1>
<h1>메시지 : <%=application.getInitParameter("message") %></h1>
</body>
</html>