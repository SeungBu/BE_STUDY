<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//request는 내장객체이기 때문에 선언하지 않아도 사용가능
	
    StringBuffer url = request.getRequestURL();
	//스크립트릿에서 출력할려면 out.print or out.println사용, ln해봣자 줄바꿈안돼서 br사용
    out.println("url : " + url.toString());
    out.println("<br>");
%>
</body>
</html>