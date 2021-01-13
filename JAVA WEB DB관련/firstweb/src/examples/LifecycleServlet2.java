package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifecycleServlet2
 */
@WebServlet("/LifecycleServlet2")
public class LifecycleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LifecycleServlet2() {
    	System.out.println("LifecycleServlet2 ȣ��!!!");
    }

    //url���� ���� ��û�� ������ ���� �޼ҵ尡 get���� ���� �׷��� doget����ȰŰ�
    //ok�ϰԵǸ� �׼ǿ� �ִ� url������ ��û�ϴµ� �޼ҵ尡 post�� �尡�� post��û�̴ϱ� dopost����
    //url�� �����ϰų� ��ũ Ŭ���� get������� ������ ��û��
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		//
		//form�±� �ȿ� �޼ҵ�� �׼����ִµ� ���� submit�̶�� ��ư�� ������ �� �׼ǿ� �ִ� �ּҷ� ��û�����.
		//�̶� ��û�� ���� �޼ҵ�� post��� ������ �־��ּ��� ��
		out.println("<form method='post' action='/firstweb/LifecycleServlet2'>");
		//input���ڷ� type�� text�̰� �̸��� name�ΰ�
		out.println("name : <input type='text' name='name'><br>");
		//submit�� ���� ok
		out.println("<input type='submit' value='ok'><br>");    //ok�������� form�±�                                             
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //contenttype �����ϰ�
		PrintWriter out = response.getWriter();//���� ������� ���
		String name = request.getParameter("name"); //request��ü���� (doget���� ��û������)�Ķ���Ͱ� name�� ���� ������ string name�� �־��ִ°���
													//out.println("name : <input type='text' name='name'><br>"); ���⼭ 'name'�̰Ű� �Ķ���Ͱ�
													//��ǲ���ڿ� �ִ� ���� name�� ��
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

	/*
	 * @Override 
	 * protected void service(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException { // TODO Auto-generated method
	 * stub super.service(req, resp); }
	 */
	@Override
	public void destroy() {

    	System.out.println("destroy ȣ��!!!");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
			System.out.println("init ȣ��!!!");
	}

}
