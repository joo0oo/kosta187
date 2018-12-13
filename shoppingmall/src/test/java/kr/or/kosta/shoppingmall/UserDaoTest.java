package kr.or.kosta.shoppingmall;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.user.dao.MybatisUserDao;
import kr.or.kosta.shoppingmall.user.domain.User;

public class UserDaoTest {

	String resource = "mybatis-config.xml";
	private static final String NAMESPACE= "kr.or.kosta.shoppingmall.user.";
	SqlSessionFactory sqlSessionFactory;
	Reader reader;
	
	MybatisUserDao userDao;
	
	Logger logger= Logger.getLogger(UserDaoTest.class);
	
	@Before
	public void setUp() {
		try {
			reader= Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
		logger.debug("sql session factory 생성 완료 ");
		
		userDao = new MybatisUserDao();
		userDao.setSqlSessionFactory(sqlSessionFactory);
	}
	
	//@Test
	public void testListAll() {
		try {
			List<User> list =userDao.listAll();
			for (User user : list) {
				logger.debug(user);
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}

	}
	
	//@Test
	public void testRead() {
		try {
			User user= userDao.read("bangry");
			logger.debug(user);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}
	
	@Test
	public void testInsert() {
		User user= new User();
		user.setId("jess");
		user.setName("jessica");
		user.setPasswd("2222");
		user.setEmail("jess@gmail.com");
		try {
			userDao.create(user);
			
			//logger.debug(user);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}
	

}
