<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!-- jstl사용하기 위해서 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록 목록</title>
</head>
<body>

	<h1>방명록</h1>
	<br> 방명록 전체 수 : ${count }
	<br>
	<br>

	<c:forEach items="${list}" var="guestbook"> <!-- 컨트롤러에서 방명록 list얻어옴
	리스트에 있는 Guestbook 객체를 하나 꺼내가지고 이 guestbook에다가 담았을 거고
	
	해당 guestbook을 이제 EL 이용해가지고 id, name, 내용, regdate 이렇게 출력을 하고 있죠?
	이 부분을 forEach 문을 이용해서 출력하고 있는 코드를 확인할 수 있을 거고 -->
${guestbook.id }<br>
${guestbook.name }<br>
${guestbook.content }<br>
${guestbook.regdate }<br>

	</c:forEach>
	<br>
<!-- pageStartList 이 부분은 페이징 돼서 페이지 링크 나오는 부분이죠. 페이지의 링크 뿌려주기 위한 부분을 구현하고 있고요. -->
	<c:forEach items="${pageStartList}" var="pageIndex" varStatus="status">
		<a href="list?start=${pageIndex}">${status.index +1 }</a>&nbsp; &nbsp;
</c:forEach>

<!-- 맨 하단에다가는 방명록 입력받을 수 있는 부분이 수행되는 거죠. -->
	<br>
	<br>
	<form method="post" action="write">
		name : <input type="text" name="name"><br>
		<textarea name="content" cols="60" rows="6"></textarea>
		<br> <input type="submit" value="등록">
	</form>
</body>
</html>