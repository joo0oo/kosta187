package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 마임타입 이해를 위한 서블릿
 */
public class MIMEServlet extends HttpServlet {
	//상속받은 init(), service() 메소드 있음
	
	private static final long serialVersionUID = 1L; //클래스가 바뀔 때마다 버전 확인하기 위해서 사용

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		전송할 데이터의 타입을 알려주기
		"text/html" 에서
		text : mime 타입
		html : sub 타입
		*/
		response.setContentType("text/plain; charset=utf-8");  //이 내용이 응답메세지(response)의 헤더에 들어감 
		//헤더에 Cotent-Type:text/plain; charset=utf-8 이렇게 
		PrintWriter out= response.getWriter(); //문자 출력 스트림
		out.println("일반적인 텍스트 입니다");
		
		//실행 끝나면 request, response는 삭제됨 (임시객체)
	}

}
