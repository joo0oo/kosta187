package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class HttpServletResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 문자 출력 스트림
		
	//	response.setStatus(400); //상태 강제 변경 400에러
	//	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		//setStatus 말고 sendError를 써야 한다 ->부가정보까지 모두 넘기는 메소드
	//	response.sendError(HttpServletResponse.SC_BAD_GATEWAY);
		
		// 'bangry'라는 블랙리스트 유저가 접근햇을 때 접근 못하도록 하는 기능 구현
		String name= request.getParameter("firstname");
		if(name != null && name.length() !=0 ) {
			if(name.equals("bangry")) {
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
		}
		
		/*
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet Programming </title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 15pt'>");


		out.println("</body>");
		out.println("</html>");
		*/
		
		
		//Dispatch 기술
	//	System.out.println(HttpServletResponse.SC_MOVED_PERMANENTLY);
	//	response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
	//	response.setHeader("Location", "/servlet/hello.do");
		response.sendRedirect("/servlet/hello.do");
	}

}
