<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 회원 인증 Page</h2>
<%
   //쿠키정보 가져오기
   Cookie cokie [] =request.getCookies();
   String saveId="";
   if(cokie!=null){
	   for(Cookie co : cokie){
		   if(co.getName().equals("cookieID")){
			   saveId = co.getValue();
			   break;
		   }
	   }
   }
%>

<form method="post" action="<%=application.getContextPath()%>/loginCheck">
  ID : <input type="text" name="userId" value="<%=saveId%>"/><br/>
  PWD : <input type="password" name="userPwd" /></br/>
  NAME : <input type="text" name="userName" /></br/>
  
  <input type="submit" value="로그인" />
</form>

</body>
</html>