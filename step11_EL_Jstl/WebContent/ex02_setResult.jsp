<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>&lt;c:set> 결과 확인하기 </h1>

<h3>
  set에 저장된 데이터 출력 <br>
  아이디 : ${id } / <c:out value="${id}"></c:out> <br>
  나이 : ${age } / <c:out value="${age}"/> <br>
  메시지 : ${message } / <c:out value="${message}"/> <br>
  
  <c:remove var="message"/>
  
  <h3> 제거 후 </h3>
  set에 저장된 데이터 출력 <br>
  아이디 : ${id } / <c:out value="${id}"></c:out> <br>
  나이 : ${age } / <c:out value="${age}"/> <br>
  메시지 : ${message } / <c:out value="${message}"/> <br>
</h3>

</body>
</html>