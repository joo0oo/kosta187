package kr.or.kosta.reservationmall.hotel.dto;

public class HotelReserve {
	private String reservation_start_day;
	private String reservation_end_day;
	private String user_id;
	private int payment_id;
	private String room_name;
	private int hotel_id;
	
	public HotelReserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HotelReserve(String reservation_start_day, String reservation_end_day, String user_id, int payment_id,
			String room_name, int hotel_id) {
		super();
		this.reservation_start_day = reservation_start_day;
		this.reservation_end_day = reservation_end_day;
		this.user_id = user_id;
		this.payment_id = payment_id;
		this.room_name = room_name;
		this.hotel_id = hotel_id;
	}
	
	
	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	
	
}
