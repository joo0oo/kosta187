package kr.or.kosta.reservationmall.board.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.board.dto.Board;
import kr.or.kosta.reservationmall.board.service.BoardService;
import kr.or.kosta.reservationmall.board.service.BoardServiceImpl;
import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.login.service.LoginService;
import kr.or.kosta.reservationmall.login.service.LoginServiceImpl;

/**
 * 게시판 활용을 위한 컨트롤러 설정
 * @author 이혜림
 *
 */
public class BoardController implements Controller {
	
	private BoardService boardservice;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		boardservice = (BoardService)factory.getBean(BoardServiceImpl.class);

		List <Board> list= null;
		 
		try {
			list = boardservice.listAll_hr();
		} catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("list", list);
		mav.setView("index.jsp");
		
		
		
		return mav;
		
	}
	
	

}
