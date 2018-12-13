package kr.or.kosta.reservationmall.review.dao;

public class Review {
	
	private String id;
	private String content;
	private String date;
	private String serviceRate;
	private String foodRate;
	private String cleanRate;
	private String locationRate;
	private String helpfulCount;
	private String reportCount;
	private String hotelId;
	private String userId;
	
	public Review() {
	}
	
	public Review(String id, String content, String date, String serviceRate, String foodRate, String cleanRate,
			String locationRate, String helpfulCount, String reportCount, String hotelId, String userId) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.serviceRate = serviceRate;
		this.foodRate = foodRate;
		this.cleanRate = cleanRate;
		this.locationRate = locationRate;
		this.helpfulCount = helpfulCount;
		this.reportCount = reportCount;
		this.hotelId = hotelId;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getServiceRate() {
		return serviceRate;
	}

	public void setServiceRate(String serviceRate) {
		this.serviceRate = serviceRate;
	}

	public String getFoodRate() {
		return foodRate;
	}

	public void setFoodRate(String foodRate) {
		this.foodRate = foodRate;
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

	public String getHelpfulCount() {
		return helpfulCount;
	}

	public void setHelpfulCount(String helpfulCount) {
		this.helpfulCount = helpfulCount;
	}

	public String getReportCount() {
		return reportCount;
	}

	public void setReportCount(String reportCount) {
		this.reportCount = reportCount;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", date=" + date + ", serviceRate=" + serviceRate
				+ ", foodRate=" + foodRate + ", cleanRate=" + cleanRate + ", locationRate=" + locationRate
				+ ", helpfulCount=" + helpfulCount + ", reportCount=" + reportCount + ", hotelId=" + hotelId
				+ ", userId=" + userId + "]";
	}

}
