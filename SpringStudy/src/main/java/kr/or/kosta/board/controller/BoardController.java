package kr.or.kosta.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;
import kr.or.kosta.spring.board.domain.PageDTO;
import kr.or.kosta.spring.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller //Spring 의 Bean으로 인식하게 함
@RequestMapping("/board/*") // url중에서 '/board'로 시작하는 모든 처리 담당하게 함
@AllArgsConstructor // 이 클래스는 인자가 1개라서 BoardService가 자동으로 주입됨 
public class BoardController {
	
	private BoardService service;
	
/*
	@GetMapping("/list") //get방식으로 들어오는 url 매핑
	public void list(Model model) {
		log.info("list");
		model.addAttribute("list",service.getList()); //게시글 전체 목록을 전달하기 위해 model에 저장
	}
*/
	
	@GetMapping("/list") //페이징 처리한 리스트
	public void list(Model model, Criteria cri) {
		log.info("list with paging: "+cri);
		model.addAttribute("list",service.getList(cri)); //게시글 전체 목록을 전달하기 위해 model에 저장
		
		int total= service.getTotalCount(cri);
		log.info("total : "+total);
		model.addAttribute("pageMarker",new PageDTO(cri,total));
	}
	
	@GetMapping("/register") //get으로 들어오는 register 요청에 대해 처리
	public void regist() {
		log.info("register page called");
		//입력페이지 보여주기만 하는 역할 (처리 필요x)
	}
	
	@PostMapping("/register") //post 방식으로 들어오는 register에 대한 url 매핑
	public String register(BoardVO board, RedirectAttributes rttr) {
		//실제 게시글 작성 역할
		log.info("register activated : "+board);
		service.register(board);
		rttr.addFlashAttribute("result",board.getBno()); // 새로 작성된 게시글 번호 저장
		//flashAttribute : 단 1번만 읽을수 있는 데이터
		
		return "redirect:/board/list"; //등록후 목록화면으로 이동
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model ) {
		
		log.info("/get or /modify");
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : "+board);
		
		if(service.modify(board)) {
			log.info(" modify success ! ");
			rttr.addFlashAttribute("result","success");
		}
		
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove.."+bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		rttr.addAttribute("pageNum",cri.getPageNum());
		rttr.addAttribute("amount",cri.getAmount());
		rttr.addAttribute("type",cri.getType());
		rttr.addAttribute("keyword",cri.getKeyword());
		
		return "redirect:/board/list";
	}
	
}
