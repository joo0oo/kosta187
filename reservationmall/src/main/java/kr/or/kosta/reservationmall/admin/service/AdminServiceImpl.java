package kr.or.kosta.reservationmall.admin.service;



import java.util.ArrayList;
import java.util.HashMap;

import kr.or.kosta.reservationmall.admin.dao.AdminDao;
import kr.or.kosta.reservationmall.admin.dto.GraphHotelUse;
import kr.or.kosta.reservationmall.admin.dto.GraphMonthUse;
import kr.or.kosta.reservationmall.admin.dto.GraphPriceReserve;
import kr.or.kosta.reservationmall.admin.dto.Hotel;
import kr.or.kosta.reservationmall.admin.dto.Rooms;
import kr.or.kosta.reservationmall.admin.dto.StatisticsInfo;
import kr.or.kosta.reservationmall.login.dao.LoginDao;


public class AdminServiceImpl implements AdminService {

	private AdminDao adminDao;
	
	public AdminDao getloginDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean create_hotel_info(Hotel hotel) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean create_rooms_info(Rooms rooms) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Hotel> getHotelList() throws Exception {
		return adminDao.getHotelList();
	}

	@Override
	public StatisticsInfo getStatisticsInfo() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getStatisticsInfo();
	}

	@Override
	public ArrayList<GraphMonthUse> getGraphMonthUse() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getGraphMonthUse();
	}

	@Override
	public ArrayList<GraphPriceReserve> getGraphPriceReserve() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getGraphPriceReserve();
	}

	@Override
	public ArrayList<GraphHotelUse> getGraphHotelUse() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.getGraphHotelUse();
	}

	

}





