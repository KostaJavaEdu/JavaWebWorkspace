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
<h1> Jsp �����ϱ� </h1>

<%
	//java���� 100%���
	String name="����"; //�������� �̹Ƿ� �ݵ�� �ʱ�ȭ!!!!!!
	int age = 20;
	
	//���(�ܼ�â�� ���)
	System.out.println("�� ��� ��µǴ�");
	
	//�������� ���
	out.println("�׷� �� ��� ��µǴ�");
	
	List list;
	Date date;
	
%>

<h3>�̸� : <%=name%> �Դϴ�.</h3>
<h3>���� : <%=age%> ��</h3>

<h4> �޼ҵ� ȣ�� : <%=test() %></h4>

<%!
	String addr; //��������
	int age;
	public String test(){ //�޼ҵ�� �ݵ�� ����ǥ �ȿ����� ����
		System.out.println("test() ȣ���..");
		return "�氡�氡";
	}
	
%>

</body>
</html>