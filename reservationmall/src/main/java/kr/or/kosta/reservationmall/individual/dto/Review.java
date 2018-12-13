package kr.or.kosta.reservationmall.individual.dto;
/**
 * 마이페이지 리뷰 페이지에서 사용할 DTO
 * 리뷰쓰기 기능
 * @author 송주현
 *
 */
public class Review {
	
	private int review_id; 
	private String review_content;
	private String review_date;
	
	//평점
	private int review_service_rate;
	private int review_food_rate;
	private int review_clean_rate;
	private int review_location_rate;
	private int review_price_rate;
	
	private int review_helpful_count;
	private int review_report_count;
	
	private int hotel_id;
	private int reservation_id;
	private String user_id;
	
	
	
	public Review() {
	}
	
	

	public Review(int review_id, String review_content, String review_date, int review_service_rate,
			int review_food_rate, int review_clean_rate, int review_location_rate, int review_price_rate,
			int review_helpful_count, int review_report_count, int hotel_id, int reservation_id, String user_id) {
		super();
		this.review_id = review_id;
		this.review_content = review_content;
		this.review_date = review_date;
		this.review_service_rate = review_service_rate;
		this.review_food_rate = review_food_rate;
		this.review_clean_rate = review_clean_rate;
		this.review_location_rate = review_location_rate;
		this.review_price_rate = review_price_rate;
		this.review_helpful_count = review_helpful_count;
		this.review_report_count = review_report_count;
		this.hotel_id = hotel_id;
		this.reservation_id = reservation_id;
		this.user_id = user_id;
	}



	public int getReview_id() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getReview_content() {
		return review_content;
	}

	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}

	public String getReview_date() {
		return review_date;
	}

	public void setReview_date(String review_date) {
		this.review_date = review_date;
	}

	public int getReview_service_rate() {
		return review_service_rate;
	}

	public void setReview_service_rate(int review_service_rate) {
		this.review_service_rate = review_service_rate;
	}

	public int getReview_food_rate() {
		return review_food_rate;
	}

	public void setReview_food_rate(int review_food_rate) {
		this.review_food_rate = review_food_rate;
	}

	public int getReview_clean_rate() {
		return review_clean_rate;
	}

	public void setReview_clean_rate(int review_clean_rate) {
		this.review_clean_rate = review_clean_rate;
	}

	public int getReview_location_rate() {
		return review_location_rate;
	}

	public void setReview_location_rate(int review_location_rate) {
		this.review_location_rate = review_location_rate;
	}

	public int getReview_price_rate() {
		return review_price_rate;
	}

	public void setReview_price_rate(int review_price_rate) {
		this.review_price_rate = review_price_rate;
	}

	public int getReview_helpful_count() {
		return review_helpful_count;
	}

	public void setReview_helpful_count(int review_helpful_count) {
		this.review_helpful_count = review_helpful_count;
	}

	public int getReview_report_count() {
		return review_report_count;
	}

	public void setReview_report_count(int review_report_count) {
		this.review_report_count = review_report_count;
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


	
	
	public int getReservation_id() {
		return reservation_id;
	}



	public void setReservation_id(int reservation_id) {
		this.reservation_id = reservation_id;
	}



	@Override
	public String toString() {
		return "Review [review_id=" + review_id + ", review_content=" + review_content + ", review_date=" + review_date
				+ ", review_service_rate=" + review_service_rate + ", review_food_rate=" + review_food_rate
				+ ", review_clean_rate=" + review_clean_rate + ", review_location_rate=" + review_location_rate
				+ ", review_price_rate=" + review_price_rate + ", review_helpful_count=" + review_helpful_count
				+ ", review_report_count=" + review_report_count + ", hotel_id=" + hotel_id + ", reservation_id="
				+ reservation_id + ", user_id=" + user_id + "]";
	}


	
}
