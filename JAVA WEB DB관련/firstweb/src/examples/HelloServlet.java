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
		//응답할 내용을들 모아서 추상화한 객체가 response
		//응답결과를 보내줄 객체에 contenttype을 정해주는거임, 브라우저에게 응답결과로 text로 보낼건데 이 text는 http야, 캐릭터셋은 utf8이야~ 브라우저가 이것을 보고 판단
		response.setContentType("text/html;charset=UTF-8");
		//텍스트를 쓸수있는 통로임 io객체중PrintWriter라는 객체가있는데, 무엇을 써야할 때 가장많은 매소드를 갖고있어서 편함
		PrintWriter out = response.getWriter();
		//통로에 응답결과써주는거임
		out.print("<h1>Hello servlet</h1>");
	}

}
