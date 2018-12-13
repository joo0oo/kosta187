package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatchServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 디스패치 기술 - rediret/ forward 두가지
		//response.sendRedirect(location);
		
		RequestDispatcher rd= request.getRequestDispatcher("hello.do"); //서블릿 이름만 넘겨준다 (경로x)
	//	rd.forward(request, response); //전달 (redirect와 다른점 : url 그대로)
		
		rd.include(request, response); //rd에 있는 서블릿을 가져와서 여기서 사용
		
		
	}
}
