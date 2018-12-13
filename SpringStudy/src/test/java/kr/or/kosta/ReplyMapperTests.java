package kr.or.kosta;


import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.board.domain.ReplyVO;
import kr.or.kosta.spring.board.mapper.BoardMapper;
import kr.or.kosta.spring.board.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper bMapper;
	
//	@Test
	public void testMapper() {
		log.info(mapper);
	}
	
	
//	@Test
	public void testCreate() {
		IntStream.rangeClosed(1,10).forEach(i->{
			ReplyVO reply= new ReplyVO();
			
			if(bMapper.read(i+11L) != null) {
				reply.setBno(i+11L);
				reply.setReply("댓글 테스트"+i);
				reply.setReplyer("replyer"+i);
				mapper.insert(reply);
			}
		});
	}
	
//	@Test
	public void testRead() {
		IntStream.rangeClosed(1,10).forEach(i->{
			if(bMapper.read(i+15L) != null) {
				ReplyVO reply= mapper.read(i+15L);
				log.info(reply);
			}
		});
	}
	
	
//	@Test
	public void testDelete() {
		mapper.delete(16L);
	}
	
//	@Test
	public void testUpdate() {
		ReplyVO reply= mapper.read(10L);
		reply.setReply("수정된 댓글 내용");
		int count= mapper.update(reply);
		log.info("update count : "+count);
	}
	
	@Test
	public void testList() {
		Criteria cri= new Criteria();
		List<ReplyVO> replies= mapper.getListWithPaging(cri, 17L);
		replies.forEach(reply->log.info(reply));
	}
	
}
