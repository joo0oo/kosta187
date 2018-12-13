package kr.or.kosta.reservationmall.individual.dto;
/**
 * 마이페이지 최근조회항목에서 사용할 DTO
 * @author 송주현
 *
 */
public class Lastview {
	
	private int lastview_id; 
	private int hotel_id;
	private String user_id;
	private String lastview_date;
	
	public Lastview() {
	}

	public Lastview(int lastview_id, int hotel_id, String user_id, String lastview_date) {
		super();
		this.lastview_id = lastview_id;
		this.hotel_id = hotel_id;
		this.user_id = user_id;
		this.lastview_date = lastview_date;
	}

	public int getLastview_id() {
		return lastview_id;
	}

	public void setLastview_id(int lastview_id) {
		this.lastview_id = lastview_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLastview_date() {
		return lastview_date;
	}

	public void setLastview_date(String lastview_date) {
		this.lastview_date = lastview_date;
	}

	@Override
	public String toString() {
		return "Lastview [lastview_id=" + lastview_id + ", hotel_id=" + hotel_id + ", user_id=" + user_id
				+ ", lastview_date=" + lastview_date + "]";
	}
	
}
