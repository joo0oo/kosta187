package kr.or.kosta.shoppingmall.user.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.kosta.shoppingmall.common.dao.DaoFactory;
import kr.or.kosta.shoppingmall.common.dao.JdbcDaoFactory_pre;
import kr.or.kosta.shoppingmall.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory_pre();
		UserDao dao = factory.getUserDao();
		try {
			
			System.out.println("**** 전체목록 테스트 ****");
			List<User> list =  dao.listAll();
//			List<User> list =  dao.listByPage(2);
//			List<User> list =  dao.listByPage(1, 15);
//			List<User> list =  dao.listByPage(1, 15, null, null);
//			List<User> list =  dao.listByPage(1, 15, "name", "김");
//			List<User> list =  dao.listByPage(new Params(1, 15, "name", "김"));
			for (User user : list) {
				System.out.println(user);				
			}
			
//			int count = dao.countBySearch(null);
//			int count = dao.countBySearch("name", "김");
//			System.out.println("검색수: " + count);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
		
		
		

	}

}
