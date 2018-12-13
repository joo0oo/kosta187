package kr.or.kosta.spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SecuritySampleController {

	@GetMapping(value="/all")
	public void doAll(){
		log.info("로그인 여부와 상관없이 누구든지 접근할 수 있습니다...");
	}
	
	@GetMapping(value="/member")
	public void doMember(){
		log.info("로그인 회원만 접근할 수 있습니다...");
	}
	
	@GetMapping(value="/admin")
	public void doAdmin(){
		log.info("로그인 관리자만 접근할 수 있습니다...");
	}
}