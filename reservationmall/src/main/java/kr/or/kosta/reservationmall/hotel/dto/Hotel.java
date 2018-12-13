package kr.or.kosta.reservationmall.hotel.dto;

public class Hotel {

	private String id;
	private String name;
	private String address;
	private String phonenum;
	private String rate;
	private String info;
	private String detail;
	private String website;
	private String x;
	private String y;
	private String locationName;

	public Hotel() {
	}

	public Hotel(String id, String name, String address, String phonenum, String rate, String info, String detail,
			String website, String x, String y, String locationName) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phonenum = phonenum;
		this.rate = rate;
		this.info = info;
		this.detail = detail;
		this.website = website;
		this.x = x;
		this.y = y;
		this.locationName = locationName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "Hotel [id=" + id + ", name=" + name + ", address=" + address + ", phonenum=" + phonenum + ", rate="
				+ rate + ", info=" + info + ", detail=" + detail + ", website=" + website + ", x=" + x + ", y=" + y
				+ ", locationName=" + locationName + "]";
	}
	
}
