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
	// �����Ŀ� ���ΰ�ħ�ϸ� jspservice��� ��µ� �Ʒ� �ڵ�� jspservice�޼ҵ忡 ��
	//�̷��� �ϸ� �� jspservice�� ��. ������ ���信 �ش��ϴ°� service���̴ϱ� �Ź�ȣ���� service���̴ϱ�.
	System.out.print("jspService()");
%>

<!-- ������ε�, �޼ҵ�, �ʵ带 ������ �� ����ϸ�� service�޼ҵ� �ۿ� ����� -->
<%!
	//init����Ŀ� service��µ�
	public void jspInit(){
		System.out.print("jspInit()");
	}
	//�����ϰų� �ϸ� �ٽ� �޸𸮿� �÷��� �ǹǷ� destory���� ���۵ǰ� init�ϰ� serrvice��
	public void jspDestroy(){
		System.out.print("jspDestroy()!!");
	}
%>
</body>
</html>