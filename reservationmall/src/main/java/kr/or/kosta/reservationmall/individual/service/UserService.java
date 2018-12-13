package kr.or.kosta.reservationmall.individual.service;

import kr.or.kosta.reservationmall.login.dto.User;

/**
 * 회원가입/ 정보 수정/ 회원 탈퇴
 * @author 송주현
 */
public interface UserService {
	
	/**회원 로그인**/
	//public Boolean checkLogin_hjh(String id, String pw) throws Exception;
	
	/** 회원 등록 **/
	public void createUser(User user) throws Exception;
	
	/** 회원 삭제 **/
	public void deleteUser(String user_id) throws Exception;
	
	/** 회원 수정 **/
	public void updateUser(User user) throws Exception;
	
	/** 아이디로 회원찾기 **/
	public User searchById(String id) throws Exception;
	
	/** 이메일로 회원 찾기 **/
	public User searchByEmail(String email) throws Exception;
}
