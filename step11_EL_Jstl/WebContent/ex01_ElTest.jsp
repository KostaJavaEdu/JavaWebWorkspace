<%@page import="ex1125.el.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> EL - 표현 언어 </h1>
\${5} = ${5} <p>
\${5+3} = ${5+3} <p>
\${5/2} = ${5/2} <p>
\${5 gt 3} = ${5 gt 3} <p>
\${5 lt 3 || 4 < 3} = ${5 lt 3 || 4 < 3} <p>
\${5 > 3 ? "맞다" : "틀리다"} = ${5 > 3 ? "맞다" : "틀리다"} <p>

<!-- 
만약,
	http://localhost:8000/step11_EL_Jstl/ex01_ElTest.jsp?age=24
	요청이 되면 나이가 18보다 크면 성인, 아니면 미성년자 출력 -->
${param.age > 18 ? "성인" : "미성년자" }<p>

<!-- 
만약,
	http://localhost:8000/step11_EL_Jstl/ex01_ElTest.jsp?age=24&id=choi
	요청이 되면 아이디가 있다면 id님 출력, 없으면 Guest님 출력 -->
${param.id == null ? "Guest" : param.id}님 <p>
${empty param.id ? "Guest" : param.id}님 <p>

${param.id != null ? param.id : "Guest"}님 <p>
${not empty param.id ? param.id : "Guest"}님 <hr>

${param.id != null ? param.id+="님" : "Guest".concat("님")} <p>

<%
	//scope영역에 저장
	request.setAttribute("id", "choi");
	
	session.setAttribute("addr", "판교");
	session.setAttribute("message", "EL실습중...");
	
	application.setAttribute("message", "오늘은 월요일~~");
	application.setAttribute("hobby", "놀고 먹기");

%>
Scope에 저장된 데이터 가져오기 <p>
id : <%=request.getAttribute("id") %> / ${requestScope.id }<br>
addr : <%=session.getAttribute("addr") %> / ${sessionScope.addr }<br>
message : <%=session.getAttribute("message") %> / ${sessionScope.message }<br>
message : <%=application.getAttribute("message") %> / ${applicationScope.message }<br>
hobby : <%=application.getAttribute("hobby") %> / ${applicationScope.hobby }<br>

<!-- 
	pageScope < requestScope < sessionScope < applicationScope
	
	: 위 키워드는 생략이 가능함
	  ex) ${requestScope.id} -> ${id} 가장 낮은 범위부터 찾아가 이름이 중복됐을 때 
									낮은 범위에 있는 것 나옴
-->
 <hr>
 id : ${id }<br>
 message : ${message }<br>
 hobby : ${hobby }<br>
 message : ${applicationScope.message }<br>
 
<a href="ex01_scopeTest.jsp">확인하러가자</a> <p>

<hr>

<h2> 자바 Bean(객체=클래스) 사용하기 </h2>
<%--
	Product p = new Product();
	String code = p.getCode();
--%>

<!-- 객체생성 -->
<jsp:useBean id="p" class="ex1125.el.Product"></jsp:useBean>

상품코드 : ${p.code } / <%=p.getCode() %> / ${p.getCode()} <!-- p.getCode()를 호출 --><br>
상품이름 : ${p.name} <br>
상품가격 : ${p.price } <br>
상품수량 : ${p.qcy } <br> 
총 금액 : ${p.price*p.qcy } <br>

</body>
</html>