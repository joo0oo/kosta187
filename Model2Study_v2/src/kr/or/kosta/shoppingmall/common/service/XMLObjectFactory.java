package kr.or.kosta.shoppingmall.common.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import com.sun.xml.internal.ws.util.StringUtils;

import kr.or.kosta.shoppingmall.common.dao.DaoFactory;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

public class XMLObjectFactory extends DaoFactory {

	private Hashtable<String, Object> serviceList; //service 객체를 저장하기 위한 맵
	private Hashtable<String, Object> daoList; //dao 객체를 저장하기 위한 맵

	public XMLObjectFactory(String objectMapperLocation) throws Exception {
		serviceList = new Hashtable<String, Object>();
		daoList = new Hashtable<String, Object>();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder parser = factory.newDocumentBuilder();

		String xmlPath = objectMapperLocation;
		Document document = parser.parse(xmlPath);
		
		// 루트 엘리먼트 취득
		Element beanlistElement = document.getDocumentElement();
		System.out.println("root : "+beanlistElement.toString());
		
		// 루트 엘리먼트의 모든 자식 노드 검색
//		NodeList beanElements = beanlistElement.getChildNodes();
//		System.out.println("[디버깅]: 자식노드수: " + beanElements.getLength());
//		
//		for (int i = 0; i < beanElements.getLength(); i++) {
//			Node node = beanElements.item(i);
//			System.out.println("[디버깅]: " + node.toString());
//			System.out.println(node.getNodeName());
//		}
		
		System.out.println("------------------------------------------------------");
		
		NodeList beanList = document.getElementsByTagName("bean");
		System.out.println("[디버깅]: bean 엘리먼트 갯수: " + beanList.getLength());
		for (int i = 0; i < beanList.getLength(); i++) {
			Element beanE = (Element) beanList.item(i);
			System.out.println("node : "+beanE.getNodeName());
			System.out.println("type : "+beanE.getAttribute("type"));
			System.out.println("name : "+beanE.getAttribute("name"));
			System.out.println("class : "+beanE.getAttribute("class"));
			
			if(beanE.getAttribute("type").equals("dao")) {
				
				String daoName = beanE.getAttribute("name");
				String daoClassName = beanE.getAttribute("class");
				Object daoObject = Class.forName(daoClassName).newInstance();
				addDataSource(daoObject);
				daoList.put(daoName, daoObject);
				System.out.println(daoName + "=" + daoObject);
				System.out.println(" ! dao created ! ");
				
			} else if(beanE.getAttribute("type").equals("service")) {
				
				
				String serviceName = beanE.getAttribute("name");
				String serviceClassName = beanE.getAttribute("class");
				Object serviceObject = Class.forName(serviceClassName).newInstance();
				serviceList.put(serviceClassName, serviceObject);
				
				NodeList list = beanE.getChildNodes();
				for(int j=0; j<list.getLength(); j++){
					if(list.item(j).getNodeName().equals("property")) {
						System.out.println("이 노드의 property 자식이 있는 경우");
						Element fE= (Element) list.item(j);
						System.out.println("node : "+fE.getNodeName());
						System.out.println("name : "+fE.getAttribute("name"));
						System.out.println("ref : "+fE.getAttribute("ref"));
						
						String daoName = fE.getAttribute("name");
						String methodName = "set" + StringUtils.capitalize(daoName);
						Class cls = serviceObject.getClass();
						Method method = null;
						try {
							String interfaceName = getDao(daoName).getClass().getInterfaces()[0].getName();
//							method = cls.getMethod(methodName, UserDao.class);
							method = cls.getMethod(methodName,Class.forName(interfaceName));
							method.invoke(serviceObject, getDao(daoName));
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				System.out.println("! service created !");
			}// service 
				
				
				//String[] parsedServiceName = parsedText[1].split("->"); //property 확인
				//String serviceName = parsedServiceName[0]; //userService 
				
				//String serviceClassName = prop.getProperty(text);
				//Object serviceObject = Class.forName(serviceClassName).newInstance();
				//serviceList.put(serviceClassName, serviceObject);
				
//				if (parsedServiceName.length == 2) {
//					String daoName = parsedServiceName[1];
//					String methodName = "set" + StringUtils.capitalize(daoName);
//					Class cls = serviceObject.getClass();
//					Method method = null;
//					try {
//						String interfaceName = getDao(daoName).getClass().getInterfaces()[0].getName();
////						method = cls.getMethod(methodName, UserDao.class);
//						method = cls.getMethod(methodName,Class.forName(interfaceName));
//						method.invoke(serviceObject, getDao(daoName));
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//			}
//			
			
			System.out.println();
		}
		
		/*
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(objectMapperLocation);
			prop.load(fis);
			Iterator iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String text = (String) iter.next();
				String[] parsedText = text.split("]");
				if (parsedText.length > 1) {
					String type = parsedText[0].substring(1, parsedText[0].length());
					if (type.equals("dao")) {
						String daoName = parsedText[1];
						String daoClassName = prop.getProperty(text);
						Object daoObject = Class.forName(daoClassName).newInstance();
						addDataSource(daoObject);
						daoList.put(daoName, daoObject);
						System.out.println(daoName + "=" + daoObject);
					}
				}
			}
			
			iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String text = (String) iter.next();
				String[] parsedText = text.split("]");
				if (parsedText.length > 1) {
					String type = parsedText[0].substring(1, parsedText[0].length());
					if (type.equals("service")) {
						String[] parsedServiceName = parsedText[1].split("->");
						String serviceName = parsedServiceName[0];
						
						String serviceClassName = prop.getProperty(text);
						Object serviceObject = Class.forName(serviceClassName).newInstance();
						serviceList.put(serviceClassName, serviceObject);
						
						if (parsedServiceName.length == 2) {
							String daoName = parsedServiceName[1];
							String methodName = "set" + StringUtils.capitalize(daoName);
							Class cls = serviceObject.getClass();
							Method method = null;
							try {
								String interfaceName = getDao(daoName).getClass().getInterfaces()[0].getName();
//								method = cls.getMethod(methodName, UserDao.class);
								method = cls.getMethod(methodName,Class.forName(interfaceName));
								method.invoke(serviceObject, getDao(daoName));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						System.out.println(serviceClassName + "=" + serviceObject);
					}
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
	}

	public Object getService(String serviceName) {
		return serviceList.get(serviceName);
	}

	public Object getService(Class cls) {
		return getService(cls.getName());
	}

	public Object getDao(String daoName) {
		return daoList.get(daoName);
	}

	public Object getDao(Class cls) {
		return getDao(cls.getName());
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
	
	private void addDao(Object service, String daoName, String methodName, Object dao) {
		Class cls = service.getClass();
		Method method;
		try {
			method = cls.getMethod(methodName, Class.forName(daoName));
			method.invoke(service, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String mapperLocation = "C:/KOSTA187/workspace/Model2Study_v2/WebContent/WEB-INF/object-mapper.xml";
		XMLObjectFactory factory = new XMLObjectFactory(mapperLocation);
		UserService userService = (UserService) factory.getService(UserServiceImpl.class);
		System.out.println(userService.list());

	}

}
