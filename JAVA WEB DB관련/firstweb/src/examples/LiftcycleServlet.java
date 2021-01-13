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
//url로 클라이언트가 서버에 요청했고, 서버는 이 url을 받아서 라이프사이클이라는 서블릿 이라는 정보를 알아냇고
//메모리에 존재하는지 확인하고 없으면 서블릿을 생성하고 올려줌 (그래서 LiftcycleServlet 생성!! 이 된거)
//생성하고 init하고 service호출함
//새로고침하면 service만 호출됨
//서블릿 객체를 서버에 여러개 만들지 않고 
// 요청이 여러번들어오면 매번생성이아니라 요청된 객체가 메모리에 있으면 서비스 메소드만 호출
//서블릿이 수정되면 메모리에 있는 서블릿은 이미 사용못하므로 destroy하고, 메모리에 이제 없으니 생성부터 init service하는거임
public class LiftcycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LiftcycleServlet() { //생성
		//sysout이랑 response로 부터 얻어온 printwriter객체인 out이랑은 다름
		//sysout은 콘솔에 의미하고 out은 응답해주는거임
		System.out.println("LiftcycleServlet 생성!!!");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 생성!!");
	}

	public void destroy() {
		System.out.println("destroy 생성!!");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 생성!!");
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
