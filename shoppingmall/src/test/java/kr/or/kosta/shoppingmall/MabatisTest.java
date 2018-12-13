package kr.or.kosta.shoppingmall;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.employee.domain.Employee;

public class MabatisTest {

	String resource = "mybatis-config.xml";
	private static final String NAMESPACE= "kr.or.kosta.shoppingmall.employee.";
	SqlSessionFactory sqlSessionFactory;
	Reader reader;
	
	Logger logger= Logger.getLogger(MabatisTest.class);
	
	@Before
	public void setUp() {
		try {
			reader= Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
		logger.debug("sql session factory 생성 완료 ");
	}
	
	//@Test
	public void testMabatis() {
		//logger.debug("test 시작 ");
		SqlSession sqlSession= sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE+"selectAll");
		
		for (Employee employee : list) {
			logger.debug(employee);
		}
		
		sqlSession.close();
	}
	
	//@Test
	public void testSelectOne() {
		int num=100;
		SqlSession sqlSession= sqlSessionFactory.openSession();
		Employee employee = sqlSession.selectOne(NAMESPACE+"selectEmployeeById",num);
		
		logger.debug(employee);
		sqlSession.close();
	}
	
	//@Test
	public void testSelectOne2() {
		int num=100;
		SqlSession sqlSession= sqlSessionFactory.openSession();
		int salary = sqlSession.selectOne(NAMESPACE+"selectSalaryById",num);
		
		logger.debug(salary);
		sqlSession.close();
	}
	
	//@Test
	public void testSelectList2() {
		Map<String, Integer> params= new HashMap<String, Integer>();
		params.put("min", 3000);
		params.put("max", 4000);
		SqlSession sqlSession= sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE+"selectEmployeesBySalary",params);
		
		for (Employee employee : list) {
			logger.debug(employee);
		}
		
		sqlSession.close();
	}
	
	//@Test
	public void testSelectListLike() {
		String name= "%e%";
		SqlSession sqlSession= sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE+"selectEmployeesByLastName",name);
		
		for (Employee employee : list) {
			logger.debug(employee);
		}
		
		sqlSession.close();
	}
	
	@Test
	   public void testSelectListJoin() {
	      String name = "%E%";
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      List<Map<String, Object>> lists = sqlSession.selectList(NAMESPACE + "selectEmployeesWithDepartment");
	      for (Map<String, Object> map : lists) {
//	         logger.debug(map);
	         BigDecimal id = (BigDecimal) map.get("id");
	         String lastName = (String) map.get("lastName");
	         logger.debug(id);
	         logger.debug(lastName);
	      }
	      sqlSession.close();
	   }

	   @Test
	   public void testUpdate() {
	      Employee employee = new Employee();
	      employee.setId(100);
	      employee.setSalary(24000);
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      sqlSession.update(NAMESPACE + "updateEmployee", employee);
	      sqlSession.commit();
	      logger.debug("업데이트 완료!");
	      sqlSession.close();
	   }
	   
	   @Test
	   public void testDynamic() {
	      SqlSession sqlSession = sqlSessionFactory.openSession();
	      Map<String, String> map = new HashMap<>();
	      map.put("searchType", "id");
	      map.put("searchValue", "100");
	      List<Employee> list =sqlSession.selectList(NAMESPACE + "dynamicSQL", map);
	      for (Employee employee : list) {
	         logger.debug(employee);
	      }
	      sqlSession.close();
	   }
}
