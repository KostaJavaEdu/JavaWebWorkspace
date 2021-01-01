<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h3> Cookie - 필요한 정보를 서버가 클라이언트 쪽에 저장하는 것 </h3>
<%
	//쿠키생성
	Cookie co1 = new Cookie("id","choi");
	Cookie co2 = new Cookie("age","24");
	
	//쿠키 옵션 설정
	co1.setMaxAge(60*60*24); //1일(0이면 삭제, -1이면 저장안됨);
	//co2.setMaxAge(-1);
	co2.setMaxAge(60*60*24);
	
	co1.setPath("/");//
	//co2.setPath("/");
	
	//쿠키를 저장
	response.addCookie(co1);
	response.addCookie(co2);
%>

<a href="CookieGet.jsp">cookie</a>
</body>
</html>