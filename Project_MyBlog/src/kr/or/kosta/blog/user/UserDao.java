package kr.or.kosta.blog.user;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface UserDao {
	
	/* 새 사용자 등록 */
	public void create(User user) throws Exception;
	
	/* 아이디로 사용자 검색 */
	public User read(String id) throws Exception;
	
	/* 사용자 정보 업데이트 */
	public void update(User user) throws Exception;
	
	/* 사용자 정보 삭제 */
	public void delete(String id) throws Exception;
	
	/* 전체 사용자 목록 조회 */
	public List<User> listAll() throws Exception;
	
	/* 로그인을 위해 id와 비밀번호로 사용자 정보 검색 */
	public User certify(String id, String passwd) throws Exception;
	
	/* 아이디 찾기 기능을 위해 이름과 이메일로 사용자 정보 검색 */
	public User findID(String name, String email) throws Exception;
	
	/* 이메일 유효성 검사 */
	public User isValidEmail(String email) throws Exception;
	
}
