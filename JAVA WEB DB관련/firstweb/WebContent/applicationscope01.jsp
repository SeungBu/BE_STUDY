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
    try{
    	//jsp에서는 내장객체로 있기때문에 서블릿컨텍스트로 얻어서 할 필요없음 
        int value = (int)application.getAttribute("value");
        value = value + 2;
        application.setAttribute("value", value);
%>
        <h1><%=value %></h1>
<%        
	//value가 없을 때 오류 발생하도록
    }catch(NullPointerException ex){
%>
        <h1>설정된 값이 없습니다.</h1>
<%        
    }
//해당 웹 어플리케이션이 중지 될 때까지 남아있을 거임
%>

</body>
</html>