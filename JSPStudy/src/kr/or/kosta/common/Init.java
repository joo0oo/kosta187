package kr.or.kosta.common;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import kr.or.kosta.jsp.dao.DaoFactory;
import kr.or.kosta.jsp.dao.JdbcDaoFactory;
import kr.or.kosta.jsp.dao.UserDao;

/**
 * Servlet implementation class Init
 */
@WebServlet("/Init")
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		DaoFactory factory = new JdbcDaoFactory();
		UserDao jdbcUserDao = factory.getUserDao();
		config.getServletContext().setAttribute("jdbcUserDao", jdbcUserDao);
		config.getServletContext().setAttribute("jdbcUserDao", jdbcUserDao);
		System.out.println(jdbcUserDao);
	}
}
