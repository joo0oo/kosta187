package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigServlet extends HttpServlet {

	String driver; //선언만 해두고 init에서 초기화, 이 값이 변경될 때마다 설정파일에서 읽어오기
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		driver= config.getInitParameter("driver"); //초기화
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(driver);
	}
}
