<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="ex1122_homework.BoardDTO"%>
<%@page import="java.util.List"%>
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
	List<BoardDTO> boardList = (List<BoardDTO>)application.getAttribute("boarList");
			%>
			<form>
			<table>
			<tr>
			<td>닉네임</td><td>내용</td><td>작성시간</td>
			</tr>
			<%
			for(int i=0; i<boardList.size();i++){
				BoardDTO board = boardList.get(i);
				
				 String subject = board.getSubject();
				 String name = board.getName();
				 Date date = board.getDate();
				 
				 out.println("<tr>");
				 out.println("<td>"+name+"</td>");
				 out.println("<td>");out.println(subject);out.println("</td>");
				 out.println("<td>");out.println(date);out.println("</td>");
				 out.println("</tr>");
			}
			
			%>
			</table>
			</form>
</body>
</html>