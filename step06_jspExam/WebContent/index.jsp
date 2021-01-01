<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1> Jsp 시작하기 </h1>

<%
	//java문법 100%사용
	String name="수녕"; //지역변수 이므로 반드시 초기화!!!!!!
	int age = 20;
	
	//출력(콘솔창에 출력)
	System.out.println("난 어디에 출력되니");
	
	//브라우저에 출력
	out.println("그럼 난 어디에 출력되니");
	
	List list;
	Date date;
	
%>

<h3>이름 : <%=name%> 입니다.</h3>
<h3>나이 : <%=age%> 살</h3>

<h4> 메소드 호출 : <%=test() %></h4>

<%!
	String addr; //전역변수
	int age;
	public String test(){ //메소드는 반드시 느낌표 안에서만 가능
		System.out.println("test() 호출됨..");
		return "방가방가";
	}
	
%>

</body>
</html>