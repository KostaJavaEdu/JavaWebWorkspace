<%@page import="ex1125.jstl.ForEachBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {width: 500px; border: 3px double red; border-collapse: collapse;}
	th,td{border: 1px gray solid; text-align: center; padding: 5px}
</style>
</head>
<body>
<h1> &lt;c:forEach> 실습하기</h1>

<c:forEach var="i" begin="0" end="10" step="1">
	${i} <br>
</c:forEach>

<hr>
<%
	String hobbys [] = {"등산","수영","낚시","골프","놀기"};
%>

<c:forEach var="hobby" items="<%=hobbys%>" varStatus="stat">
	<input type="checkbox" value="${hobby}"> ${hobby} / ${stat.index} / ${stat.count}
</c:forEach>

<hr>

<jsp:useBean id="bean" class="ex1125.jstl.ForEachBean"></jsp:useBean>
<!-- 이름은 select박스로 출력 -->
<select name="name">
<option>--선택--</option>
<c:forEach var="name" items="${bean.names}" varStatus="state">
		<option value="${state.count}">${name}</option>
</c:forEach>
</select>

<!-- 메뉴는 radio박스로 출력 -->
<fieldset>
<legend>메뉴선택</legend>
	<c:forEach var="menu" items="${bean.menus}">
		<input type="radio" value="${menu}"> ${menu} 
	</c:forEach>
</fieldset> <br>

<!-- memberList는 테이블로 출력 -->
<h3>회원정보 List</h3>
<table>
	<tr>
		<th>순서</th><th>id</th><th>name</th>
		<th>age</th><th>addr</th>
	</tr>
<c:forEach var="list" items="${bean.memberList}" varStatus="st">
	<tr>
		<td>${st.count}</td>
		<td>${list.id}</td>
		<td>${list.name}</td>
		<td>${list.age}</td>
		<td>${list.addr}</td>
	</tr>
</c:forEach>
</table>

<!-- map 출력 -->

<h3>Map 데이터 가져오기</h3>
<c:forEach var="m" items="${bean.map}">
	${m.key} = ${m.value} <br>
</c:forEach>

<hr>
 
가격 : 35400000원 /
<fmt:formatNumber value="35400000"/>원


</body>
</html>