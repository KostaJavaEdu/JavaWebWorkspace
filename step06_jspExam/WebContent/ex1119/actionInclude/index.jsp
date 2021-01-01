<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> 액션태그 - include</h1>
<jsp:include page="top.jsp"/>

<%
 out.println("전" + request.getCharacterEncoding());
//request로 전송되는(parameter로 전송되는) 한글 인코딩 필요
 request.setCharacterEncoding("UTF-8");

 out.println("후" + request.getCharacterEncoding());
 
 
 String addr="제주도";
%>                                                                                                                                                                             

<h3> 여기는 index.jsp 영역입니다. </h3>
<jsp:include page="footer.jsp">
  <jsp:param value="<%=addr %>" name="addr"/> 
  <jsp:param value="jang" name="id"/>
</jsp:include>
</body>
</html>