package kr.or.kosta.spring.demo.controller;


import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring 2.5 이후 세부 컨트롤러 (POJO)
 * @author 송주현
 *
 */

@Controller
@RequestMapping("/demo")
public class HelloController2 {

	@RequestMapping(value="/hello")
	public String hello( Model model){
		
		//mav 사용안함 -> model 에 데이터 저장
		// mav의 view 역할을 리턴 (jsp 경로를 리턴)
		
		String message="spring MVC모듈 입니다";
		model.addAttribute("message",message);

		return "demo/hello"; // jsp 경로
	}
	
	@RequestMapping(value="/today")
	public String today( Model model){
		
		Calendar cal= Calendar.getInstance();
		String time= String.format("%1$tF %1$tT",cal);
		String message="spring MVC모듈 입니다";
		model.addAttribute("today",time);

		return "demo/today"; // jsp 경로
	}

	@RequestMapping(value="/find",params="admin=true")
	public String admin( Model model){
		
		model.addAttribute("message","관리자 화면 입니다");
		return "demo/admin"; // jsp 경로
	}
}
