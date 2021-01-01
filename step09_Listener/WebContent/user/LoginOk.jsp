<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=application.getContextPath()%>/js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
  $(function(){
	  $("button").click(function(){
		 if(confirm("정말 아웃 할래요?")){
			 location.href="<%=application.getContextPath()%>/logout";
		 }
	  })
  })
</script>
</head>
<body>
<%
  response.setHeader("Cache-Control","no-store");

  if(session.getAttribute("id")==null){//인증했니?
	 out.println("<script>");
	 out.println("alert('로그인하고 이용해주세요.')");
	 out.println("location.href='LoginForm.jsp'");
	 out.println("</script>");
  }else{
	 %>
	  <h3><%=session.getAttribute("name")%> 님 로그인 중 
	     [접속시간 : <%=session.getAttribute("loginTime") %>]<br>
	     <img src="img/test.jpg"> <p>
	     <button type="button">로그아웃</button>
	  </h3>
	 <%
  }
%>
</body>
</html>