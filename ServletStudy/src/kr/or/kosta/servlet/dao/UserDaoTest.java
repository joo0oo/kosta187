package kr.or.kosta.servlet.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserDaoTest {

	private static final String driver="oracle.jdbc.OracleDriver";
	private static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String userName="hr";
	private static final String passWd="hr";
	
	public static void main(String[] args) {

		JdbcUserDao dao= new JdbcUserDao();
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(passWd);
		dataSource.setInitialSize(5);
		dataSource.setMaxTotal(10);
		dataSource.setMaxIdle(7);
		
		dao.setDataSource(dataSource);
		
		/*
		User user= new User();
		user.setId("bangry");
		user.setName("김기정");
		user.setPasswd("1111");
		user.setEmail("bangry@naver.com");
		*/
		
		// create()
		/*
		try {
			dao.create(user);
			System.out.println("회원가입 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
		*/
		
		// read()
		/*
		try {
			User res= dao.read("bangry");
			if(res == null) {
				System.out.println("존재하지 않는 사용자");
			} else {
				System.out.println(res.toString());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}
		*/
		
		// update()
		/*
		user.setName("김기정정");
		user.setPasswd("1111111");
		user.setEmail("bangryyyyy@naver.com");
		try {
			dao.update(user);
			System.out.println(dao.read(user.getId()).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		// delete()
		/*
		try {
			dao.delete("bbbb");
			System.out.println("bbbb"+"삭제 완료");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		// listAll()
		List<User> list= new ArrayList<User>();
		try {
			
			list=dao.listAll();
			for (User user2 : list) {
				System.out.println(user2);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//certify()
		/*
		try {
			System.out.println(dao.certify("namgry", "2222"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		// employeeList()
		/*
		List<Map<String, String>> elist= new ArrayList<Map<String, String>>();
		try {
			elist= dao.employeeList();
			for (Map<String, String> map : elist) {
				System.out.println(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
	}

}
