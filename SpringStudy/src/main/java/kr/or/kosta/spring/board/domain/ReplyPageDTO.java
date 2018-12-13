package kr.or.kosta.spring.board.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
@Getter
public class ReplyPageDTO {

	private int replyCnt; //전체 댓글수
	private List<ReplyVO> list; //전체 댓글 목록
}
