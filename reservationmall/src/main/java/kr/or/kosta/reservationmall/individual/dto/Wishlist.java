package kr.or.kosta.reservationmall.individual.dto;

public class Wishlist {
	private int wishlist_id;
	private int hotel_id;
	private String user_id;
	
	public Wishlist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Wishlist(int wishlist_id, int hotel_id, String user_id) {
		super();
		this.wishlist_id = wishlist_id;
		this.hotel_id = hotel_id;
		this.user_id = user_id;
	}

	public int getWishlist_id() {
		return wishlist_id;
	}

	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
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

	
}
