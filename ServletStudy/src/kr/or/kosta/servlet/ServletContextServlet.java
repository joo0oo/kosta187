package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message="서블릿간의 데이터 공유 입니다";

		ServletContext context= getServletContext();
		System.out.println(context.getServerInfo());
		System.out.println(context.getContextPath());
		
		context.setAttribute("message", message);
		//response.sendRedirect("/servlet/hello.do");
		response.sendRedirect(context.getContextPath()+"/hello.do"); // -> "/servlet/hello.do"와 같은뜻 (동적으로 값 바뀔때 사용)
		
		String location = context.getInitParameter("location"); //context에 있는 해당 parameter 가져오기
		System.out.println(location);
		
	}
}
