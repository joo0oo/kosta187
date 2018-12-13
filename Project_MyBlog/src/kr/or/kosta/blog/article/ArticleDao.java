package kr.or.kosta.blog.article;

import java.sql.Connection;
import java.util.List;
import java.util.Map;


/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface ArticleDao {
	
	//새 게시글 쓰기
	public void create(Article article) throws Exception;
	
	//답변글 쓰기
	public void createReply(int parent_group, Article article) throws Exception;
	
	//답변글에 대한 답변글 쓰기
	public void createSubReply(int parent_id, int parent_group, Article article) throws Exception;
	
	//답변글에 대한 답변글을 달기 위해 부모 글 순서 변경
	public void addParentOrderNum(int parent_id) throws Exception;
	
	//글제목 글내용 작성자로 글 검색
	public Article read(String searchStr) throws Exception;
	//글 고유번호로 글 검색
	public Article read(int article_id) throws Exception;
	
	//조회수 늘리기
	public void updateHitCount(int article_id) throws Exception;

	//게시글 수정하기
	public void update(Article article) throws Exception;
	
	//게시글 삭제하기
	public void delete(int article_id) throws Exception;
	
	//전체 게시글 목록 리턴
	public List<Article> listAll(int board_id) throws Exception;
	
	//답글 순서를 고려한 게시글 목록 리턴
	public List<Article> listAllforReply() throws Exception;
	
	//게시글 삭제를 위해 작성자 id와 비밀번호 일치 여부 확인하기
	public Article certify(int article_id, String passwd) throws Exception;
	
	
	/** 선택페이지에 따른 게시글 목록 반환 */	
	public List<Article> listByPage(int board_id, int page) throws Exception;
	
	/** 선택페이지, 조회 목록개수에 따른 게시글 목록 반환 */	
	public List<Article> listByPage(int board_id, int page, int listSize) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 게시글 목록 반환 */	
	public List<Article> listByPage(int board_id, int page, int listSize, String searchType, String searchValue) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 게시글 목록 반환 */	
	public List<Article> listByPage(int board_id, Params params) throws Exception;
	
	/** 검색유형, 검색값에 따른 게시글 개수 반환 - 페이징 처리 시 필요 */	
	public int countBySearch(int board_id, String searchType, String searchValue) throws Exception;
	
	public int countBySearch(int board_id, Params params) throws Exception;
	
	//오늘의 게시글 개수 검색
	public int countTodayArticle(int board_id) throws Exception;
	
}
