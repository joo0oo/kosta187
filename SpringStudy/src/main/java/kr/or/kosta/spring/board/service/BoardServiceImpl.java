package kr.or.kosta.spring.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.board.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {

	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		board.setContent(board.getContent().trim());
		log.info("register..."+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..."+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify..."+board);
		if(get(board.getBno()) == null) {
			return false;
		}else {
			board.setContent(board.getContent().trim());
			if(mapper.update(board) ==1) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..."+bno);
		if(get(bno) == null) {
			return false;
		}
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList....");
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList....");
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		log.info("get total count..");
		return mapper.getTotalCount(cri);
	}

}
