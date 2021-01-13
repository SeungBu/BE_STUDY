package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TenServlet
 */
//����ٲٸ� url�ٲܼ� ����
//ex) @WebServlet("/ttt")�� �ϸ� http://localhost:8080/exam31/ttt ����
//@WebServlet("/ten")
@WebServlet("/ttt")
public class TenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ �������� �������� ������ ���̱� ������ ��û�� ������ �� ����Ǹ鼭 ������ �ڵ带 ������ �� �ڵ�� �����ϴ°���
		//�����ϰ���� ������ �����Ը������  Ŭ���̾�Ʈ-��û ����-����
		//Ŭ���̾�Ʈ�� ��û�� �� ������ ��û�� �޾Ƴ��� ��ü  HttpServletRequest �� ���� ��û�� ���� �κе��� �� ��ü���ְ�
		//Ŭ���̾�Ʈ�� ��û�� �� ������ ������ �ϱ����� ��ü HttpServletResponse �� ���� ���信 ���� ��ü..
		//Ŭ���̾�Ʈ(������)�� ������ �޾��� �� �̹������� ��� �˾ƾߵǴϱ� �˾ƾߵ�
		response.setContentType("text/html;charset=utf-8");
		//���� ������ �־��� ��� �����
		PrintWriter out = response.getWriter();
		//out �̶�� ��ο� ����ϸ� ��
		//html�� <br>�ƴϸ� �ٳѱ� �����ִϱ� �˾Ƽ� �ϸ��
		out.print("<h1>1���� 10���� ���</h1>");
		for(int i = 1; i <= 10; i++){
			out.print(i+"<br>");
		}
		out.close();
	}

}
