package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/guestbooks")
public class GuestbookListServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//getGuest하고
    	//입력받으면 request에 저장하고 doPst write로 가게하고

   	 	List<Guestbook> list = new ArrayList<>();
   	 	GuestbookDao guestbookDao = new GuestbookDao();
   	 	list = guestbookDao.getGuestbooks();
   	 	int listSize = list.size();
	 		response.setContentType("text/html;charset=utf-8");
   	 		PrintWriter out = response.getWriter();
   	 	if(listSize > 0){
   	   	 	for(Guestbook guestbook : list) {
   	   	 		out.print("id : " + guestbook.getId() + "<br>");
   	   	 		out.print("name : " + guestbook.getName() + "<br>");
   	   	 		out.print(guestbook.getContent() + "<br>");
   	   	 		out.print("regdate : " + guestbook.getRegdate() + "<br>");	
   	   	 		out.print("<hr>");
   	   	 	}
   	 	}

		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/guestbook/guestbooks/write'>");
		out.println("이름 : <input type='text' name='name'><br>");
		out.println("내용 : <input type='text' name='content'><br>");
		out.println("<input type='submit' value='확인'><br>");                                           
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
    }
    

}
