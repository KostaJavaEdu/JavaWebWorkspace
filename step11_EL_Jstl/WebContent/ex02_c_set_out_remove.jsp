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
<h1> &lt;c:set> / &lt;c:out> / &lt;c:remove> 실습 </h1>
<h3>
<%
	String addr = "밥 먹으러 가요";
	//session.setAttribute("addr", addr);

%>
  <c:set var="id" value="choi" scope="session"/>
  <c:set var="age" value="24"/>
  <c:set var="message" value="배고프다" scope="application"/>
  <c:set var="addr" value="<%=addr %>"/>
  
  set에 저장된 데이터 출력 <br>
  아이디 : ${id } / <c:out value="${id}"></c:out> <br>
  나이 : ${age } / <c:out value="${age}"/> <br>
  메시지 : ${message } / <c:out value="${message}"/> <br>
  <hr>
  
  \${"<h1>안녕</h1>"} =  ${"<h1>안녕</h1>"} <p>
  <hr>
  <c:out value='${"<h1>안녕</h1>"}' escapeXml="true"/><p>
  <hr>
  <c:out value='${"<h1>안녕</h1>"}' escapeXml="false"/><p>
  <c:out value='${"<h1>안녕</h1>"}' /> <p>
  
  addr : <%=addr %> / ${addr } / <c:out value="${addr }"/><p>
  
  <c:out value="<%=addr %>"/>

</h3>

<a href="ex02_setResult.jsp">확인하러가자</a>

</body>
</html>