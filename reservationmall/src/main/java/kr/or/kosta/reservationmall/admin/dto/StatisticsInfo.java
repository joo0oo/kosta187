package kr.or.kosta.reservationmall.admin.dto;

public class StatisticsInfo {
	private String total_review;
	private String total_reservation;
	private String total_user;
	
	public StatisticsInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatisticsInfo(String total_review, String total_reservation, String total_user) {
		super();
		this.total_review = total_review;
		this.total_reservation = total_reservation;
		this.total_user = total_user;
	}

	public String getTotal_review() {
		return total_review;
	}

	public void setTotal_review(String total_review) {
		this.total_review = total_review;
	}

	public String getTotal_reservation() {
		return total_reservation;
	}

	public void setTotal_reservation(String total_reservation) {
		this.total_reservation = total_reservation;
	}

	public String getTotal_user() {
		return total_user;
	}

	public void setTotal_user(String total_user) {
		this.total_user = total_user;
	}

	
	
	
	
}
