package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 생명 주기 테스트
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int count;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        System.out.println("LifeCycleServlet() called");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		count=0;
		 System.out.println("init(config) called");
		 super.init(config);
		 //내부적으로 인자 없는 init()을 호출함
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("매개 변수 없는 init 호출");
		//init(ServletConfig config) 에 의해 이 메서드는 자동 호출됨
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		 System.out.println("destroy() called");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		System.out.println("service(request,response) called");
		super.service(request, response);
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet(request,response) called");
		System.out.println("request : "+request);
		System.out.println("response : "+response);
		
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out= response.getWriter(); //문자 출력 스트림

		out.println("<html>");
		out.println("<head>");
		out.println("<title> 서블릿 카운터 </title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2> 당신은 "+count+" 번째 방문자 </h2>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost(request,response) called");
	}

}
