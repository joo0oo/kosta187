package kr.or.kosta.reservationmall.login.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.common.web.Params;

public class MybatisLoginDao implements LoginDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.login.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public boolean checkLogin_hjh(String id, String passwd) throws Exception {
		int user_pw= 0;

		SqlSession sqlSession = sqlSessionFactory.openSession();
		if(sqlSession.selectOne(NAMESPACE+"checkLoginHjh",id) == null) {
			sqlSession.close();
			return false;
		}
		user_pw = sqlSession.selectOne(NAMESPACE+"checkLoginHjh",id);
		sqlSession.close();
		return (user_pw==Integer.parseInt(passwd))?true:false;
	}

	@Override
	public boolean isWithdrawal_sjh(String id) throws Exception {
		int user_rate=0;
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		if(sqlSession.selectOne(NAMESPACE+"checkWithdrawal",id) != null) {
			user_rate=sqlSession.selectOne(NAMESPACE+"checkWithdrawal",id);
			if(user_rate == -9) {
				return true;
			}
		}
		sqlSession.close();
		return false;
	}
}










