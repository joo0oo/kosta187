package pattern2;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

	public static void main(String[] args) {

		UserDao dao= new OracleJdbcUserDao();
		
		User user= new User();
		user.setId("bangry");
		user.setName("김기정");
		user.setPasswd("1111");
		user.setEmail("bangry@naver.com");
		
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
