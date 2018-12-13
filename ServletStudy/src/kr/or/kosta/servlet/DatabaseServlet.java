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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String userName="hr";
	String passWd="hr";
	String sql="SELECT employee_id, last_name, salary\r\n" + 
			"FROM EMPLOYEES";
	
	Connection con;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName(driver);
			 //원래는 newInstance()까지 쓰는게 맞지만 오라클에서는 Class.forName 지원
			System.out.println("jdbc 드라이버 생성 완료");
			con= DriverManager.getConnection(url,userName,passWd);
			System.out.println("DBMS 연결 완료.."+con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		/*
		try {
			pstmt= con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			
			while(rs.next()) {
				String employeeID= rs.getString("employee_id");
				String lastName= rs.getString("last_name");
				int salary= rs.getInt("salary");
				System.out.println(employeeID+", "+lastName+", "+salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 문자 출력 스트림

		out.println("<html>");
		out.println("<head>");
		out.println("<title> Servlet Programming </title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size: 15pt'>");
		
		out.println("<table border='1' width='50%'>");
		
		try {
			pstmt= con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()) {
				String employeeID= rs.getString("employee_id");
				String lastName= rs.getString("last_name");
				int salary= rs.getInt("salary");
				out.println("<tr>");
				out.println("<td>"+ employeeID+"</td> <td>"+ lastName+"</td> <td>"+ salary+"</td>");
				out.println("</tr>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		out.println("</table>");
		
		out.println("</body>");
		out.println("</html>");
	
	}
	
	@Override
	public void destroy() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
