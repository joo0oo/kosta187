package kr.or.kosta.spring.board.service;

import java.util.List;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	public List<BoardVO> getList();
	
	//페이징 처리해서 리턴
	public List<BoardVO> getList(Criteria cri);
	
	//전체 글 갯수 리턴
	public int getTotalCount(Criteria cri);
}
