package kr.or.kosta.reservationmall.note.controller;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.note.dto.Notes;
import kr.or.kosta.reservationmall.note.service.NoteService;
import kr.or.kosta.reservationmall.note.service.NoteServiceImpl;

/**
 * 노트(쪽지) 등록 처리 
 * note 추가를 위한 요청 컨트롤러 설정 
 * @author 이혜림
 *
 */
public class NoteController implements Controller {
	
	private NoteService noteService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		noteService = (NoteService)factory.getBean(NoteServiceImpl.class);

		System.out.println("################## !! 노트 컨트롤러 서비스 스타트 !! ##################");

		logger.debug("NoteController start");
		
		String user_id = (String) request.getParameter("user_id"); 
		String note_email = (String) request.getParameter("note_email");
		String note_question = (String) request.getParameter("note_question");
		
		logger.debug("유저 아이디 (컨트롤러)" + user_id);
		logger.debug("유저 이메일 (컨트롤러)" + note_email);
		logger.debug("유저 질문내용 (컨트롤러)" + note_question);
		
		Notes note = new Notes();
		note.setUser_id(user_id);
		note.setNote_email(note_email);
		note.setNote_question(note_question);
		
		
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;

		String result = "";
		try {
			//결과 전달 
			out = response.getWriter();
			//create  
			noteService.create_hr(note);
			System.out.println(note);
			result = "success";
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			result = "fail";
		}
		
		out.println(result);
		return null;
	}
	

}
