package kr.or.kosta.reservationmall.board.dao;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.board.dto.Article;
import kr.or.kosta.reservationmall.common.web.Params;
/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 이혜림
 */
public interface ArticleDao {
	/** 게시물 생성을 위한 CREATE메서드  */	
	public void create_hr(Article article) throws Exception;
	
	/** 게시물 ID로 게시물 정보 확인 가능 */	
	public Article read_hr(String id) throws Exception;
	
	/** 게시물 정보 수정 */	
	public void update_hr(Article article) throws Exception;
	
	/** 게시물 삭제 */	
	public void delete_hr(String id) throws Exception;
	
	/** 게시물 전체 리스트 */	
	public List<Article> listAll_hr() throws Exception;
	
	/** 선택페이지에 따른 사용자 목록 반환 */	
	public List<Article> listByPage_hr(int page) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<Article> listByPage_hr(int page, int listSize, String searchType, String searchValue) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<Article> listByPage_hr(Params params) throws Exception;
	
	/** 검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요 */	
	public int countBySearch_hr(String searchType, String searchValue) throws Exception;

	public int countBySearch_hr(Params params) throws Exception;

	/** count 세기 */
	public abstract void increaseHitCount_hr(String id) throws Exception;
	
	

}
 