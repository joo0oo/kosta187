package kr.or.kosta.reservationmall.board.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import kr.or.kosta.reservationmall.board.dto.Board;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 이혜림
 *
 */
public interface BoardService {
	
	public void create_hr(Board board) throws Exception;
	
	public Board read_hr(String id) throws Exception;
	
	public List<Board> listAll_hr() throws Exception;
	
}
