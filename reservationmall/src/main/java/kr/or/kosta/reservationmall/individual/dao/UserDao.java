package kr.or.kosta.reservationmall.individual.dao;

import java.util.List;

import kr.or.kosta.reservationmall.login.dto.User;




/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface UserDao {
	
	public void create(User user) throws Exception; //회원가입
	
//	public User read(String id) throws Exception; //아이디로 회원 찾기
	
	public void update(User user) throws Exception; //회원 정보 업데이트 
	
	public void delete(String id) throws Exception; //회원 삭제
	
	public User searchById(String id) throws Exception; //아이디로 회원 찾기
	
	public User searchByEmail(String email) throws Exception; //이메일로 회원 찾기
	
//	public List<User> listAll() throws Exception; //회원 전체 조회
	
	
	/** 선택페이지에 따른 사용자 목록 반환 */	
//	public List<User> listByPage(int page) throws Exception;
	
	/** 선택페이지, 조회 목록개수에 따른 사용자 목록 반환 */	
//	public List<User> listByPage(int page, int listSize) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
//	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
//	public List<User> listByPage(Params params) throws Exception;
	
	/** 검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요 */	
//	public int countBySearch(String searchType, String searchValue) throws Exception;
	
//	public int countBySearch(Params params) throws Exception;
	
}
