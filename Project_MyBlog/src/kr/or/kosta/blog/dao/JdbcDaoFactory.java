package kr.or.kosta.blog.dao;

import java.lang.reflect.Method;

import javax.sql.DataSource;

import kr.or.kosta.blog.article.ArticleDao;
import kr.or.kosta.blog.article.JdbcArticleDao;
import kr.or.kosta.blog.footage.FootageDao;
import kr.or.kosta.blog.footage.JdbcFootageDao;
import kr.or.kosta.blog.user.JdbcUserDao;
import kr.or.kosta.blog.user.UserDao;
/**
 * DataSource를 계속해서 생성하는 문제 해결
 * 종류별 JdbcDao를 만드는 factory
 * @author 송주현
 *
 */
public class JdbcDaoFactory extends DaoFactory {

	@Override
	public UserDao getUserDao() { //회원정보 관리
		UserDao dao = new JdbcUserDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao,getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

	@Override
	public FootageDao getFootageDao() {//방명록 정보 관리
		FootageDao dao = new JdbcFootageDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}

	@Override
	public ArticleDao getArticleDao() { //게시글 정보 관리
		ArticleDao dao = new JdbcArticleDao();
		Class cls = dao.getClass();
		
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dao;
	}
	

}
