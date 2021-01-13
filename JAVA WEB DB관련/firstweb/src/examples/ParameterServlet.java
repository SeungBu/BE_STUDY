package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParameterServlet
 */
@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParameterServlet() {
        super();
    }

    //������ ���������ѰŴ� response�� �ְ�
    //��û�� ���°� ������Ʈ
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();//Ŭ���̾�Ʈ�� �������
		out.println("<html>");//�ؽ�Ʈ���� html����
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		//��û�� �� ������ ���߿��� �Ķ���������ϱ� getparameter
		String name = request.getParameter("name");//�Ķ���� �̸� �־��ָ� ���� ��ȯ��
		String age = request.getParameter("age"); // �� ���ڿ��� �Ѿ��
		//�Ķ���ʹ� �̷��� URL�� ���ؼ��� �����°Ծƴ϶� html�� form �±׸� ���ؼ� ���ü�����
		//form�±� �ȿ��� input �±׸� ����Ҽ��ִµ� �� �ȿ��ִ� ���� �Ķ���ͷ� ���ͼ� �Ȱ��� ����ص���
		out.println("name : " + name + "<br>");
		out.println("age : " +age + "<br>");
		
		out.println("</body>");
		out.println("</html>");
	}


}
