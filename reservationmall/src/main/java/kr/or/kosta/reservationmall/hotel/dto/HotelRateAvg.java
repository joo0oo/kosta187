package kr.or.kosta.reservationmall.hotel.dto;

public class HotelRateAvg {
	private float price_avg;
	private float service_avg;
	private float food_avg;
	private float clean_avg;
	private float location_avg;
	
	

	
	
	public HotelRateAvg() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HotelRateAvg(float price_avg, float service_avg, float food_avg, float clean_avg, float location_avg) {
		super();
		this.price_avg = price_avg;
		this.service_avg = service_avg;
		this.food_avg = food_avg;
		this.clean_avg = clean_avg;
		this.location_avg = location_avg;
	}
	
	public float getPrice_avg() {
		return price_avg;
	}
	public void setPrice_avg(float price_avg) {
		this.price_avg = price_avg;
	}
	
	public float getService_avg() {
		return service_avg;
	}
	
	public void setService_avg(float service_avg) {
		this.service_avg = service_avg;
	}
	
	public float getFood_avg() {
		return food_avg;
	}
	
	public void setFood_avg(float food_avg) {
		this.food_avg = food_avg;
	}
	
	public float getClean_avg() {
		return clean_avg;
	}
	
	public void setClean_avg(float clean_avg) {
		this.clean_avg = clean_avg;
	}
	
	public float getLocation_avg() {
		return location_avg;
	}
	
	public void setLocation_avg(float location_avg) {
		this.location_avg = location_avg;
	}
	
	
}
