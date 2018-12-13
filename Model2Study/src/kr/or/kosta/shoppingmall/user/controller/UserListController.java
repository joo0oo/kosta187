package kr.or.kosta.shoppingmall.user.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;
import kr.or.kosta.shoppingmall.common.service.ServiceFactory;
import kr.or.kosta.shoppingmall.user.domain.User;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;


/**
 *  /hello.mall 요청에 대한 처리 클래스
 *  세부 컨트롤러는 데이터를 처리하고 메인 컨트롤러에게 데이터를 넘겨주는 기능
 *  forward()는 메인컨트롤러가 알아서 함
 * @author 송주현
 *
 */
public class UserListController implements Controller {
	
	private UserService userService= new UserServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav= new ModelAndView(); //리턴타입
		
		ServiceFactory factory= (ServiceFactory)request.getServletContext().getAttribute("serviceFactory");
		userService= (UserService)factory.getService(UserServiceImpl.class);
		List<User> list= null;
		try {
			list= userService.list();
		} catch (Exception e) {
			throw new ServletException("UserService.list() 예외발생", e);
		}
		
		mav.addObject("list", list);
		mav.setView("/user/list.jsp");
		
		return mav; //처리된 데이터 리턴
	}

}
