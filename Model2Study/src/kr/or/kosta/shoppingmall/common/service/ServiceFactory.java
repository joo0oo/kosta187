package kr.or.kosta.shoppingmall.common.service;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.lang.reflect.Method;

import javax.sql.DataSource;

import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;


/**
 * Factory 패턴 적용 ControllerFactory
 * 
 * @author 김기정
 */
public class ServiceFactory {
	private Hashtable<String, Object> serviceList;

	public ServiceFactory(String serviceMapperLocation) {
		serviceList = new Hashtable<String, Object>();

	      Properties prop = new Properties();
	      FileInputStream fis = null;
	      try {
	         fis = new FileInputStream(serviceMapperLocation);
	         prop.load(fis);
	         Iterator keyIter = prop.keySet().iterator();
	         System.out.println("------ 서비스 생성 목록 ------");
	         while (keyIter.hasNext()) {
	            String serviceName = (String) keyIter.next();
	            String serviceClassName = prop.getProperty(serviceName);
	            Object serviceObject = Class.forName(serviceClassName).newInstance();
	            serviceList.put(serviceClassName, serviceObject);
	            
	            System.out.println(serviceClassName+" = "+serviceObject);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public Object getService(String serviceNae) {
		return serviceList.get(serviceNae);
	}

	public Object getService(Class cls) {
		return serviceList.get(cls.getName());
	}
	
	public static void main(String[] args) {
		String mapperLocation= "C:/KOSTA187/workspace/Model2Study/WebContent/WEB-INF/service-mapper.properties";
		ServiceFactory factory= new ServiceFactory(mapperLocation);
		UserService userService = (UserService)factory.getService(UserServiceImpl.class);
	}

}
