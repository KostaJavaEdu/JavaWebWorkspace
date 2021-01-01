<%@page import="java.util.Date"%>
<%@page import="java.net.URLEncoder"%>
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
String userId = request.getParameter("userId");
String userPwd = request.getParameter("userPwd");
String userName = request.getParameter("userName");

String m_id = "suoung0716";
String m_pwd = "1234";
	
	if(m_id.equals(userId) && m_pwd.equals(userPwd)){
		session.setAttribute("name", userName);
		session.setAttribute("id", userId);
		session.setAttribute("time", new Date().toLocaleString());
		
		//쿠키에 저장하기
		Cookie co = new Cookie("CookieId",userId);
		co.setMaxAge(60*60*24*365);
		co.setPath("/");
		response.addCookie(co);
		
		response.sendRedirect("LoginOk.jsp");
				
	}else{
		%>
			<script type="text/javascript">
			 alert("<%=userName%>정보를 확인해주세요.");
			 history.back();
			</script>
		<%
	}
%>
</body>
</html>