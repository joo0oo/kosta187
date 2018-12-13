package kr.or.kosta.reservationmall.hotel.dto;

public class HotelReserveCheck {
	private int hotel_id;
	private String room_name;
	private String reservation_start_day;
	private String reservation_end_day;
	private int count;
	
	public HotelReserveCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelReserveCheck(int hotel_id, String room_name, String reservation_start_day, String reservation_end_day,
			int count) {
		super();
		this.hotel_id = hotel_id;
		this.room_name = room_name;
		this.reservation_start_day = reservation_start_day;
		this.reservation_end_day = reservation_end_day;
		this.count = count;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getReservation_start_day() {
		return reservation_start_day;
	}

	public void setReservation_start_day(String reservation_start_day) {
		this.reservation_start_day = reservation_start_day;
	}

	public String getReservation_end_day() {
		return reservation_end_day;
	}

	public void setReservation_end_day(String reservation_end_day) {
		this.reservation_end_day = reservation_end_day;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
