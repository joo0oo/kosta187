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
public class HttpServletRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 문자 출력 스트림

		String clientIP = request.getRemoteAddr(); // 클라이언트 IP
		String method = request.getMethod();
		String uri = request.getRequestURI(); // 요청 URI
		String protocol = request.getProtocol(); // 요청 프로토콜
		String query = request.getQueryString();
		String nameParam = request.getParameter("name");

		// 굉장히 중요한 두가지 메서드
		String applicationName = request.getContextPath();
		String servletName = request.getServletPath();

		Enumeration<String> headerNames = request.getHeaderNames();

		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet Programming </title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 15pt'>");

		out.println("<ul>");
		out.println("<li> clientIP :" + clientIP + "</li>");
		out.println("<li> method :" + method + "</li>");
		out.println("<li> uri :" + uri + "</li>");
		out.println("<li> protocol :" + protocol + "</li>");

		while (headerNames.hasMoreElements()) {
			String name = (String) headerNames.nextElement();
			String value = request.getHeader(name);
			out.println("<li>" + name + " : " + value + "</li>");
		}

		out.println("<li> query string :" + query + "</li>");
		out.println("<li> get Parameter :" + nameParam + "</li>");
		out.println("<li> applicationName :" + applicationName + "</li>");
		out.println("<li> servletName :" + servletName + "</li>");

		out.println("</ul>");

		out.println("</body>");
		out.println("</html>");
	}

}
