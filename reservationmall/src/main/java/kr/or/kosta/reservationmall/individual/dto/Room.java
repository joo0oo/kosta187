package kr.or.kosta.reservationmall.individual.dto;

public class Room {
	
	private int room_id;
	private String noom_name;
	private int room_standard_person_number;
	private int room_child_max_number;
	private String room_info;
	private int room_price;
	private String room_detail;
	private int price_policy_id;
	private int hotel_id;
	
	
	public Room() {
	}

	public Room(int room_id, String noom_name, int room_standard_person_number, int room_child_max_number,
			String room_info, int room_price, String room_detail, int price_policy_id, int hotel_id) {
		super();
		this.room_id = room_id;
		this.noom_name = noom_name;
		this.room_standard_person_number = room_standard_person_number;
		this.room_child_max_number = room_child_max_number;
		this.room_info = room_info;
		this.room_price = room_price;
		this.room_detail = room_detail;
		this.price_policy_id = price_policy_id;
		this.hotel_id = hotel_id;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public String getNoom_name() {
		return noom_name;
	}

	public void setNoom_name(String noom_name) {
		this.noom_name = noom_name;
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

	public String getRoom_info() {
		return room_info;
	}

	public void setRoom_info(String room_info) {
		this.room_info = room_info;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public String getRoom_detail() {
		return room_detail;
	}

	public void setRoom_detail(String room_detail) {
		this.room_detail = room_detail;
	}

	public int getPrice_policy_id() {
		return price_policy_id;
	}

	public void setPrice_policy_id(int price_policy_id) {
		this.price_policy_id = price_policy_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", noom_name=" + noom_name + ", room_standard_person_number="
				+ room_standard_person_number + ", room_child_max_number=" + room_child_max_number + ", room_info="
				+ room_info + ", room_price=" + room_price + ", room_detail=" + room_detail + ", price_policy_id="
				+ price_policy_id + ", hotel_id=" + hotel_id + "]";
	}
	
	
	
}
