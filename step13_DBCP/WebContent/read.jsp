<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
  table {border: 5px groove pink; width:500px}
  td,th{border:1px black solid ;  padding:10px}

  input{border:solid 1px gray}
  
</style>
</head>
<body>


<table cellspacing="0" align="center">
   <caption><h2> 상세보기 </h2></caption>
  <tr>
	<td width="100px">ID</td>
	<td width="400px">${searchById.id}</td>
  </tr>
  <tr>
	<td>PWD</td>
	<td>${searchById.pwd}</td>
  </tr>
  <tr>
	<td>NAME</td>
	<td>${searchById.name}</td>
  </tr>
  <tr>
	<td>age</td>
	<td>${searchById.age}</td>
  </tr>
  <tr>
	<td>Phone</td>
	<td>${searchById.phone}</td>
  </tr>
  <tr>
	<td>Addr</td>
	<td>${searchById.addr}</td>
  </tr>
  <tr>
	<td colspan="2" style="text-align: center;background-color: pink">
	  <a href="index.html">목록으로 이동</a>
	</td>
	
  </tr>
  </table> 

</body>
</html>