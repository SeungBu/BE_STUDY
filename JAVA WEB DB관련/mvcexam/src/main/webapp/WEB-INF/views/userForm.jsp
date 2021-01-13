<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="regist">  <!-- regist라는 요청이 들어갈거임 -->
name : <input type="text" name="name"><br> <!-- 요청이 들어갈대 input상자가 가진 이런 값들이 들어갈거임 -->
email : <input type="text" name="email"><br>
age : <input type="text" name="age"><br>
<input type="submit" value="확인"> 
</form>
</body>
</html>