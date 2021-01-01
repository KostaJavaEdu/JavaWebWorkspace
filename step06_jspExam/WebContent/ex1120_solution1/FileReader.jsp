<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%-- <h3><%= path +"/"+name+"_"+System.currentTimeMillis()+".txt"%> 폴더 LIST</h3><br> --%>

<ul>
<%
	String path=application.getRealPath("/ex1120_solution1/save/");
	File file = new File(path);
	String paths[] = file.list();
	for(String p : paths){
		out.println("<li>");
		out.println(URLEncoder.encode(p,"UTF-8"));
		out.println("</li>");
	}
%>
</ul>
</body>
</html>