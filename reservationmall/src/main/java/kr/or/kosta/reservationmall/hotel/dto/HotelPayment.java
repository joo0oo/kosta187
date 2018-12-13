package kr.or.kosta.reservationmall.hotel.dto;

public class HotelPayment {
	private String type_value;
	private int total_price;
	
	public HotelPayment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelPayment(String type_value, int total_price) {
		super();
		this.type_value = type_value;
		this.total_price = total_price;
	}

	public String getType_value() {
		return type_value;
	}

	public void setType_value(String type_value) {
		this.type_value = type_value;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	
}
