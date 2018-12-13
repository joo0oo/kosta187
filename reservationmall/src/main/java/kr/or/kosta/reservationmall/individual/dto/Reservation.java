package kr.or.kosta.reservationmall.individual.dto;

public class Reservation {


	private String reservation_id;
	private String reservation_start_day;
	private String reservtion_end_day;
	private String user_id;
	private int payment_id;
	private int room_id;
	private int reservation_status;

	public Reservation() {
	}


	public String getReservation_id() {
		return reservation_id;
	}


	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}


	public String getReservation_start_day() {
		return reservation_start_day;
	}


	public void setReservation_start_day(String reservation_start_day) {
		this.reservation_start_day = reservation_start_day;
	}


	public String getReservtion_end_day() {
		return reservtion_end_day;
	}


	public void setReservtion_end_day(String reservtion_end_day) {
		this.reservtion_end_day = reservtion_end_day;
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


	public int getRoom_id() {
		return room_id;
	}


	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}


	public int getReservation_status() {
		return reservation_status;
	}


	public void setReservation_status(int reservation_status) {
		this.reservation_status = reservation_status;
	}


	@Override
	public String toString() {
		return "Reservation [reservation_id=" + reservation_id + ", reservation_start_day=" + reservation_start_day
				+ ", reservtion_end_day=" + reservtion_end_day + ", user_id=" + user_id + ", payment_id=" + payment_id
				+ ", room_id=" + room_id + ", reservation_status=" + reservation_status + "]";
	}
	
	
	
}
