package kr.or.kosta.jsp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 요청파라메터 한글인코딩 처리 필터
 */
public class CharacterEncodingFilter implements Filter {
	//서블릿처럼 요청이 필요하므로 web.xml에 filter-mapping 등록해야함
		private String encoding;
		//private String encoding= "utf-8";
		
		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			encoding = filterConfig.getInitParameter("encoding");
			//web.xml에 등록된 필터와 inti Param을 가져옴
		}
		
		@Override
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			// 전처리
			if(encoding != null){
				request.setCharacterEncoding(encoding);
			}
			chain.doFilter(request, response); //: 체인 걸기
			// 후처리 : 지금은 필요없음
		}

		@Override
		public void destroy() {	}

}
