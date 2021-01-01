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
	request.setCharacterEncoding("UTF-8");
	int sum=0;
	for(int i=1; i<=10; i++){
		//out.println(i+"<br>"); //브라우저에 출력
		sum+=i;
	}
%>

<jsp:forward page="forwardResult.jsp"> 
<jsp:param value="<%=sum%>" name="total"/>
<jsp:param value="수녕" name="name"/>
</jsp:forward>
</body>
</html>