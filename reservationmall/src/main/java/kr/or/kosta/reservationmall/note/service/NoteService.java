package kr.or.kosta.reservationmall.note.service;

import java.util.List;

import kr.or.kosta.reservationmall.note.dto.Notes;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 이혜림
 */
public interface NoteService {
	/** 게시물 생성을 위한 CREATE메서드!!!  */	
	public void create_hr(Notes note) throws Exception;
	
	/** 게시물 ID로 게시물 정보 확인 가능 */	
	public Notes read_hr(String note_id) throws Exception;
	
	/** 게시물 정보 수정 */	
	public void update_hr(Notes note) throws Exception;
	
	/** 게시물 삭제 */	
	public void delete_hr(String note_id) throws Exception;
	
	/** 게시물 전체 리스트 */	
	public List<Notes> listAll_hr() throws Exception;

}
 