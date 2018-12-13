package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet3
 */
@WebServlet("/hello3.do")
public class HelloServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 클라이언트로 동적 출력하고자 하는 데이터 생성
				Calendar now= Calendar.getInstance();
				String nowString = String.format("%1$tF %1$tT", now);
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out= response.getWriter(); //문자 출력 스트림
				out.println("<html>");
				out.println("<head>");
				out.println("<title> Servlet Programming </title>");
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2> hello servlet </h2>");
				out.println("<h2> 오늘은"+nowString+"입니다 </h2>");
				out.println("<h2> 공유한 데이터 ["+getServletContext().getAttribute("message")+"] 입니다 </h2>");
				out.println("</body>");
				out.println("</html>");
	}

}
