<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
hello~~
<%
	// 실행후에 새로고침하면 jspservice계속 출력됨 아래 코드는 jspservice메소드에 들어감
	//이렇게 하면 다 jspservice에 들어감. 서블릿은 응답에 해당하는건 service뿐이니까 매번호출은 service뿐이니까.
	System.out.print("jspService()");
%>

<!-- 선언식인데, 메소드, 필드를 선언할 때 사용하면됨 service메소드 밖에 선언됨 -->
<%!
	//init출력후에 service출력됨
	public void jspInit(){
		System.out.print("jspInit()");
	}
	//수정하거나 하면 다시 메모리에 올려야 되므로 destory먼저 시작되고 init하고 serrvice함
	public void jspDestroy(){
		System.out.print("jspDestroy()!!");
	}
%>
</body>
</html>