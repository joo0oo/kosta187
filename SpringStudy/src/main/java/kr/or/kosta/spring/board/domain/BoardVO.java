package kr.or.kosta.spring.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVO {

	private Long bno;
	private String title;
	private String content;
	private String writer;
	private String regdate;
	private String updateDate;
	
	private int replyCnt; //이 게시글의 총 댓글 수 
}
