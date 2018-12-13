package kr.or.kosta.shoppingmall.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class SimpleDataController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		
		// plain text, xml, json 데이터를 바로 출력하는 경우 바로 브라우저에 보이기만 하면 된다 
		// (넘기지 않고 여기서 바로 처리) 굳이 view가 필요없음
		String message = "view가 필요 없는 간단한 데이터 처리";
		response.setContentType("text/plain; charset=utf-8");

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(message);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(), e);
		}
		
		
		return null;
	}

}
