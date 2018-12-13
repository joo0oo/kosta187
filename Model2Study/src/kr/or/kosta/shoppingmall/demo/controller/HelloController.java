package kr.or.kosta.shoppingmall.demo.controller;

import java.util.ArrayList;
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
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav= new ModelAndView(); //리턴타입
		
		// 모델영역의 비즈니스 메소드 호출 및 데이터 반환
		// String message = xxxService.bizMethod();
		String message = "모델2 기반 웹애플리케이션 개발";

		List<String> list = new ArrayList<String>();
		list.add("Doosan 타이거즈");
		list.add("LG 베어즈");
		list.add("Samsung 트윈즈");

		mav.addObject("message", message);
		mav.addObject("list", list);
		mav.setView("/demo/hello.jsp");

		return mav; //처리된 데이터 리턴
	}

}
