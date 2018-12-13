package kr.or.kosta.spring.board.service;

import java.util.List;

import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.board.domain.ReplyPageDTO;
import kr.or.kosta.spring.board.domain.ReplyVO;

public interface ReplyService {
	
	public int register(ReplyVO reply);
	
	public ReplyVO get(Long rno);
	
	public int modify(ReplyVO reply);
	
	public int remove(Long rno);
	
	public List<ReplyVO> getList(Criteria cri, Long bno);
	
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
