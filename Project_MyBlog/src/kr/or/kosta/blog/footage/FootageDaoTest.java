package kr.or.kosta.blog.footage;

import java.sql.SQLException;
import java.util.List;

import kr.or.kosta.blog.dao.DaoFactory;
import kr.or.kosta.blog.dao.JdbcDaoFactory;

public class FootageDaoTest {

	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory();
		FootageDao dao = factory.getFootageDao();
		try {
			
			System.out.println("**** 전체목록 테스트 ****");
			List<Footage> list =  dao.listAll();
			for (Footage footage : list) {
				System.out.println(footage);				
			}
			
			System.out.println(dao.read("bangry"));
			
			Footage f1=new Footage();
			dao.create(f1);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}

	}

}
