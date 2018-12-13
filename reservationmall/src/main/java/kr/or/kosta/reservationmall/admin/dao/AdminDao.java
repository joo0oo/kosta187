package kr.or.kosta.reservationmall.admin.dao;

import java.util.ArrayList;

import kr.or.kosta.reservationmall.admin.dto.GraphHotelUse;
import kr.or.kosta.reservationmall.admin.dto.GraphMonthUse;
import kr.or.kosta.reservationmall.admin.dto.GraphPriceReserve;
import kr.or.kosta.reservationmall.admin.dto.Hotel;
import kr.or.kosta.reservationmall.admin.dto.Rooms;
import kr.or.kosta.reservationmall.admin.dto.StatisticsInfo;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface AdminDao {
	
	public boolean create_hotel_info(Hotel hotel) throws Exception;
	public boolean create_rooms_info(Rooms rooms) throws Exception;
	public ArrayList<Hotel> getHotelList() throws Exception;
	public StatisticsInfo getStatisticsInfo() throws Exception;
	public ArrayList<GraphMonthUse> getGraphMonthUse() throws Exception;
	public ArrayList<GraphPriceReserve> getGraphPriceReserve() throws Exception;
	public ArrayList<GraphHotelUse> getGraphHotelUse() throws Exception;
	
}
