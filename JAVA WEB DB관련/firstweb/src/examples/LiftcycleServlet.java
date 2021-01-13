package examples;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LiftcycleServlet
 */
@WebServlet("/LiftcycleServlet")
//url�� Ŭ���̾�Ʈ�� ������ ��û�߰�, ������ �� url�� �޾Ƽ� ����������Ŭ�̶�� ���� �̶�� ������ �˾Ƴ���
//�޸𸮿� �����ϴ��� Ȯ���ϰ� ������ ������ �����ϰ� �÷��� (�׷��� LiftcycleServlet ����!! �� �Ȱ�)
//�����ϰ� init�ϰ� serviceȣ����
//���ΰ�ħ�ϸ� service�� ȣ���
//���� ��ü�� ������ ������ ������ �ʰ� 
// ��û�� ������������ �Ź������̾ƴ϶� ��û�� ��ü�� �޸𸮿� ������ ���� �޼ҵ常 ȣ��
//������ �����Ǹ� �޸𸮿� �ִ� ������ �̹� �����ϹǷ� destroy�ϰ�, �޸𸮿� ���� ������ �������� init service�ϴ°���
public class LiftcycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LiftcycleServlet() { //����
		//sysout�̶� response�� ���� ���� printwriter��ü�� out�̶��� �ٸ�
		//sysout�� �ֿܼ� �ǹ��ϰ� out�� �������ִ°���
		System.out.println("LiftcycleServlet ����!!!");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init ����!!");
	}

	public void destroy() {
		System.out.println("destroy ����!!");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service ����!!");
	}

	
	
	
	

	/*
	 * protected void doGet(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub
	 * response.getWriter().append("Served at: ").append(request.getContextPath());
	 * }
	 * 
	 *//**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 *//*
			 * protected void doPost(HttpServletRequest request, HttpServletResponse
			 * response) throws ServletException, IOException { // TODO Auto-generated
			 * method stub doGet(request, response); }
			 */
}
