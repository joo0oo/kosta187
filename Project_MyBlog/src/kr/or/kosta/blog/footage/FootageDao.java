package kr.or.kosta.blog.footage;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface FootageDao {
	//새 방명록 쓰기
	public void create(Footage footage) throws Exception;
	
	//사용자 id로 방명록 검색
	public Footage read(String id) throws Exception;
	
	//모든 방명록 리턴
	public List<Footage> listAll() throws Exception;
	
	//오늘의 게시글 개수 검색
	public int countTodayArticle() throws Exception;
}
