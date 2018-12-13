package kr.or.kosta.reservationmall.hotel.dto;

public class HotelSearchResult {
	private int hotelId;
	private String roomName;
	private String price;
	private String standardNumber;
	private String childMaxNumber;
	private String roomInfo;
	private String roomDetail;
	private String priceRate;
	private String foodRate;
	private String serviceRate;
	private String cleanRate;
	private String locationRate;

	public HotelSearchResult() {
	}

	public HotelSearchResult(int hotelId, String roomName, String price, String standardNumber, String childMaxNumber,
			String roomInfo, String roomDetail, String priceRate, String foodRate, String serviceRate, String cleanRate,
			String locationRate) {
		super();
		this.hotelId = hotelId;
		this.roomName = roomName;
		this.price = price;
		this.standardNumber = standardNumber;
		this.childMaxNumber = childMaxNumber;
		this.roomInfo = roomInfo;
		this.roomDetail = roomDetail;
		this.priceRate = priceRate;
		this.foodRate = foodRate;
		this.serviceRate = serviceRate;
		this.cleanRate = cleanRate;
		this.locationRate = locationRate;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getPriceRate() {
		return priceRate;
	}

	public void setPriceRate(String priceRate) {
		this.priceRate = priceRate;
	}

	public String getFoodRate() {
		return foodRate;
	}

	public void setFoodRate(String foodRate) {
		this.foodRate = foodRate;
	}

	public String getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(String serviceRate) {
		this.serviceRate = serviceRate;
	}

	public String getCleanRate() {
		return cleanRate;
	}

	public void setCleanRate(String cleanRate) {
		this.cleanRate = cleanRate;
	}

	public String getLocationRate() {
		return locationRate;
	}

	public void setLocationRate(String locationRate) {
		this.locationRate = locationRate;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStandardNumber() {
		return standardNumber;
	}

	public void setStandardNumber(String standardNumber) {
		this.standardNumber = standardNumber;
	}

	public String getChildMaxNumber() {
		return childMaxNumber;
	}

	public void setChildMaxNumber(String childMaxNumber) {
		this.childMaxNumber = childMaxNumber;
	}

	public String getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(String roomInfo) {
		this.roomInfo = roomInfo;
	}

	public String getRoomDetail() {
		return roomDetail;
	}

	public void setRoomDetail(String roomDetail) {
		this.roomDetail = roomDetail;
	}

	@Override
	public String toString() {
		return "HotelSearchResult [hotelId=" + hotelId + ", roomName=" + roomName + ", price=" + price
				+ ", standardNumber=" + standardNumber + ", childMaxNumber=" + childMaxNumber + ", roomInfo=" + roomInfo
				+ ", roomDetail=" + roomDetail + ", priceRate=" + priceRate + ", foodRate=" + foodRate
				+ ", serviceRate=" + serviceRate + ", cleanRate=" + cleanRate + ", locationRate=" + locationRate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		HotelSearchResult result = (HotelSearchResult) obj;
		return (result.getHotelId() + result.getRoomName()).equals(hotelId + roomName);
	}

}
