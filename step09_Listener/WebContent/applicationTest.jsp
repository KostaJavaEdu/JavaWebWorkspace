
<%@page import="java.util.Map"%>
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
Map<String, String> map = (Map<String, String>)application.getAttribute("map");

	out.println("<fieldset>");
	out.println("<legend>나라선택</legend>");
	for( String key : map.keySet()){
		String value = map.get(key);
		%>
		<input type="radio" name="nation" value="<%=key%>"> <%=value%>
	<%
	}
	out.println("</fieldset>");
%>
</body>
</html>