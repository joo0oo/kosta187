package kr.or.kosta.reservationmall.individual.dto;

/**
 * 마이페이지 예약 내역 조회 페이지에서 사용하는 DTO
 * @author 송주현
 *
 */
public class ReservationInfo {

	
	/* reservation 테이블 */
	/* rooms 테이블 */
	/* hotels 테이블 */
	/* payments 테이블 */
	
	private int reservation_id; //예약번호 
	private String hotel_name; //호텔이름
	private int hotel_id; //호텔이름
	
	private int reservation_status; //예약상태
	private String reservation_start_day; //체크인 
	private String reservation_end_day; //체크아웃
	private String hotel_address; //호텔주소
	
	private String room_name; //방이름
	private int room_standard_person_number; //방 기준인원
	private int room_child_max_number; //방 기준인원
	
	private int total_price; //결제금액
	private String payment_day; //결제일
	private String payment_type; //결제유형
	
	private String payment_cancellation_day; //결제취소일
	
	private int start_day_check; //시작 예약인지 확인
	private int end_day_check; //끝난 예약인지 확인
	
	public ReservationInfo() {
		super();
	}

	public ReservationInfo(int reservation_id, String hotel_name, int hotel_id, int reservation_status,
			String reservation_start_day, String reservation_end_day, String hotel_address, String room_name,
			int room_standard_person_number, int room_child_max_number, int total_price, String payment_day,
			String payment_type, String payment_cancellation_day, int start_day_check, int end_day_check) {
		super();
		this.reservation_id = reservation_id;
		this.hotel_name = hotel_name;
		this.hotel_id = hotel_id;
		this.reservation_status = reservation_status;
		this.reservation_start_day = reservation_start_day;
		this.reservation_end_day = reservation_end_day;
		this.hotel_address = hotel_address;
		this.room_name = room_name;
		this.room_standard_person_number = room_standard_person_number;
		this.room_child_max_number = room_child_max_number;
		this.total_price = total_price;
		this.payment_day = payment_day;
		this.payment_type = payment_type;
		this.payment_cancellation_day = payment_cancellation_day;
		this.start_day_check = start_day_check;
		this.end_day_check = end_day_check;
	}



	public int getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public int getReservation_status() {
		return reservation_status;
	}

	public void setReservation_status(int reservation_status) {
		this.reservation_status = reservation_status;
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

	public String getHotel_address() {
		return hotel_address;
	}

	public void setHotel_address(String hotel_address) {
		this.hotel_address = hotel_address;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public int getRoom_standard_person_number() {
		return room_standard_person_number;
	}

	public void setRoom_standard_person_number(int room_standard_person_number) {
		this.room_standard_person_number = room_standard_person_number;
	}

	public int getRoom_child_max_number() {
		return room_child_max_number;
	}

	public void setRoom_child_max_number(int room_child_max_number) {
		this.room_child_max_number = room_child_max_number;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getPayment_day() {
		return payment_day;
	}

	public void setPayment_day(String payment_day) {
		this.payment_day = payment_day;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getPayment_cancellation_day() {
		return payment_cancellation_day;
	}

	public void setPayment_cancellation_day(String payment_cancellation_day) {
		this.payment_cancellation_day = payment_cancellation_day;
	}
	
	public int getEnd_day_check() {
		return end_day_check;
	}


	public void setEnd_day_check(int end_day_check) {
		this.end_day_check = end_day_check;
	}


	public int getStart_day_check() {
		return start_day_check;
	}

	public void setStart_day_check(int start_day_check) {
		this.start_day_check = start_day_check;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	
	@Override
	public String toString() {
		return "ReservationInfo [reservation_id=" + reservation_id + ", hotel_name=" + hotel_name + ", hotel_id="
				+ hotel_id + ", reservation_status=" + reservation_status + ", reservation_start_day="
				+ reservation_start_day + ", reservation_end_day=" + reservation_end_day + ", hotel_address="
				+ hotel_address + ", room_name=" + room_name + ", room_standard_person_number="
				+ room_standard_person_number + ", room_child_max_number=" + room_child_max_number + ", total_price="
				+ total_price + ", payment_day=" + payment_day + ", payment_type=" + payment_type
				+ ", payment_cancellation_day=" + payment_cancellation_day + ", start_day_check=" + start_day_check
				+ ", end_day_check=" + end_day_check + "]";
	}
	
}
