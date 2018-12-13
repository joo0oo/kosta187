package kr.or.kosta.reservationmall.hotel.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.room.dto.Room;

public class HotelInfo {
	private int hotelId;
	private String priceRate;
	private String foodRate;
	private String serviceRate;
	private String cleanRate;
	private String locationRate;
	private Map<Integer, List<Room>> rooms;
	private List<Review> reviews;

	public HotelInfo() {
		rooms = new HashMap<>();
		reviews = new ArrayList<>();
	}

	public HotelInfo(int hotelId, String priceRate, String foodRate, String serviceRate, String cleanRate,
			String locationRate, Map<Integer, List<Room>> rooms, List<Review> reviews) {
		super();
		this.hotelId = hotelId;
		this.priceRate = priceRate;
		this.foodRate = foodRate;
		this.serviceRate = serviceRate;
		this.cleanRate = cleanRate;
		this.locationRate = locationRate;
		this.rooms = rooms;
		this.reviews = reviews;
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

	public Map<Integer, List<Room>> getRooms() {
		return rooms;
	}

	public void setRooms(Map<Integer, List<Room>> rooms) {
		this.rooms = rooms;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addRooms(int roomNumber, Room room) {
		if (!rooms.containsKey(roomNumber)) {
			rooms.put(roomNumber, new ArrayList<>());
		}
		if (!rooms.get(roomNumber).contains(room)) {
			rooms.get(roomNumber).add(room);
		}
	}

	public boolean isExistRoom(int roomNumber, String roomName) {
		if (rooms.containsKey(roomNumber)) {
			for (Room room : rooms.get(roomNumber)) {
				if (room.getName().equals(roomName)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "HotelInfo [hotelId=" + hotelId + ", priceRate=" + priceRate + ", foodRate=" + foodRate
				+ ", serviceRate=" + serviceRate + ", cleanRate=" + cleanRate + ", locationRate=" + locationRate
				+ ", rooms=" + rooms + ", reviews=" + reviews + "]";
	}

}
