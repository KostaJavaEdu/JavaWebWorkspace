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
if(session.getAttribute("id")==null){
	%>
	<form method="get" action="<%=application.getContextPath()%>/login">
		ID : <input type="text" name="userId" /><br /> 
		PWD : <input type="password" name="userPwd" /></br/> 
		NAME : <input type="text" name="userName" /></br/> 
		<input type="submit" value="로그인" />
	</form>
	<%
}else{
	//이름과 접속시간 출력
	%>
	<%=session.getAttribute("name") %>님  로그인중...
	접속시간 <%=session.getAttribute("loginTime") %>
	<button type="button">로그아웃</button>
	<%
}
%>
</body>
</html>