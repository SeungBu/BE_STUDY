<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 응답결과 표현 할때는 표현식 사용해야되므로, 얘네는 service 메소드에 생성됨 -->
id : <%=getId() %>
</body>
</html>

<%!
//해당 선언문이 jsp파일 내 어디에 있는지는 상관없음 맨위에 <%@ 이녀석들 아래만 있으면 됨 
    String id = "u001"; //멤버변수 선언
    public String getId( ) { //메소드 선언
        return id;
    }
%>