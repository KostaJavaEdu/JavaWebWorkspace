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


 //param으로 전송된 데이터 받기
 String addr = request.getParameter("addr");
 String id = request.getParameter("id");
%>
<h3> footer.jsp입니다. <br>
주소 : 경기도 분당구 판교로 유스페이스2

</h3>

<%=addr %> / <%=id %>
</body>
</html>