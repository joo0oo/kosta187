package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet2
 */
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// 웹 클라이언트로 동적 출력하고자 하는 데이터 생성
				Calendar now= Calendar.getInstance();
				String nowString = String.format("%1$tF %1$tT", now);
				
				
				//응답 메시지의 헤더에 컨텐츠 유형 설정
				response.setContentType("text/html; charset=utf-8"); 
				PrintWriter out= response.getWriter(); //문자 출력 스트림

				
				out.println("<html>");
				out.println("<head>");
				out.println("<title> Servlet Programming </title>");
				out.println("<meta charset=\"utf-8\">");
				out.println("</head>");
				out.println("<body>");
				out.println("<h2> hello servlet2 </h2>");
				out.println("<h2> 오늘은"+nowString+"입니다 </h2>");
				out.println("<h2> session에서 얻은 userName : "+request.getSession().getAttribute("userName")+" 입니다 </h2>");
				
				Cookie[] cookies= request.getCookies();
				String cookieValue= null;
				if(cookies != null) {
					for (Cookie cookie : cookies) {
						String cookieName = cookie.getName();
					//	String cookieValue= cookie.getValue();
						if(cookieName.equals("loginId")) {
							cookieValue= cookie.getValue(); //해당 name인 경우에만 value 가져오기
							cookieValue=URLDecoder.decode(cookieValue, "UTF-8"); //한글인 경우 디코딩
							out.println("<h2>"+cookieName+" : "+ cookieValue+"</h2>");
						}
					}
				}
				
				out.println("</body>");
				out.println("</html>");
	}

}
