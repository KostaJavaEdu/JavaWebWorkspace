<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    
    <%
    response.setStatus(200);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3> 오류 발생했습니다.</h3>
exception : <%=exception %><br>
getMessage : <%=exception.getMessage() %><br>
getClass : <%=exception.getClass() %><br>
</body>
</html>