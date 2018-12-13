package kr.or.kosta.reservationmall.individual.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.login.dto.User;



public class MybatisUserDao implements UserDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.individual.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}


	@Override
	public void create(User user) throws Exception {
		// 회원 등록
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int res = 0;
		try {
			res = sqlSession.insert(NAMESPACE+"createUser",user);
		} catch (Exception e) {
			e.getStackTrace();
		}
		if (res >0) {
			sqlSession.commit();
		}
		sqlSession.close();
	}

	@Override
	public void update(User user) throws Exception {
		// 회원 정보 수정 
		SqlSession sqlSession = sqlSessionFactory.openSession();
		if(sqlSession.update(NAMESPACE+"updateUser",user) >0) {
			sqlSession.commit();
		}
		sqlSession.close();
	}

	@Override
	public void delete(String id) throws Exception {
		// 회원 탈퇴
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//sqlSession.delete(NAMESPACE+"deleteUser",id);
		if(sqlSession.update(NAMESPACE+"setWithdrawal",id)>0) {
			sqlSession.commit();
		}
		sqlSession.close();
	}

	@Override
	public User searchById(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user= sqlSession.selectOne(NAMESPACE+"searchById", id);
		sqlSession.close();
		return user;
	}

	@Override
	public User searchByEmail(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user= sqlSession.selectOne(NAMESPACE+"searchByEmail", email);
		sqlSession.close();
		return user;
	}
	
	
}










