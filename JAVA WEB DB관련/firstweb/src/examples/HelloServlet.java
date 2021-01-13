package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������ �������� ��Ƽ� �߻�ȭ�� ��ü�� response
		//�������� ������ ��ü�� contenttype�� �����ִ°���, ���������� �������� text�� �����ǵ� �� text�� http��, ĳ���ͼ��� utf8�̾�~ �������� �̰��� ���� �Ǵ�
		response.setContentType("text/html;charset=UTF-8");
		//�ؽ�Ʈ�� �����ִ� ����� io��ü��PrintWriter��� ��ü���ִµ�, ������ ����� �� ���帹�� �żҵ带 �����־ ����
		PrintWriter out = response.getWriter();
		//��ο� ���������ִ°���
		out.print("<h1>Hello servlet</h1>");
	}

}
