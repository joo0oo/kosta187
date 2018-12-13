package kr.or.kosta.reservationmall.common.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.admin.dto.Hotel;
import kr.or.kosta.reservationmall.admin.service.AdminService;
import kr.or.kosta.reservationmall.admin.service.AdminServiceImpl;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;


/**
 * ServletContext 생명주기(생성/소멸) 관련 이벤트 리스너
 * @author 김기정
 */
public class ServletContextLoadListener implements ServletContextListener {
	
	private AdminService adminService;
	private Logger logger = Logger.getLogger(ServletContextLoadListener.class);
	
	public void contextInitialized(ServletContextEvent event)  {
		ServletContext servletContext = event.getServletContext();
		String configLocation = servletContext.getInitParameter("configLocation");
		
		XMLObjectFactory objectFactory = null;
		try {
			objectFactory = new XMLObjectFactory(servletContext.getRealPath(configLocation));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 모든 서블릿, JSP들이 공유할 수 있도록 ServletContext에 DaoFactory 저장
		servletContext.setAttribute("objectFactory", objectFactory);
		
		// application scope에 hotelList 저장.
		adminService = (AdminService)objectFactory.getBean(AdminServiceImpl.class);
		
		ArrayList<Hotel> hotelList = new ArrayList<>();
		try {
			hotelList = adminService.getHotelList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		servletContext.setAttribute("hotelList", hotelList);
		
		logger.debug("XMLObjectFactory 생성 및 ServletContext에 등록 완료!");
	}
	
	
	public void contextDestroyed(ServletContextEvent event)  {
		logger.debug("ServletContext(서블릿컨테이너) 종료.");
    }
}
