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
    	System.out.println("LifecycleServlet2 호출!!!");
    }

    //url에서 직접 요청이 들어왔을 때는 메소드가 get으로 들어옴 그래서 doget실행된거고
    //ok하게되면 액션에 있는 url값으로 요청하는데 메소드가 post로 드가서 post요청이니까 dopost실행
    //url로 접속하거나 링크 클릭은 get방식으로 서버에 요청임
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		//
		//form태그 안에 메소드와 액션이있는데 각각 submit이라는 버튼이 눌렸을 떄 액션에 있는 주소로 요청해줘요.
		//이때 요청이 들어갈때 메소드는 post라는 값으로 넣어주세요 임
		out.println("<form method='post' action='/firstweb/LifecycleServlet2'>");
		//input상자로 type은 text이고 이름이 name인거
		out.println("name : <input type='text' name='name'><br>");
		//submit의 값은 ok
		out.println("<input type='submit' value='ok'><br>");    //ok눌렸을때 form태그                                             
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); //contenttype 설정하고
		PrintWriter out = response.getWriter();//응답 결과넣을 통로
		String name = request.getParameter("name"); //request객체에서 (doget에서 요청했으니)파라미터가 name인 것을 꺼내서 string name에 넣어주는거임
													//out.println("name : <input type='text' name='name'><br>"); 여기서 'name'이거가 파라미터가
													//인풋상자에 있는 값이 name인 것
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

    	System.out.println("destroy 호출!!!");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
			System.out.println("init 호출!!!");
	}

}
