<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
$(function() {
	$("[type=button]").click(function() {
		if(confirm("정말 아웃 할래요?")){
			location.href="../logout";
		}
	})
})
</script>
</head>
<body>
<%
response.setHeader("Cache-Control","no-store");//로그아웃 하고 뒤로가기 눌렀을때 다시 로그인 하고오라고 해주기 위해!!!!

if(session.getAttribute("id")==null){//인증했니?
	%>
	<script type="text/javascript">
	 alert("로그인하고 오세요.");
	 location.href="LoginForm.jsp";
	</script>
<%
}else{
	%>
	<h3><img src="heart.png"><%=session.getAttribute("name")%>님 접속되었습니다.[접속시간:<%=session.getAttribute("time")%>]</h3>
	<button type="button" name="logout">로그아웃</button>	
	<%
}
%>
</body>
</html>