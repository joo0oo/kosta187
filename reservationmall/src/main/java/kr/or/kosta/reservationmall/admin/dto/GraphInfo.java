package kr.or.kosta.reservationmall.admin.dto;

import java.util.ArrayList;



public class GraphInfo {
	private ArrayList<GraphMonthUse> month_use;
	private ArrayList<GraphPriceReserve> price_reserve;
	private ArrayList<GraphHotelUse> hotel_use;
	
	public GraphInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GraphInfo(ArrayList<GraphMonthUse> month_use, ArrayList<GraphPriceReserve> price_reserve,
			ArrayList<GraphHotelUse> hotel_use) {
		super();
		this.month_use = month_use;
		this.price_reserve = price_reserve;
		this.hotel_use = hotel_use;
	}

	public ArrayList<GraphMonthUse> getMonth_use() {
		return month_use;
	}

	public void setMonth_use(ArrayList<GraphMonthUse> month_use) {
		this.month_use = month_use;
	}

	public ArrayList<GraphPriceReserve> getPrice_reserve() {
		return price_reserve;
	}

	public void setPrice_reserve(ArrayList<GraphPriceReserve> price_reserve) {
		this.price_reserve = price_reserve;
	}

	public ArrayList<GraphHotelUse> getHotel_use() {
		return hotel_use;
	}

	public void setHotel_use(ArrayList<GraphHotelUse> hotel_use) {
		this.hotel_use = hotel_use;
	}

	
		
}
