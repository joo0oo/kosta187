package kr.or.kosta.shoppingmall.common.dao;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import java.lang.reflect.Method;

import javax.sql.DataSource;


/**
 * Factory 패턴 적용 ControllerFactory
 * 
 * @author 김기정
 */
public class JdbcDaoFactory extends DaoFactory{
	private Hashtable<String, Object> daos;

	public JdbcDaoFactory(String daoMapperLocation) {
	      daos = new Hashtable<String, Object>();

	      Properties prop = new Properties();
	      FileInputStream fis = null;
	      try {
	         fis = new FileInputStream(daoMapperLocation);
	         prop.load(fis);
	         Iterator keyIter = prop.keySet().iterator();
	         while (keyIter.hasNext()) {
	            String daoName = (String) keyIter.next();
	            String daoClassName = prop.getProperty(daoName);
	            Object dao = Class.forName(daoClassName).newInstance();
	            addDataSource(dao);
	            daos.put(daoClassName, dao);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	private void addDataSource(Object dao) {
		Class cls = dao.getClass();
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object getDao(String daoName) {
		return daos.get(daoName);
	}

	@Override
	public Object getDao(Class cls) {
		return daos.get(cls.getName());
	}


//	// 요청에 대한 세부 컨트롤러 클래스 생성 및 관리
//	private String daoMapperLocation;
//	private HashMap<String, Object> daos;
//
//	public JdbcDaoFactory1(String daoMapperLocation) {
//		daos = new HashMap<String, Object>();
//
//		// 매핑정보를 저장할 Properties 객체 생성u
//		Properties prop = new Properties();
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream(daoMapperLocation);
//			prop.load(fis);
//			Iterator keyIter = prop.keySet().iterator();
//			System.out.println("--- DAO 생성 목록 ---");
//			while (keyIter.hasNext()) {
//				String daoName = (String) keyIter.next();
//				String daoClassName = prop.getProperty(daoName);
//				// 컨트롤러 생성
//				Object daoObject = (UserDao) Class.forName(daoClassName).newInstance();
//				daos.put(daoName, daoObject);
//				System.out.println(daoName + "=" + daoObject);
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//
//	public Object getDao(String daoName) {
//		return daos.get(daoName);
//	}
//	
//
//	public Object getDao(Class cls) {
//		return daos.get(cls.getName());
//	}
//	
//	public static void main(String[] args) throws Exception {
//		DaoFactory factory = new JdbcDaoFactory();
//		UserDao dao = factory.getUserDao();
//		List<User> list = dao.listAll();
//		for (User user : list) {
//			System.out.println(user.toString());
//		}
//		
//	}
	
}
