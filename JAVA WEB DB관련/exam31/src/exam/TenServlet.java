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
//여기바꾸면 url바꿀수 있음
//ex) @WebServlet("/ttt")로 하면 http://localhost:8080/exam31/ttt 가됨
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
		//서블릿은 동적으로 응답결과를 만들어내는 것이기 때문에 요청이 들어왔을 때 실행되면서 응답할 코드를 만들어내고 그 코드로 응답하는거임
		//응답하고싶은 내용이 나오게만들거임  클라이언트-요청 서버-응답
		//클라이언트가 요청할 때 서버는 요청을 받아내는 객체  HttpServletRequest 를 만듦 요청에 대한 부분들은 이 객체에있고
		//클라이언트가 요청할 때 서버는 응답을 하기위한 객체 HttpServletResponse 를 만듦 응답에 대한 객체..
		//클라이언트(브라우저)가 응답을 받았을 때 이미지인지 등등 알아야되니까 알아야됨
		response.setContentType("text/html;charset=utf-8");
		//보낼 내용을 넣어줄 통로 만들기
		PrintWriter out = response.getWriter();
		//out 이라는 통로에 출력하면 됨
		//html에 <br>아니면 줄넘김 안해주니까 알아서 하면됨
		out.print("<h1>1부터 10까지 출력</h1>");
		for(int i = 1; i <= 10; i++){
			out.print(i+"<br>");
		}
		out.close();
	}

}
