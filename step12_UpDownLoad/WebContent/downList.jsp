<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  a{text-decoration: none}
</style>
</head>
<body>
<h1> 다운로드 목록 LIST </h1>
<ul>
  <c:forEach var="fileName" items="${requestScope.fileNames}">
	  <li><a href="downLoad?fileName=${fileName}" >${fileName}</a></li>
  </c:forEach>
</ul>
<hr color="red">
<%
	String fileNames [] = (String [])request.getAttribute("fileNames");
	
	for( String fileName : fileNames){
		String encoding = URLEncoder.encode(fileName,"UTF-8");
		%>
		<li><a href="downLoad?fileName=<%=encoding%>" ><%=fileName %></a></li>
		<%
	}
%>
</body>
</html>