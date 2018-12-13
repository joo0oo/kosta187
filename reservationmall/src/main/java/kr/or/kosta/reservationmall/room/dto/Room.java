package kr.or.kosta.reservationmall.room.dto;

import java.util.Arrays;
import java.util.List;

public class Room {

	private String name;
	private String standardNumber;
	private String childMaxNumber;
	private String info;
	private String price;
	private String[] detail;
	private List<String> images;

	public Room() {
	}

	public Room(String name, String standardNumber, String childMaxNumber, String info, String price,
			String detail, List<String> images) {
		super();
		this.name = name;
		this.standardNumber = standardNumber;
		this.childMaxNumber = childMaxNumber;
		this.info = info;
		this.price = price;
		this.detail = detail.split("<\\?!>");
		this.images = images;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail.split("<\\?!>");
	}
	
	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public void setDetail(String[] detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return "Room [name=" + name + ", standardNumber=" + standardNumber + ", childMaxNumber=" + childMaxNumber
				+ ", info=" + info + ", price=" + price + ", detail=" + Arrays.toString(detail) + ", images=" + images
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Room) {
			return name.equals(((Room)obj).getName());
		} else {
			return name.equals(obj);
		}
	}
	
}
