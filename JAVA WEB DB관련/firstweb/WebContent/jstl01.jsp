<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 라이브러리 추가햇을 때 jsp 페이지한테도 지시자 사용해서 알려주느거임 taglib -->
<!-- prefix는 테그들이 중복될수있으니까 prefix지정해서 사용할때도와줌 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="value1" scope="request" value="kang"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL표기법 -->
성 : ${value1} <br>
<!-- <>얘네 사이에 값이없으면 끝네 \로 사용해도되고 사이에 값이있으면 닫아주기해줘야됨 -->
<c:remove var="value1" scope="request"/>
성 : ${value1 }
</body>
</html>