<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table{width:100%; border:5px dobule red}
  th,td{padding:5px; border: 1px solid pink ; text-align: center }
  a{text-decoration: none; }
 </style>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
	$(function() {
		//alert(1);
		//검색 클릭했을 때
		$("[value=검색]").click(function() {
			if($("[name=keyWord]").val()==""){
				alert("검색어를 입력해주세요");
				$("[name=keyWord]").focus();
				return;
			}
			
			if($("[name=keyField]").val()=="0"){
				alert("검색필드를 선택하세요.");
				$("[name=keyField]").focus();
				return;
			}
			
			//form전송한다.
			$("[name=search]").submit();//search서블릿으로 이동한다.
			
		});//검색 끝
		
		//삭제 클릭했을 때
		$("button[type=button]").click(function() {
			if(confirm("정말 삭제 하실래요?")){
				//선택된 버튼을 기준으로 id를 찾아
				var id = 
					$(this).parent().parent().find("td:first").next().text();
				//alert(id);
				//location.href="delete?id="+id;//get방식
				
				//post방식 (hidden으로 form생성해서 보내)
				$("#id").val(id);
				$("[name=del]").submit();//delete서블릿으로 이동
			}
		})
	})
</script>
</head>

<body>

<center>
 <h1>[ 회원 정보 LIST ]</h1>
<table cellspacing="0">
  <tr>
    <th colspan="9" style="text-align:right">
      <a href="memberForm.html">[ 회원가입 ]</a>&nbsp;&nbsp;&nbsp;
      <a href="index.html">[ 새로고침 ]</a>&nbsp;&nbsp;&nbsp;
    </th>
  </tr>
  
  <tr bgColor="pink">
    <th>번호</th>
    <th>아이디</th>
    <th>비밀번호</th>
    <th>이름</th>
    <th>나이</th>
    <th>주소</th>
    <th>연락처</th>
    <th>가입일</th>
    <th>삭제</th>
  </tr>
       
       <!-- 반복문을 돌면서 데이터 출력 -->
       
       <c:forEach var="list" items="${requestScope.list}" varStatus="state">
       <tr>
       		<td>${state.count}</td>
       		<td><a href="read?id=${list.id}">${list.id}</a></td>	<!-- member.getId()호출 -->
       		<td>${list.pwd}</td>
       		<td>${list.name}</td>
       		<td>${list.age}</td>
       		<td>${list.addr}</td>
       		<td>${list.phone}</td>
       		<td>${list.joinDate}</td>
       		<td><button type="button" >삭제</button></td>
       	</tr>
       </c:forEach>
       
</table>
<p>

<form name="search" action="search" method="post">
 <select name="keyField">
   <option value="0">--선택--</option>
   <option value="id">아이디</option>
   <option value="name">이름</option>
   <option value="addr">주소</option>
 </select>
 
<input type="text" name="keyWord"/>
<input type="button" value="검색" />  

</form>

<form name="del" action="delete" method="post">
 <input type="hidden" name=id id="id">
</form>

</center>

</body>
</html>




