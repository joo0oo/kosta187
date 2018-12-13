package kr.or.kosta.reservationmall.admin.dto;

public class GraphHotelUse {
	private String hotel_name;
	private String hotel_count;
	
	public GraphHotelUse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GraphHotelUse(String hotel_name, String hotel_count) {
		super();
		this.hotel_name = hotel_name;
		this.hotel_count = hotel_count;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_count() {
		return hotel_count;
	}

	public void setHotel_count(String hotel_count) {
		this.hotel_count = hotel_count;
	}
	
	
}
