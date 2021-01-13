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

    //응답을 보내기위한거는 response에 넣고
    //요청이 들어온건 리퀘스트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();//클라이언트와 연결통로
		out.println("<html>");//텍스트지만 html형태
		out.println("<head><title>form</title></head>");
		out.println("<body>");

		//요청할 떄 들고들어온 값중에는 파라미터있으니까 getparameter
		String name = request.getParameter("name");//파라미터 이름 넣어주면 값이 반환됨
		String age = request.getParameter("age"); // 다 문자열로 넘어옴
		//파라미터는 이렇게 URL을 통해서만 들어오는게아니라 html의 form 태그를 통해서 들어올수있음
		//form태그 안에는 input 태그를 사용할수있는데 이 안에있는 값이 파라미터로 들어와서 똑같이 사용해도됨
		out.println("name : " + name + "<br>");
		out.println("age : " +age + "<br>");
		
		out.println("</body>");
		out.println("</html>");
	}


}
