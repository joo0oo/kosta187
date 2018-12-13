package kr.or.kosta.reservationmall.common.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import kr.or.kosta.reservationmall.admin.dto.GraphHotelUse;
import kr.or.kosta.reservationmall.admin.dto.GraphInfo;
import kr.or.kosta.reservationmall.admin.dto.GraphMonthUse;
import kr.or.kosta.reservationmall.admin.dto.GraphPriceReserve;
import kr.or.kosta.reservationmall.admin.dto.StatisticsInfo;
import kr.or.kosta.reservationmall.admin.service.AdminService;
import kr.or.kosta.reservationmall.admin.service.AdminServiceImpl;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;

/**
 * 요청파라메터 한글인코딩 처리 필터
 */
public class IndexDataFilter implements Filter {
	private AdminService adminService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		adminService = (AdminService)factory.getBean(AdminServiceImpl.class);
		
		StatisticsInfo statisticsInfo = new StatisticsInfo();
		ArrayList<GraphMonthUse> graphMonthUseList = new ArrayList<GraphMonthUse>();
		ArrayList<GraphPriceReserve> graphPriceReserveList = new ArrayList<GraphPriceReserve>();
		ArrayList<GraphHotelUse> graphHotelUseList = new ArrayList<GraphHotelUse>();
		GraphInfo graphInfo = new GraphInfo();
		
		try {
			statisticsInfo = adminService.getStatisticsInfo();
			graphMonthUseList = adminService.getGraphMonthUse();
			graphPriceReserveList = adminService.getGraphPriceReserve();
			graphHotelUseList = adminService.getGraphHotelUse();
			graphInfo.setHotel_use(graphHotelUseList);
			graphInfo.setPrice_reserve(graphPriceReserveList);
			graphInfo.setMonth_use(graphMonthUseList);
			
		} catch (Exception e) {
			throw new ServletException("UserService.list() 예외 발생", e);
		}
		request.setAttribute("statisticsInfo", statisticsInfo);
		request.setAttribute("graphInfo", graphInfo);
		chain.doFilter(request, response);
		// 후처리
	}

	@Override
	public void destroy() {	}

	

}
