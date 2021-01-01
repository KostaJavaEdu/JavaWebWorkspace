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
String id = request.getParameter("userId");
String pwd = request.getParameter("userPwd");
String name = request.getParameter("userName");

String m_id = "suoung0716";
String m_pwd = "1234";
	
	//if(id.equals(m_id) && pwd.equals(m_pwd)){ //아래 걸로 비교하는게 더 버그가 날 확률이 적다!! id,pwd,name은 null일 가능성 있어 -> nullpointException
	if(m_id.equals(id) && m_pwd.equals(pwd)){
		response.sendRedirect("LoginOk.jsp?name="+URLEncoder.encode(name,"UTF-8")); //기존 request와 response를 버리고 새로운 객체를 만듬
		
		//forward방식으로 이동
		//RequestDispatcher rd = request.getRequestDispatcher("LoginOk.jsp");
		//rd.forward(request, response);
				
	}else{
		%>
			<script type="text/javascript">
			 alert("<%=name%>정보를 확인해주세요.");
			 //location.href="LoginForm.html";
			 history.back();
			</script>
		<%
		//response.sendRedirect("LoginForm.html"); //메시지 출력과 서버에서 이동하는 방식 같이 못써!!
	}
%>

</body>
</html>