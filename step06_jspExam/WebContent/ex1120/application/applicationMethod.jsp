<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> ServletCoctext - application 관련 메소드 </h1>
<h3>

application.getContextPath() : <%=application.getContextPath() %><br>
application.getRealPath("/") : <%=application.getRealPath("/ex1120_solution1/save") %><br>
application.getMajorVersion() : <%=application.getMajorVersion() %><br>
application.getMinorVersion() : <%=application.getMinorVersion() %><br>
application.getServerInfo() : <%=application.getServerInfo() %><br>
application.getServletContextName() : <%=application.getServletContextName() %><br>

<%
  //application정보 저장하기
  application.setAttribute("addr", "판교");
  application.setAttribute("message", "application실습중");
  
%>
  저장된 정보 출력하기 <p>
  주소 : <%=application.getAttribute("addr") %><br>
  메시지 : <%=application.getAttribute("message") %><br>
  
  <a href="../session/sessionGet.jsp">확인하러가자</a>
</h3>
</body>
</html>