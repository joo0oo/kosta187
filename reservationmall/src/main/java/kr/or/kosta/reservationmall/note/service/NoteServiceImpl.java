package kr.or.kosta.reservationmall.note.service;

import java.util.List;

import kr.or.kosta.reservationmall.note.dao.NoteDao;
import kr.or.kosta.reservationmall.note.dto.Notes;


public class NoteServiceImpl implements NoteService {

	private NoteDao noteDao;

	public NoteDao getNoteDao() {
		return noteDao;
	}

	public void setNoteDao(NoteDao noteDao) {
		this.noteDao = noteDao;
	}
	@Override
	public void create_hr(Notes note) throws Exception {
		//쪽지 등록
		noteDao.create_hr(note);
	}

	@Override
	public Notes read_hr(String note_id) throws Exception {
		//쪽지 읽기
		return noteDao.read_hr(note_id);
	}

	@Override
	public void update_hr(Notes note) throws Exception {
		//쪽지 수정하기 
		noteDao.update_hr(note);
		
	}
	@Override
	public void delete_hr(String note_id) throws Exception {
		//쪽지 삭제하기
		noteDao.delete_hr(note_id);
	}
	@Override
	public List<Notes> listAll_hr() throws Exception {
		return noteDao.listAll_hr();
	}
}
