package kr.or.kosta.reservationmall.individual.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.hotel.service.HotelService;
import kr.or.kosta.reservationmall.hotel.service.HotelServiceImpl;
import kr.or.kosta.reservationmall.individual.dto.Lastview;
import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;
import kr.or.kosta.reservationmall.individual.service.MyWishlistService;
import kr.or.kosta.reservationmall.individual.service.MyWishlistServiceImpl;
import kr.or.kosta.reservationmall.individual.service.LastviewService;
import kr.or.kosta.reservationmall.individual.service.LastviewServiceImpl;
import kr.or.kosta.reservationmall.individual.service.ReservationService;
import kr.or.kosta.reservationmall.individual.service.ReservationServiceImpl;
import kr.or.kosta.reservationmall.individual.service.UserService;
import kr.or.kosta.reservationmall.individual.service.UserServiceImpl;
import kr.or.kosta.reservationmall.login.dto.User;


/**
 * 마이페이지로 이동 시 사용자 정보/ 예약 정보/ 위시리스트 정보 받아오기
 */
public class MypageLoadFilter implements Filter {
	
	private Logger logger = Logger.getLogger(MypageLoadFilter.class);
	
//	private String loginPage = "/user/login.jsp";
//	private String loginPage;
	private UserService userService;
	private ReservationService reservationService;
	private HotelService hotelService;
	private MyWishlistService myWishlistService;
	private LastviewService lastviewService;
	
    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
    //	loginPage = filterConfig.getInitParameter("loginPage");
	}

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    	logger.debug("MypageLoadFilter 실행..");
		//boolean isLogin = false;
    	XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
    	userService= (UserService) factory.getBean(UserServiceImpl.class); 
    	reservationService= (ReservationService) factory.getBean(ReservationServiceImpl.class); //예약정보
    	myWishlistService= (MyWishlistService)factory.getBean(MyWishlistServiceImpl.class); //위시리스트 호텔 아이디 목록 가져오기
    	hotelService = (HotelService)factory.getBean(HotelServiceImpl.class); //위시리스트 호텔 이미지 가져오기
    	lastviewService = (LastviewService)factory.getBean(LastviewServiceImpl.class); //최근본항목 리스트 가져오기
    	
    	
		String userId= (String) request.getAttribute("userId");
		logger.debug("MypageLoadFilter : "+userId);
		if(userId != null) {
			User user= new User();
			List<ReservationInfo> resList= new ArrayList<ReservationInfo>(); //예약정보 
			List<Integer> wishlist= new ArrayList<Integer>(); //위시리스트의 호텔id
			List<Lastview> lastList= new ArrayList<Lastview>(); //최근본 호텔 목록
			
			Map<String, List<String>> wishHotelImages = null; //위시리스트의 호텔id별 이미지들
			Map<String, List<String>> resHotelImages = null; //예약리스트의 호텔id별 이미지들
			Map<String, List<String>> lastHotelImages = null; //최근리스트의 호텔id별 이미지들
			
			try {
				//해당 userId로 유저 정보, 예약 정보, 위시리스트 정보 가져오기
				user= userService.searchById(userId);
				logger.debug("~~~~~"+user.getUser_id()+" : "+user.getUser_pw());
				request.setAttribute("user", user);
				
				
				resList= reservationService.listAllReservations(userId);
				logger.debug("~~~~예약정보 !! "+resList);
				String resHotelIds = "";
			
				if(resList != null && resList.size() > 0) {
					for (ReservationInfo resInfo : resList) {
						resHotelIds += resInfo.getHotel_id() + ",";
					}
					//logger.debug("~~~~~resHotelIds"+resHotelIds);
					resHotelImages = hotelService.getHotelImages(resHotelIds.substring(0, resHotelIds.length() - 1));
					logger.debug("송주현바보" + resHotelImages);
					//logger.debug("~~~~~resHotelImages"+resHotelImages);
					
					request.setAttribute("resList", resList);
					request.setAttribute("resHotelImages", resHotelImages);
				} else {
					request.setAttribute("resList", null);
					request.setAttribute("resHotelImages", null);
				}
				logger.debug(userId);
				wishlist= myWishlistService.getWishlist(userId);
				logger.debug("~~~~~wishlist"+wishlist);
				//logger.debug("~~~~~is null wishlist : "+(wishlist==null));
				//logger.debug("~~~~~size of wishlist : "+wishlist.size());
				
				
				lastList= lastviewService.getMyLastview(userId);
				logger.debug("~~~~~lastList"+lastList);
				//logger.debug("~~~~~is null lastList : "+(lastList==null));
				//logger.debug("~~~~~size of lastList : "+lastList.size());
				
				String wishHotelIds = "";
				if(wishlist != null && wishlist.size() > 0) {
					for (int hotelId : wishlist) {
						wishHotelIds += hotelId + ",";
					}
					//logger.debug("~~~~~wishHotelIds"+wishHotelIds);
					wishHotelImages = hotelService.getHotelImages(wishHotelIds.substring(0, wishHotelIds.length() - 1));
					//logger.debug("~~~~~wishHotelImages"+wishHotelImages);
					
					request.setAttribute("wishlistIds", wishlist);
					request.setAttribute("wishHotelImages", wishHotelImages);
				} else {
					
					request.setAttribute("wishlistIds", null);
					request.setAttribute("wishHotelImages", null);
					logger.debug("wishlist size 0 -> set null");
				}
				
				String lastHotelIds = "";
				if(lastList != null && lastList.size() > 0 ) {
					for (Lastview lastview : lastList) {
						lastHotelIds += lastview.getHotel_id() + ",";
					}
					//logger.debug("~~~~~lastHotelIds"+lastHotelIds);
					lastHotelImages = hotelService.getHotelImages(lastHotelIds.substring(0, lastHotelIds.length() - 1));
					//logger.debug("~~~~~lastHotelImages"+lastHotelImages);
					
					request.setAttribute("lastList", lastList);
					request.setAttribute("lastHotelImages", lastHotelImages);
				} else {
					request.setAttribute("lastList", null);
					request.setAttribute("lastHotelImages", null);
					logger.debug("lastList size 0 -> set null");
				}
				
				
				logger.debug("  setAttribute()");
				
			} catch (Exception e) {
				logger.debug(" * MypageFilter 에러 ");
				throw new ServletException(e.getMessage(),e);
			}
		}
		
		chain.doFilter(request, response);
		
	}
    
    @Override
	public void destroy() {}

}
