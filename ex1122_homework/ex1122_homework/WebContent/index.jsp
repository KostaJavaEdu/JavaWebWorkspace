<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  header{width:800px; height: 100px;}
  aside{width: 200px; height: 400px;  float: left;}
  section{width: 600px; height: 400px;float: left;}
  footer{width: 800px; height: 50px; clear: both;}
</style>
</head>
<body>
<header><jsp:include page="top.jsp"></jsp:include></header>
<aside><iframe src = "left.jsp" name="A" frameborder="0" width="100%" height="100%"></iframe></aside>
<section><iframe src = "center.jsp" name="B" frameborder="0" width="100%" height="100%"></iframe></section>
<footer><jsp:include page="footer.jsp"></jsp:include></footer>
</body>
</html>

