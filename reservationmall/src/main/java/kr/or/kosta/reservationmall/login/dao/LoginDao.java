package kr.or.kosta.reservationmall.login.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.common.web.Params;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface LoginDao {
	
	public boolean checkLogin_hjh(String id, String passwd) throws Exception;
	
	public boolean isWithdrawal_sjh(String id) throws Exception;
	
	
}
