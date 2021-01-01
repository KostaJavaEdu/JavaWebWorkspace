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
if(session.getAttribute("id")!=null){
	%>
	<form action="<%=application.getContextPath()%>/board" method="post">
	내용 : <input type = "text" name="content"/> <input type="submit" value="입력" />
	</form>
	<%
}else{
	%>
	<h3> </h3>
	<%
}
	%>

</body>
</html>