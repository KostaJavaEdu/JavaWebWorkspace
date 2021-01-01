
<%@page import="java.io.File"%>
<%@page import="java.io.FileWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%
long regDate = System.currentTimeMillis();
FileWriter fw = null;

	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	String path=application.getRealPath("/ex1120_solution1/save/");
	fw = new FileWriter(path +"/"+name+"_"+System.currentTimeMillis()+".txt");

	fw.write("작성자 : "+name+"/n");
	fw.write("제목 : " + subject+"/n");
	fw.write("내용 : " + content+"/n");
	fw.flush();
	
%>
<script>
	alert("<%=path%> +'/'+<%=name%>+'_'+<%=System.currentTimeMillis()%>+'.txt 파일이 생성되었습니다.'");
</script>
	
	
<%
	response.sendRedirect("FileReader.jsp");
%>
</body>
</html>