package kr.or.kosta.reservationmall.hotel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.hotel.dto.HotelInfo;
import kr.or.kosta.reservationmall.hotel.dto.HotelRateAvg;
import kr.or.kosta.reservationmall.hotel.dto.HotelRoomAvg;
import kr.or.kosta.reservationmall.hotel.service.HotelService;
import kr.or.kosta.reservationmall.hotel.service.HotelServiceImpl;
import kr.or.kosta.reservationmall.hotel.service.HotelStatisService;
import kr.or.kosta.reservationmall.hotel.service.HotelStatisServiceImpl;

/**
 * hello.mall 요청에 대한 처리 클래스
 * 
 * @author HeoJaehyeok
 *
 */
public class SearchHotelController implements Controller {
	private HotelService hotelService;
	private HotelStatisService hotelStatisService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		hotelService = (HotelService) factory.getBean(HotelServiceImpl.class);
		hotelStatisService = (HotelStatisService) factory.getBean(HotelStatisServiceImpl.class);
		Map<String, Object> paramMap = new HashMap<>();
		String userId = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("loginId")) {
					request.setAttribute("userId", cookie.getValue());
					userId = cookie.getValue();
					break;
				}
			}
		}
		String type = "search";
		String[] adultNumber = request.getParameterValues("searchAdultNumber");
		request.setAttribute("searchAdultNumber", adultNumber);
		String[] childNumber = request.getParameterValues("searchChildNumber");
		request.setAttribute("searchChildNumber", childNumber);
		for (int i = 0; i < childNumber.length; i++) {
			paramMap.put("AdultNumber" + (i + 1), adultNumber[i]);
			paramMap.put("ChildNumber" + (i + 1), childNumber[i]);
		}
		Set<String> set = request.getParameterMap().keySet();
		for (String key : set) {
			if (key.startsWith(type)) {
				String typeRemovedKey = key.substring(type.length());
				String[] parameters = request.getParameterValues(key);
				if (parameters.length > 1) {
					request.setAttribute(key, parameters);
				} else {
					paramMap.put(typeRemovedKey, parameters[0].trim());
					request.setAttribute(key, parameters[0].trim());
				}
			}
		}
		//허재혁 수정 2018-11-12 통계관련
		HotelRateAvg hotelRateAvg = new HotelRateAvg();
		HotelRoomAvg hotelRoomAvg = new HotelRoomAvg();
		List<HotelInfo> hotelInfos = null;
		try {
			hotelInfos = hotelService.getHotelInfos(paramMap, userId);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		if (hotelInfos != null && hotelInfos.size() >= 1) {
			String hotelIds = "";
			for (HotelInfo hotelInfo : hotelInfos) {
				hotelIds += hotelInfo.getHotelId() + ",";
			}
			Map<String, List<String>> hotelImages = null;
			try {
				hotelImages = hotelService.getHotelImages(hotelIds.substring(0, hotelIds.length() - 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("noResult", false);
			mav.addObject("hotelImages", hotelImages);
			mav.addObject("hotelInfos", hotelInfos);
		} else {
			mav.addObject("noResult", true);
		}
		if (request.getAttribute("refreshPage") != null && (boolean)request.getAttribute("refreshPage")) {
			request.removeAttribute("refreshPage");
			request.getSession().setAttribute("refreshPage", true);
		}
		

		try {
			hotelRateAvg = hotelStatisService.getHotelRateAvg();
			hotelRoomAvg = hotelStatisService.getHotelRoomAvg();
			mav.addObject("hotelRateAvg", hotelRateAvg);
			mav.addObject("hotelRoomAvg", hotelRoomAvg);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		mav.setView("/WEB-INF/view/search/search.jsp");
		return mav;
	}

}
