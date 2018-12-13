package kr.or.kosta.reservationmall.admin.dto;

public class GraphMonthUse {
	private String reserve_month;
	private String reserve_count;
	
	public GraphMonthUse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GraphMonthUse(String reserve_month, String reserve_count) {
		super();
		this.reserve_month = reserve_month;
		this.reserve_count = reserve_count;
	}

	public String getReserve_month() {
		return reserve_month;
	}

	public void setReserve_month(String reserve_month) {
		this.reserve_month = reserve_month;
	}

	public String getReserve_count() {
		return reserve_count;
	}

	public void setReserve_count(String reserve_count) {
		this.reserve_count = reserve_count;
	}
	
	
}
