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
HttpSession의 저장된 정보를 가져오기<br>
아이디 : <%=session.getAttribute("id") %><br>
취미 : <%=session.getAttribute("hobbys") %><br>
메시지 : <%=session.getAttribute("message") %><br>

<hr color="red">

  ServletContext 저장된 정보 출력하기 <p>
  주소 : <%=application.getAttribute("addr") %><br>
  메시지 : <%=application.getAttribute("message") %><br>
  
</h3>
</body>
</html>