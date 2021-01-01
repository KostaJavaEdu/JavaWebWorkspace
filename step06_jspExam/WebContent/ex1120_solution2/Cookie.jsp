<%@page import="java.util.Date"%>
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
    long curTime = System.currentTimeMillis();
    Date date=null;    
    long oldTime=0;
    Cookie lastTime=null;  
    boolean bln_Cookie = false;
   
    Cookie co[] = request.getCookies();
    out.print("저장되어있는 쿠키의 수 : "+co.length+"<br/>");
    out.print("<hr color='green'/>");
   
    if(co != null){
       
        for(Cookie compareCo: co){
            //out.print(compareCo.getName() + "  :  " + compareCo.getValue()+"<br/>");  
            if( compareCo.getName().equals("lastTime") ){
                lastTime = compareCo;
                oldTime = Long.valueOf(compareCo.getValue());
                date=new Date(oldTime);
                bln_Cookie = true;
                break;
            } 
        }
    }
%>
 
<% 
    if(!bln_Cookie){
        date=new Date(curTime);
        oldTime = curTime;
        lastTime = new Cookie("lastTime", Long.toString(curTime));
        lastTime.setMaxAge(60*60*24*365);
        lastTime.setPath("/");
        response.addCookie(lastTime);
        out.print("처음 방문하시는군요! 환영합니다.<br/>");
        %>
        <h2>현재접속시간</h2>
        	현재접속시간 : <%=new Date(curTime).toLocaleString() %> <br/>
        	저장되는 시간 : <%=curTime %> <br/>
       <%
 
    }else{
           
        lastTime.setValue(Long.toString(curTime));
        lastTime.setMaxAge(60*60*24*365);
        lastTime.setPath("/");
        response.addCookie(lastTime);
        %>
         <h2>쿠키에 저장된 마지막접속시간</h2>
        	당신의마지막 접속일은 :<%=date.toLocaleString() %> <br/>
        	쿠키에서 불러온 마지막접속시간 :<%=oldTime %> <br/>       
    <%
    }
   %>
 
</body>
</html>

<!-- 
*필요한 변수 선언
쿠키존재여부를 판별(false-없음, true -있음)
출력할 변수
현재시간을 저장할 변수(System.currentTimeMills();)
찾았을때 Cookie 저장할 변수

1. 마지막 방문 일을 표시하는 웹페이지에 방문한 적이 있는지 
없는지 체크. (저장된 쿠키를 가져와서 쿠키의 길이만큼 반복하여
마지막일을 저장한 쿠키의 이름을 찾으면 쿠키존재여부를
판별하는 변수의 값을 true로 변경한다.)*/
 
2.쿠키 없으면 현재날짜를 저장하는 쿠키생성하여 저장한다.

3.쿠키 있으면 이전쿠키가 저장한 날짜를 가져와서 출력할 변수에 저장한다.

4.현재 방문한 시점의 시간을 쿠키의 새로운 값으로 설정
-쿠키의 setValue를 이용하여 쿠키의 새로운값으로 변경
-쿠키를 클라이언트쪽에 다시저장한다.
   
5. 화면에 출력
 -->


