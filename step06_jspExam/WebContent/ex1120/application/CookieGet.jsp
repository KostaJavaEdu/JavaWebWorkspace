<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> Cookie정보 확인하기 </h1>
<%
	Cookie cookies [] = request.getCookies();
	if(cookies==null){
		out.println("쿠기정보가 없습니다.");
	}else{
		out.println("쿠기개수 : " + cookies.length + "<br>");
		for(Cookie co : cookies){
			out.println(co.getName()+":"+co.getValue()+"<br>");
		}
	}
%>
</body>
</html>