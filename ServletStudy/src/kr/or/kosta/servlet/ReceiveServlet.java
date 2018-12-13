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
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	//실제 처리하는 부분
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 문자 출력 스트림

		//요청 파라메터 수신
		String userId= request.getParameter("userId"); //폼에서 입력한 값 (해당 태그의 name속성으로 접근)
		String passwd= request.getParameter("userpw");
		String team= request.getParameter("teams");
		String[] hobbies= request.getParameterValues("hobby"); //체크박스는 중복쳌 가능
		
		String fname= request.getParameter("fname");
		
		//동적 웹 문서에서 동적으로 입력값 받아오기 (태그의 name속성을 모를때)
		Enumeration<String> paramNames= request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			String value= request.getParameter(name);
			System.out.println(name+ " = "+ value);
		}
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet Programming </title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 15pt'>");

		out.println("<h3> 아이디 : "+userId+"</h3>");
		out.println("<h3> 비밀번호 : "+passwd+"</h3>");
		out.println("<h3> 팀이름 : "+team+"</h3>");

		if( hobbies != null) {
		for (String hobby : hobbies) {
			out.println("<h3> 취미 : "+hobby+"</h3>");
		}
		}
		out.println("<h3> 이름 : "+fname+"</h3>");
		
		out.println("</body>");
		out.println("</html>");
	}

}
