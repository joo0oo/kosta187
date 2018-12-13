package kr.or.kosta.reservationmall.individual.dao;

import java.util.List;

import kr.or.kosta.reservationmall.individual.dto.Lastview;




/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 송주현
 *
 */
public interface LastviewDao {
	
	//최근 조회 항목 리턴
	public List<Lastview> getMyLastview(String user_id) throws Exception;
	
}
