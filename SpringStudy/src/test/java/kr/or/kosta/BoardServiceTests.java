package kr.or.kosta;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.board.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTests {

	@Setter(onMethod_ = {@Autowired})
	private BoardService service;
	
//	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
//	@Test
	public void testRegister() {
		BoardVO board=new BoardVO();
		board.setTitle("새로 작성하는 글~");
		board.setContent("새 작성 내용~");
		board.setWriter("heyrim");
		
		service.register(board);
		
		log.info("생성된 게시글 번호 : "+board.getBno());
	}
	
//	@Test
	public void testGetList() {
		service.getList().forEach(board->log.info(board));
	}
	
//	@Test
	public void testRead() {
		log.info(service.get(1L));
	}
	
//	@Test
	public void testDelete() {
		log.info("remove result : "+service.remove(15L));
	}
	
//	@Test
	public void testUpdate() {
		BoardVO board= service.get(16L);
		if(board== null) {
			return;
		}
		
		board.setTitle("제목 수정~");
		log.info("update result : "+service.modify(board));
	}
	
	@Test
	public void testGetPagingList() {
		Criteria cri= new Criteria();
		cri.setAmount(10);
		cri.setPageNum(2);
		service.getList(cri).forEach(board->log.info(board));
	}
}
