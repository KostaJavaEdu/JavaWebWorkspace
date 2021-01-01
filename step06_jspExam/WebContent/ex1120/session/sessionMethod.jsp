<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//세션 timeout변경
    	session.setMaxInactiveInterval(30); //30초
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> HttpSession - session 메소드</h1>
<h3>
session.getId(): <%=session.getId() %><br>
session.getMaxInactiveInterval(): <%=session.getMaxInactiveInterval() %><br>
session.getCreationTime(): <%=session.getCreationTime() %><br>
session.getLastAccessedTime(): <%=new Date(session.getLastAccessedTime()).toLocaleString() %><br>
session.isNew(): <%=session.isNew() %><br>

<%
 //session에 정보 저장하기
session.setAttribute("id", "choi");
session.setAttribute("hobbys", new String[]{"등산","수영","낮잠","놀기","먹기"});
session.setAttribute("message", "session재밌다..");
%>
<hr>
저장된 정보를 가져오기<br>
아이디 : <%=session.getAttribute("id") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>
메시지 : <%=session.getAttribute("message") %><br>

<a href="sessionGet.jsp">이동하기</a>
</h3>
</body>
</html>