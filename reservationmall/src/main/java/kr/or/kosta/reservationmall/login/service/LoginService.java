package kr.or.kosta.reservationmall.login.service;



import java.util.List;


/**
 * 로그인 관련 처리 
 * 로그인, 회원가입 등
 * @author 허재혁
 */
public interface LoginService {
	
	/**회워 로그인**/
	public Boolean checkLogin_hjh(String id, String pw) throws Exception;
	
	//탈퇴회원 검사
	public Boolean isWithdrawal_sjh(String id) throws Exception;
	


}
