package kr.or.kosta.reservationmall.individual.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.individual.service.ReservationService;
import kr.or.kosta.reservationmall.individual.service.ReservationServiceImpl;
import kr.or.kosta.reservationmall.individual.service.UserService;
import kr.or.kosta.reservationmall.individual.service.UserServiceImpl;


public class ReservationListController implements Controller {
	
	private ReservationService reservationService;
	Logger logger = Logger.getLogger(Controller.class);
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		reservationService = (ReservationService)factory.getBean(ReservationServiceImpl.class);
		
		List<ReservationInfo> list = null;
		String user_id= "";
		try {
			list = reservationService.listAllReservations(user_id);
			
			for (ReservationInfo reservationInfo : list) {
				logger.debug(reservationInfo);
			}
		} catch (Exception e) {
			throw new ServletException("reservationService.list() 예외 발생", e);
		}
		
		mav.addObject("resList", list);
		mav.setView("/WEB-INF/view/individual/mypage.jsp");
		
		return mav;

	}

}
