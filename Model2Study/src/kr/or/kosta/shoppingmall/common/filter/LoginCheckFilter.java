package kr.or.kosta.shoppingmall.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 사용자 로그인 여부 체크 필터
 */
public class LoginCheckFilter implements Filter {
	
//	private String loginPage = "/user/login.jsp";
	private String loginPage;

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
    	loginPage = filterConfig.getInitParameter("loginPage");
	}

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	System.out.println("[디버깅] : LoginCheckFiler 실행..");
		boolean isLogin = false;
		Cookie[] cookies = ((HttpServletRequest)request).getCookies();
		//ServletRequest 객체에는 getCookies()가 없음 -> 확장된 HttpServletRequest로 형변환
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("loginId")) {
					isLogin = true;
					break;
				}
			}
		}
		
		if(isLogin) {
			chain.doFilter(request, response);
		}else {
			if(loginPage == null) {
				throw new ServletException("LoginCheckFilter에 loginPage가 설정되어 있지 않습니다.");
			}
			request.setAttribute("uri", ((HttpServletRequest)request).getRequestURI());
			//실제 client가 요청한 페이지 : getRequestURI();
			//request에 이 uri를 등록해둠 :setAttribute();
			
			request.getServletContext().getRequestDispatcher(loginPage).forward(request, response);
			//이 작업은 로그인이 필요한 작업 : 로그인 화면으로 forward 시킴 
			//loginPage에서 getAttribute("uri") 로 이 uri 값을 가져올수 있다
			
			//web.xml에 이 필터를 사용할 jsp 페이지를 등록 
			/*
			<filter-mapping>
				<filter-name>LoginCheckFilter</filter-name>
				<url-pattern>/user/list.jsp</url-pattern>
				<url-pattern>/user/listByPage.jsp</url-pattern>
			</filter-mapping>
			*/
		}
	}
    
    @Override
	public void destroy() {}

}
