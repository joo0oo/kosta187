package kr.or.kosta.reservationmall.note.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.note.dto.Notes;


public class MybatisNoteDao implements NoteDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.note.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create_hr(Notes note) throws Exception {
		//쪽지 등록
		SqlSession sqlSession = sqlSessionFactory.openSession();
		if(sqlSession.insert(NAMESPACE + "create_hr",note) > 0) {
		sqlSession.commit();
		}
		sqlSession.close();
	}

	@Override
	public Notes read_hr(String note_id) throws Exception {
		//노트 읽기 - read 설정하기
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Notes note = sqlSession.selectOne(NAMESPACE+"read_hr",note_id);
		sqlSession.close();
		return note;
	}

	@Override
	public void update_hr(Notes note) throws Exception {
		//쪽지 정보 수정 및 답변 등록
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update(NAMESPACE+"update_hr",note);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void delete_hr(String note_id) throws Exception {
		//쪽지 삭제
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete(NAMESPACE+"delete_hr",note_id);
		sqlSession.close();
		}

	@Override
	public List<Notes> listAll_hr() throws Exception {
		//전체 쪽지 리스트 인출하기
		List<Notes> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		list = sqlSession.selectList(NAMESPACE + "listAll_hr");
		sqlSession.close();
		return list;
	}

}
