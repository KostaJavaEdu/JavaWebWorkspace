<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> Upload 결과 </h1>
<h3>
작성자 : ${requestScope.name}<p>
제목 : ${subject}<p>
첨부파일이름(fileSystem) : ${fileSystemName}<p>
첨부파일이름(Original) : ${fileOriginalName}<p>
파일용량 : <fmt:formatNumber value="${fileSize}"/><p>
경로 : ${saveDir}<p>
</h3>
</body>
</html>