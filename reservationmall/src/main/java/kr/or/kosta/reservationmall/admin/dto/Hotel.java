package kr.or.kosta.reservationmall.admin.dto;

public class Hotel {
	private String hotel_id;
	private String hotel_name;
	private String hotel_address;
	private String hotel_phonenum;
	private String hotel_rate;
	private String hotel_info;
	private String hotel_detail;
	private String hotel_website;
	private String hotel_x;
	private String hotel_y;
	private String location_id;
	
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hotel(String hotel_id, String hotel_address, String hotel_rate, String hotel_info, String hotel_detail,
			String location_id) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_address = hotel_address;
		this.hotel_rate = hotel_rate;
		this.hotel_info = hotel_info;
		this.hotel_detail = hotel_detail;
		this.location_id = location_id;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public String getHotel_rate() {
		return hotel_rate;
	}

	public void setHotel_rate(String hotel_rate) {
		this.hotel_rate = hotel_rate;
	}

	public String getHotel_info() {
		return hotel_info;
	}

	public void setHotel_info(String hotel_info) {
		this.hotel_info = hotel_info;
	}

	public String getHotel_detail() {
		return hotel_detail;
	}

	public void setHotel_detail(String hotel_detail) {
		this.hotel_detail = hotel_detail;
	}

	public String getLocation_id() {
		return location_id;
	}

	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_phonenum() {
		return hotel_phonenum;
	}

	public void setHotel_phonenum(String hotel_phonenum) {
		this.hotel_phonenum = hotel_phonenum;
	}

	public String getHotel_website() {
		return hotel_website;
	}

	public void setHotel_website(String hotel_website) {
		this.hotel_website = hotel_website;
	}

	public String getHotel_x() {
		return hotel_x;
	}

	public void setHotel_x(String hotel_x) {
		this.hotel_x = hotel_x;
	}

	public String getHotel_y() {
		return hotel_y;
	}

	public void setHotel_y(String hotel_y) {
		this.hotel_y = hotel_y;
	}
	
	
	
}
