<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1> &lt;c:if> 와 &lt;c:choose> 실습하기 </h1>
<!--  
http://localhost:8000/step11_EL_Jstl/ex03_if_choose.jsp?age=20
-->
<!-- if문의 실행결과를 var에 담아서 다른 곳에서 써먹을 수 있다. -->
<c:if test="${param.age > 19 }" var="result" scope="session">
	<h3 style="color:red">${param.age }살은 성인입니다.</h3>
</c:if>

결과 : ${result }<hr>

<c:choose>
	<c:when test="${param.age > 18}">
		<h3 style="color:red">${param.age }살은 성인입니다.</h3>
	</c:when>
	
	<c:otherwise>
		<h3 style="color:blue">${param.age }살은 미성년자입니다.</h3>
	</c:otherwise>
</c:choose>

<hr color="red">
<form action="ex03_if_choose.jsp" method="get" name="f">
  이름 : <input type="text" name="name" value=${param.name}>
  선택 :
  		<select name="job">
  			<option value="0">--선택--</option>
  			<option value="학생">학생</option>
  			<option value="개발자">개발자</option>
  			<option value="백수">백수</option>
  			<option value="백조">백조</option>
  		</select>
  		<input type="submit" value="전송">
</form>
<hr color="red">
<!-- 
	1. 만약 name과 job이 전송된다면
	   ~님 직업은 ~입니다. 출력
	   
	2. job의 종류에 따른 메시지를 출력한다.
	   학생이라면 "공부하세요"
	   개발자라면 "최고의 개발자가 되세요"
	   백수라면 "돈버세요"
	   백조라면 "노세요~~"
	   위 경우가 아닌경우는 "선택사항 없음." 출력
	
	3. 값이 전송되었을 때 각 폼에 선택된 내용이 그대로 보이기.
 -->
 <c:if test="${not empty param.name && param.job != null}">
 	<h3>${param.name}님 직업은 ${param.job}입니다.</h3>
 </c:if>
 
 <c:if test="${not empty param.job}">
 	<c:choose>
		<c:when test="${param.job == '학생'}" >
			<h3 style="color:red">공부하세요</h3>
		</c:when>
		
		<c:when test="${param.job == '개발자'}" >
			<h3 style="color:red">최고의 개발자가 되세요</h3>
		</c:when>
		
		<c:when test="${param.job == '백수'}" >
			<h3 style="color:red">돈버세요</h3>
		</c:when>
		
		<c:when test="${param.job == '백조'}" >
			<h3 style="color:red">노세요~~</h3>
		</c:when>
		
		<c:otherwise>
			<h3 style="color:blue">선택사항 없음..</h3>
		</c:otherwise>
	</c:choose>
 </c:if>
 
 <script type="text/javascript">
 	//선택된 job이 선택되도록 설정
 	document.f.job.value = "${param.job}";
 </script>
 
</body>
</html>