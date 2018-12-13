package kr.or.kosta.shoppingmall.demo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;


/**
 *  /hello.mall 요청에 대한 처리 클래스
 *  세부 컨트롤러는 데이터를 처리하고 메인 컨트롤러에게 데이터를 넘겨주는 기능
 *  forward()는 메인컨트롤러가 알아서 함
 * @author 송주현
 *
 */
public class TodayController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav= new ModelAndView(); //리턴타입
		
		Calendar calendar= Calendar.getInstance();
		String today= String.format("%1$tF %1$tT", calendar);
		
		mav.addObject("today", today);
		mav.setView("/demo/today.jsp");

		return mav; 
	}

}
