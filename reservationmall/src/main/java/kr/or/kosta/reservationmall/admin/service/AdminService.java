package kr.or.kosta.reservationmall.admin.service;



import java.util.ArrayList;

import kr.or.kosta.reservationmall.admin.dto.GraphHotelUse;
import kr.or.kosta.reservationmall.admin.dto.GraphMonthUse;
import kr.or.kosta.reservationmall.admin.dto.GraphPriceReserve;
import kr.or.kosta.reservationmall.admin.dto.Hotel;
import kr.or.kosta.reservationmall.admin.dto.Rooms;
import kr.or.kosta.reservationmall.admin.dto.StatisticsInfo;


/**
 * 로그인 관련 처리 
 * 로그인, 회원가입 등
 * @author 허재혁
 */
public interface AdminService {
	
	/**회워 로그인**/
	public boolean create_hotel_info(Hotel hotel) throws Exception;
	public boolean create_rooms_info(Rooms rooms) throws Exception;
	public ArrayList<Hotel> getHotelList() throws Exception;
	
	public StatisticsInfo getStatisticsInfo() throws Exception;
	public ArrayList<GraphMonthUse> getGraphMonthUse() throws Exception;
	public ArrayList<GraphPriceReserve> getGraphPriceReserve() throws Exception;
	public ArrayList<GraphHotelUse> getGraphHotelUse() throws Exception;
	

}
