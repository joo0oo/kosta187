package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HttpSessionServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name="김기정";
		HttpSession session = request.getSession(); //최초 getSession() 에서는 새로 session 생성 -> 이후 호출부터는 기존 session 리턴
		System.out.println(session.isNew()); //새로 생성된 session이므로 true
		session.setAttribute("userName", name);
	
		//response.sendRedirect("hello2");
		
	}
}
