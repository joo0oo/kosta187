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

public class AjaxController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		String num1= request.getParameter("num1");
		String num2= request.getParameter("num2");
		String op= request.getParameter("op");

		System.out.println("[from client]"+num1+" : "+num2+" : "+op);
		int res=0;

		if(num1 != null && num2 != null){
		  int n1= Integer.parseInt(num1);
		  int n2= Integer.parseInt(num2);
		  
		  switch(op){
		  case "plus":
		    res=n1+n2;
		    break;
		  case "-":
		    res=n1-n2;
		    break;
		  case "*":
		    res=n1*n2;
		    break;
		  case "/":
		    res=n1/n2;
		    break;
		  }
		}
		System.out.println("res : "+res);
		
		// plain text, xml, json 데이터 바로 출력
		String message = "모델2 기반 웹애플리케이션 개발";
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println(res);
		} catch (IOException e) {
			throw new ServletException(e.getMessage(),e);
		}
		return null;
	}

}






