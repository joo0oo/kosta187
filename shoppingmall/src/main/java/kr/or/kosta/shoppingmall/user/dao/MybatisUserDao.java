package kr.or.kosta.shoppingmall.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.shoppingmall.common.web.Params;
import kr.or.kosta.shoppingmall.user.domain.User;

public class MybatisUserDao implements UserDao {
	
	SqlSessionFactory sqlSessionFactory;
	private static final String NAMESPACE= "kr.or.kosta.shoppingmall.user.";

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(User user) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		sqlSession.insert(NAMESPACE+"create", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public User read(String id) throws Exception {
		User user = null;
		
		SqlSession sqlSession= sqlSessionFactory.openSession();
		user = sqlSession.selectOne(NAMESPACE+"read",id);
		sqlSession.close();
		
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		sqlSession.update(NAMESPACE+"update", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void delete(String id) throws Exception {
		SqlSession sqlSession= sqlSessionFactory.openSession();
		sqlSession.delete(NAMESPACE+"update", id);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> list = null;
		
		SqlSession sqlSession= sqlSessionFactory.openSession();
		list = sqlSession.selectList(NAMESPACE+"listAll");
		sqlSession.close();
		
		return list;
	}
	

	@Override
	public User certify(String id, String passwd) throws Exception {
		User user = null;
		Map<String, String> params = new HashMap<>();
		params.put("id", id);
		params.put("passwd", passwd);
		
		SqlSession sqlSession= sqlSessionFactory.openSession();
		user = sqlSession.selectOne(NAMESPACE+"certify", params);
		sqlSession.close();
		
		return user;
	}
	
	

	@Override
	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {
		List<User> list = null;
		
		Map<String, String> params = new HashMap<>();
		params.put("searchType", searchType);
		params.put("searchValue", searchValue);
		params.put("listSize", listSize+"");
		params.put("requestPage", page+"");
		SqlSession sqlSession= sqlSessionFactory.openSession();
		list = sqlSession.selectList(NAMESPACE+"listByPage", params);
		sqlSession.close();
		
		return list;
	}

	@Override
	public List<User> listByPage(Params params) throws Exception {
		return listByPage(params.getPage(), params.getListSize(),  params.getSearchType(), params.getSearchValue());
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {
		int count = 0;
		
		Map<String, String> params = new HashMap<>();
		params.put("searchType", searchType);
		params.put("searchValue", searchValue);
		
		SqlSession sqlSession= sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList(NAMESPACE+"countBySearch", params);
		count=list.size();
		sqlSession.close();
		return count;
	
	}

	@Override
	public int countBySearch(Params params) throws Exception {
		return countBySearch(params.getSearchType(), params.getSearchValue());
	}
	
	
	
}










