package kr.or.kosta.reservationmall.room.domain;

public class Room {

	private String id;
	private String name;
	private int standardNumber;
	private String info;
	private int price;
	private String detail;
	private int pricePolicyId; // 가격 정책도 id로?
	private int hotelId;

	public Room() {
	}

	public Room(String id, String name, int standardNumber, String info, int price, String detail, int pricePolicyId,
			int hotelId) {
		super();
		this.id = id;
		this.name = name;
		this.standardNumber = standardNumber;
		this.info = info;
		this.price = price;
		this.detail = detail;
		this.pricePolicyId = pricePolicyId;
		this.hotelId = hotelId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStandardNumber() {
		return standardNumber;
	}

	public void setStandardNumber(int standardNumber) {
		this.standardNumber = standardNumber;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getPricePolicyId() {
		return pricePolicyId;
	}

	public void setPricePolicyId(int pricePolicyId) {
		this.pricePolicyId = pricePolicyId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", name=" + name + ", standardNumber=" + standardNumber + ", info=" + info
				+ ", price=" + price + ", detail=" + detail + ", pricePolicyId=" + pricePolicyId + ", hotelId="
				+ hotelId + "]";
	}

}
