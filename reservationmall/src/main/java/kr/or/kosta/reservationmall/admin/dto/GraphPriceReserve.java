package kr.or.kosta.reservationmall.admin.dto;

public class GraphPriceReserve {
	private String pay_divde;
	private String pay_count;
	
	public GraphPriceReserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GraphPriceReserve(String pay_divde, String pay_count) {
		super();
		this.pay_divde = pay_divde;
		this.pay_count = pay_count;
	}

	public String getPay_divde() {
		return pay_divde;
	}

	public void setPay_divde(String pay_divde) {
		this.pay_divde = pay_divde;
	}

	public String getPay_count() {
		return pay_count;
	}

	public void setPay_count(String pay_count) {
		this.pay_count = pay_count;
	}
	
	
}
