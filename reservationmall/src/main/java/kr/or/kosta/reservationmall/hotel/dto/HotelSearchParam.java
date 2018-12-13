package kr.or.kosta.reservationmall.hotel.dto;

public class HotelSearchParam {
	private String valueType;
	private String value;
	private String startDay;
	private String endDay;
	private String adultNumber;
	private String childNumber;
	private String minMoney;
	private String maxMoney;
	private String rateType;
	private String hotelRate;
	
	public HotelSearchParam() {
	}

	public HotelSearchParam(String valueType, String value, String startDay, String endDay, String adultNumber,
			String childNumber, String minMoney, String maxMoney, String rateType, String hotelRate) {
		super();
		this.valueType = valueType;
		this.value = value;
		this.startDay = startDay;
		this.endDay = endDay;
		this.adultNumber = adultNumber;
		this.childNumber = childNumber;
		this.minMoney = minMoney;
		this.maxMoney = maxMoney;
		this.rateType = rateType;
		this.hotelRate = hotelRate;
	}

	public String getValueType() {
		return valueType;
	}

	public void setValueType(String valueType) {
		this.valueType = valueType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getAdultNumber() {
		return adultNumber;
	}

	public void setAdultNumber(String adultNumber) {
		this.adultNumber = adultNumber;
	}

	public String getChildNumber() {
		return childNumber;
	}

	public void setChildNumber(String childNumber) {
		this.childNumber = childNumber;
	}

	public String getMinMoney() {
		return minMoney;
	}

	public void setMinMoney(String minMoney) {
		this.minMoney = minMoney;
	}

	public String getMaxMoney() {
		return maxMoney;
	}

	public void setMaxMoney(String maxMoney) {
		this.maxMoney = maxMoney;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getHotelRate() {
		return hotelRate;
	}

	public void setHotelRate(String hotelRate) {
		this.hotelRate = hotelRate;
	}

	@Override
	public String toString() {
		return "HotelSearchParam [valueType=" + valueType + ", value=" + value + ", startDay=" + startDay + ", endDay="
				+ endDay + ", adultNumber=" + adultNumber + ", childNumber=" + childNumber + ", minMoney=" + minMoney
				+ ", maxMoney=" + maxMoney + ", rateType=" + rateType + ", hotelRate=" + hotelRate + "]";
	}

}
