package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import kr.or.kosta.servlet.dao.JdbcUserDao;
import kr.or.kosta.servlet.dao.User;


public class DatabaseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	JdbcUserDao dao;
	private static final String driver="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String userName="hr";
	private static final String passWd="hr";
	
	@Override
	public void init() throws ServletException {
		JdbcUserDao dao = new JdbcUserDao();

		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(passWd);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);

		dao.setDataSource(dataSource);

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> list=null;
		try {
			list= dao.listAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 문자 출력 스트림

		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet Programming </title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 15pt'>");
		
		out.println("<table border='1' width='50%'>");
		
		for (User user : list) {
			out.println("<tr> <td>"+user+"</td> </tr>");
		}
	
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
	
	}
	
}
