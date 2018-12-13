package kr.or.kosta.reservationmall.individual.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.reservationmall.individual.dto.Lastview;
import kr.or.kosta.reservationmall.individual.dto.Wishlist;



public class MybatisLastviewDao implements LastviewDao {
	
	private static final String NAMESPACE = "kr.or.kosta.reservationmall.mylastview.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Lastview> getMyLastview(String user_id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Lastview> list= new ArrayList<>();
		list=sqlSession.selectList(NAMESPACE+"getMyLastview",user_id);
		//System.out.println("        * "+list);
		if(list != null) {
			sqlSession.close();
			return list;
		}
		sqlSession.close();
		return null;
	}

}










