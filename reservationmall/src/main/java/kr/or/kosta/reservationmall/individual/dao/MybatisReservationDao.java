package kr.or.kosta.reservationmall.individual.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.individual.dto.ReservationInfo;




public class MybatisReservationDao implements ReservationDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.myreservation.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public ReservationInfo searchResById(String reservation_id) throws Exception {
		//예약번호로 예약 내역 리턴 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		ReservationInfo resInfo= sqlSession.selectOne(NAMESPACE+"searchResById",reservation_id);
		sqlSession.close();
		return resInfo;
	}

	@Override
	public List<ReservationInfo> listAllReservations(String user_id) throws Exception {
		//사용자 아이디로 전체 예약 내역 리턴
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ReservationInfo> list= sqlSession.selectList(NAMESPACE+"listAllReservations",user_id);
		sqlSession.close();
		System.out.println("hi" + list);
		return list;
	}

	@Override
	public boolean cacellationRes(int reservation_id) throws Exception {
		// 예약 번호로 예약 취소
		boolean res= false;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		if(sqlSession.update(NAMESPACE+"cancellationRes",reservation_id) >0) {
			sqlSession.commit();
			res=true;
		}
		sqlSession.close();
		return res;
	}

}










