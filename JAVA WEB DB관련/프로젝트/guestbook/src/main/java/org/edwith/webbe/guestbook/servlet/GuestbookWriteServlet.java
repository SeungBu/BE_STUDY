package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //여기서 add guest하고 redirect하면될듯
    	GuestbookDao guestbookDao = new GuestbookDao();
    	Guestbook guestbook = new Guestbook(request.getParameter("name"), request.getParameter("content"));
    	guestbookDao.addGuestbook(guestbook);
    	response.sendRedirect("http://localhost:8080/guestbook/guestbooks");
    }

}
