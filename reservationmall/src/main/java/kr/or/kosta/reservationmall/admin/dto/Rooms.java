package kr.or.kosta.reservationmall.admin.dto;

public class Rooms {
	/*room_id	NUMBER		NOT NULL,
	room_name	VARCHAR2(50)		NULL,
	room_standard_person_number	NUMBER		NOT NULL,
	room_info	VARCHAR2(500)		NULL,
	room_price	NUMBER		NOT NULL,
	room_detail	VARCHAR2(500)		NULL,
	price_policy_id	NUMBER		NOT NULL,
	hotel_id	NUMBER		NOT NULL*/
	
	private String room_id;
	private String room_name;
	private String room_standard_person_number;
	private String room_info;
	private String room_price;
	private String room_detail;
	private String pirce_policy_id;
	private String hotel_id;
	
	public Rooms() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rooms(String room_id, String room_name, String room_standard_person_number, String room_info,
			String room_price, String room_detail, String pirce_policy_id, String hotel_id) {
		super();
		this.room_id = room_id;
		this.room_name = room_name;
		this.room_standard_person_number = room_standard_person_number;
		this.room_info = room_info;
		this.room_price = room_price;
		this.room_detail = room_detail;
		this.pirce_policy_id = pirce_policy_id;
		this.hotel_id = hotel_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getRoom_standard_person_number() {
		return room_standard_person_number;
	}

	public void setRoom_standard_person_number(String room_standard_person_number) {
		this.room_standard_person_number = room_standard_person_number;
	}

	public String getRoom_info() {
		return room_info;
	}

	public void setRoom_info(String room_info) {
		this.room_info = room_info;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}

	public String getRoom_detail() {
		return room_detail;
	}

	public void setRoom_detail(String room_detail) {
		this.room_detail = room_detail;
	}

	public String getPirce_policy_id() {
		return pirce_policy_id;
	}

	public void setPirce_policy_id(String pirce_policy_id) {
		this.pirce_policy_id = pirce_policy_id;
	}

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	
	
	
}
