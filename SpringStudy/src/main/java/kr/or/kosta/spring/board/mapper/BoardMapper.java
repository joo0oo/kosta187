package kr.or.kosta.spring.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;

public interface BoardMapper {

	//@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();

	//페이징 처리해서 게시글 목록 리턴
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);
	
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
	
	//전체 글 갯수 리턴
	public int getTotalCount(Criteria cri);
	
	//이 게시글의 총 댓글수 갱신
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
