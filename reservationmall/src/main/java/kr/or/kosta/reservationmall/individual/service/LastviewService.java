package kr.or.kosta.reservationmall.individual.service;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.Lastview;

/**
 * 최근 본 항목 
 * @author 송주현
 */
public interface LastviewService {

	/**
	 * 해당 유저의 최근 본 항목 리턴 
	 * @param user_id
	 * @return Lastview :List
	 * @throws Exception
	 */
	public List<Lastview> getMyLastview(String user_id) throws Exception;

}
