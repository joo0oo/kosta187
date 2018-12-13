package kr.or.kosta.reservationmall.board.service;



import java.util.List;

import kr.or.kosta.reservationmall.board.dao.ArticleDao;
import kr.or.kosta.reservationmall.board.dao.BoardDao;
import kr.or.kosta.reservationmall.board.dto.Article;
import kr.or.kosta.reservationmall.board.dto.Board;
import kr.or.kosta.reservationmall.common.web.Params;


public class BoardServiceImpl implements BoardService {

	private BoardDao BoardDao;

	public BoardDao getBoardDao() {
		return BoardDao;
	}

	public void setBoardDao(BoardDao boardDao) {
		BoardDao = boardDao;
	}

	@Override
	public void create_hr(Board board) throws Exception {
		
	}

	@Override
	public Board read_hr(String id) throws Exception {
		return BoardDao.read_hr(id);
	}

	@Override
	public List<Board> listAll_hr() throws Exception {
		return BoardDao.listAll_hr();
	}


}
