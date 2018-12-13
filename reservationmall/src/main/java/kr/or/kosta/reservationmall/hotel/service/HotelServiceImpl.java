package kr.or.kosta.reservationmall.hotel.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

import kr.or.kosta.reservationmall.hotel.dao.HotelDao;
import kr.or.kosta.reservationmall.hotel.dto.HotelInfo;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchParam;
import kr.or.kosta.reservationmall.hotel.dto.HotelSearchResult;
import kr.or.kosta.reservationmall.hotel.dto.Review;
import kr.or.kosta.reservationmall.individual.dao.ReviewDao;
import kr.or.kosta.reservationmall.room.dto.Room;

public class HotelServiceImpl implements HotelService {

	private HotelDao hotelDao;
	private ReviewDao reviewDao;

	public HotelDao getHotelDao() {
		return hotelDao;
	}

	public void setHotelDao(HotelDao hotelDao) {
		this.hotelDao = hotelDao;
	}

	public ReviewDao getReviewDao() {
		return reviewDao;
	}

	public void setReviewDao(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	@Override
	public List<HotelSearchResult> searchHotelListsByLocation(HotelSearchParam hotelSearchParam) throws Exception {
		return hotelDao.searchHotelListsByLocation(hotelSearchParam);
	}

	@Override
	public List<HotelSearchResult> searchHotelListsByHotel(HotelSearchParam hotelSearchParam) throws Exception {
		return hotelDao.searchHotelListsByHotel(hotelSearchParam);
	}

	@Override
	public Room getRoomInfo(String hotelId, String roomName) throws Exception {
		return hotelDao.getRoomInfo(hotelId, roomName);
	}

	@Override
	public Map<String, List<String>> getHotelImages(String hotelIds) throws Exception {
		List<Map<String, String>> result = hotelDao.getHotelImages(hotelIds);
		Map<String, List<String>> images = new HashMap<>();
		String hotelId = null;
		for (Map<String, String> map : result) {
			hotelId = String.valueOf(map.get("hotelId"));
			if (!images.containsKey(hotelId)) {
				images.put(hotelId, new ArrayList<>());
			}
			images.get(hotelId).add(map.get("imageDirectory"));
		}
		return images;
	}

	@Override
	public List<String> getRoomImages(int hotelId, String roomName) throws Exception {
		return hotelDao.getRoomImages(hotelId, roomName);
	}

	public List<HotelInfo> getHotelInfos(Map<String, Object> paramMap, String userId) throws Exception {
		List<List<HotelSearchResult>> searchResult = new ArrayList<>();
		HotelSearchParam hotelSearchParam = null;
		for (int i = 1; i <= Integer.parseInt((String) paramMap.get("RoomNumber")); i++) {
			hotelSearchParam = new HotelSearchParam();
			addParameterValue(hotelSearchParam, paramMap, i);
			if (hotelSearchParam.getValueType().equals("searchLocation")) {
				try {
					searchResult.add(hotelDao.searchHotelListsByLocation(hotelSearchParam));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (hotelSearchParam.getValueType().equals("searchHotel")) {
				try {
					searchResult.add(hotelDao.searchHotelListsByHotel(hotelSearchParam));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Set<Integer> hotelIdSetTemp = null;
		Set<Integer> hotelIdSet = new HashSet<>();
		for (HotelSearchResult hotelSearchResult : searchResult.get(0)) {
			hotelIdSet.add(hotelSearchResult.getHotelId());
		}
		for (int i = 1; i < searchResult.size(); i++) {
			hotelIdSetTemp = new HashSet<>();
			for (HotelSearchResult hotelSearchResult : searchResult.get(i)) {
				hotelIdSetTemp.add(hotelSearchResult.getHotelId());
			}
			hotelIdSet = Sets.intersection(hotelIdSet, hotelIdSetTemp);
		}
		List<HotelInfo> hotelInfos = new ArrayList<>();
		HotelInfo info = null;
		List<Review> reviews = null;
		List<String> reviewIds = new ArrayList<>();
		String reviewIdTemp = null;
		for (int hotelId : hotelIdSet) {
			info = new HotelInfo();
			reviewIdTemp = "";
			info.setHotelId(hotelId);
			for (int i = 0; i < searchResult.size(); i++) {
				for (HotelSearchResult hotelSearchResult : searchResult.get(i)) {
					if (hotelSearchResult.getHotelId() == hotelId) {
						info.setCleanRate(hotelSearchResult.getCleanRate());
						info.setFoodRate(hotelSearchResult.getFoodRate());
						info.setLocationRate(hotelSearchResult.getLocationRate());
						info.setPriceRate(hotelSearchResult.getPriceRate());
						info.setServiceRate(hotelSearchResult.getServiceRate());
						try {
							if (!info.isExistRoom(i + 1, hotelSearchResult.getRoomName())) {
								info.addRooms(i + 1,
										new Room(hotelSearchResult.getRoomName(), hotelSearchResult.getStandardNumber(),
												hotelSearchResult.getChildMaxNumber(), hotelSearchResult.getRoomInfo(),
												hotelSearchResult.getPrice(), hotelSearchResult.getRoomDetail(),
												hotelDao.getRoomImages(hotelId, hotelSearchResult.getRoomName())));
							}
							reviews = reviewDao.getReviewsByHotelId(String.valueOf(hotelId));
							if (userId != null) {
								for (Review review : reviews) {
									reviewIdTemp += "," + review.getReviewId();
								}
							}
							info.setReviews(reviews);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
			if (info.getRooms().size() > 0) {
				hotelInfos.add(info);
			}
			reviewIds.add(reviewIdTemp);
		}

		List<String> isReviewLikes = null;
		List<String> isReviewHates = null;
		HotelInfo hotelInfo = null;
		String reviewId = null;
		if (userId != null) {
			for (int i = 0; i < hotelInfos.size(); i++) {
				reviewId = reviewIds.get(i).substring(1);
				isReviewLikes = reviewDao.isReviewLiked(reviewId, userId);
				isReviewHates = reviewDao.isReviewHated(reviewId, userId);
				hotelInfo = hotelInfos.get(i);
				for (Review review : hotelInfo.getReviews()) {
					if (isReviewLikes.contains(review.getReviewId())) {
						review.setIsLiked(true);
					}
					if (isReviewHates.contains(review.getReviewId())) {
						review.setIsHated(true);
					}
				}
			}
		}
		return hotelInfos;
	}

	private void addParameterValue(Object bean, Map<String, Object> paramMap, int roomNumber) {
		Class cls = bean.getClass();
		Method method = null;
		Method[] methods = bean.getClass().getDeclaredMethods();
		Set<String> set = paramMap.keySet();
		for (Method method2 : methods) {
			String[] temp = method2.getName().split("\\.");
			for (String key : set) {
				String keyTemp = key;
				if (key.substring(key.length() - 1).equals(String.valueOf(roomNumber))) {
					keyTemp = key.substring(0, key.length() - 1);
				}
				if (temp[temp.length - 1].equals("set" + keyTemp)) {
					method = method2;
					if (paramMap.get(key) instanceof String[]) {
						String[] values = (String[]) paramMap.get(key);
						for (String value : values) {
							try {
								method.invoke(bean, value);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					} else if (paramMap.get(key) instanceof String) {
						String value = (String) paramMap.get(key);
						try {
							method.invoke(bean, value);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					break;
				}
			}
		}
	}
	
}
