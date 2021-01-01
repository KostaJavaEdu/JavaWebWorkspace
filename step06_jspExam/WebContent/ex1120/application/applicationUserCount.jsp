<%@page import="java.util.concurrent.atomic.AtomicInteger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<%--
	//기존 방문자 수를 가져오기
	 Object visit = application.getAttribute("people");
	//만약 값이 없다면 설정 
	if(visit==null){
		application.setAttribute("people", 0);
		visit = application.getAttribute("people");
	}
	
	Integer it = (Integer)visit;
	if(session.isNew()){
		it++;
		application.setAttribute("people", it);
	}
	
	
	//있다면 읽어와서 1증가하고 다시 저장한다.
--%>

<%
	Object visit = application.getAttribute("people");
	if(visit==null){
		application.setAttribute("people", new AtomicInteger());
		visit = application.getAttribute("people");
	}

	AtomicInteger at = (AtomicInteger)visit;
	int count = at.get();
	if(session.isNew()){
		count = at.incrementAndGet();
	}
%>

<h3> [방문자 수 :<%=count %> 명]</h3>
</body>
</html>