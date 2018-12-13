package kr.or.kosta.board.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.board.domain.ReplyPageDTO;
import kr.or.kosta.spring.board.domain.ReplyVO;
import kr.or.kosta.spring.board.service.ReplyService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller //Spring 의 Bean으로 인식하게 함
@RequestMapping("/replies/") // url중에서 '/board'로 시작하는 모든 처리 담당하게 함
@AllArgsConstructor // 이 클래스는 인자가 1개라서 BoardService가 자동으로 주입됨 
public class ReplyController {
	
	private ReplyService service;
	
	//댓글 새로 등록
	@PostMapping(value="/new", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO reply){
		log.info("reply : "+reply);
		int insertCount= service.register(reply);
		log.info("reply insert count  : "+insertCount);
		
		return insertCount ==1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//특정 게시글의 댓글 목록 조회
	@GetMapping(value="/pages/{bno}/{page}", 
			produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
//	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
	public ResponseEntity<ReplyPageDTO> getList(@PathVariable("page") int page, @PathVariable("bno") Long bno){
		log.info("getList.......................");
		Criteria cri= new Criteria(page,10);
		log.info("get Reply List from BNO : "+bno);
		log.info("cri : "+cri);
		
		return new ResponseEntity<>(service.getListPage(cri,bno),HttpStatus.OK);
	}
	
	//댓글 조회
	@GetMapping(value="/{rno}", produces= {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") Long rno){
		log.info("get reply : "+rno);
		return new ResponseEntity<>(service.get(rno),HttpStatus.OK);
	}
	
	//댓글 삭제
	@DeleteMapping(value="/{rno}", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		log.info("remove reply : "+rno);
		return service.remove(rno) ==1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	 
	//댓글 수정
	@RequestMapping(method= {RequestMethod.PUT, RequestMethod.PATCH}, 
					value="/{rno}", consumes="application/json", produces= {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> modify(@RequestBody ReplyVO reply, @PathVariable("rno") Long rno){
		reply.setRno(rno);
		log.info("modify rno: "+rno);
		log.info("modify reply: "+reply);
		return service.modify(reply) ==1 ? new ResponseEntity<>("success",HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
