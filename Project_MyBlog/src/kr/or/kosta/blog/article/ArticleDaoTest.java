package kr.or.kosta.blog.article;

import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import kr.or.kosta.blog.dao.DaoFactory;
import kr.or.kosta.blog.dao.JdbcDaoFactory;

public class ArticleDaoTest {

	public static void main(String[] args) {
		DaoFactory factory = new JdbcDaoFactory();
		ArticleDao dao = factory.getArticleDao();
		try {
			
//			System.out.println("**** 전체목록 테스트 ****");
//			List<Article> list =  dao.listAll();
//			for (Article art : list) {
//				System.out.println(art);				
//			}
			
//			System.out.println("검색: "+dao.read(1));
//			System.out.println("선택페이지에 따른 목록 반환");
//			System.out.println(dao.listByPage(1));
//			System.out.println("선택페이지와 리스트 사이즈에 따른 목록 반환");
//			System.out.println(dao.listByPage(1,10));
//			System.out.println(dao.listByPage(1, 10, "writer", "bangry"));
//			System.out.println(dao.listByPage(1));
			//System.out.println(dao.countBySearch("writer", "bangry"));
			
		//	String str= "^DEL%ETE^[삭제된 게시글]";
		//	String str= "게시글";
		//	String[] strs=str.split("\\^DEL%ETE\\^");
		//	System.out.println(strs.length);
			
		//	System.out.println(dao.countTodayArticle(1));
			
			String ip="127.0.0.1";
			String[] IPs= ip.split("\\.");
			String secureIP="";
			for(int i=0; i<IPs.length; i++) {
				if(i >= IPs.length-2) {
					secureIP += "xxx";
				} else {
					secureIP+= IPs[i];
				} 
				
				if(i != IPs.length-1) {
					secureIP += '.';
				}
			}
			System.out.println(secureIP);
		//	dao.delete(35);
			/*
			StringTokenizer token= new StringTokenizer(str, "$D#C$");
			System.out.println(token.nextToken());
			
			String str2= "게시글]";
			StringTokenizer token2= new StringTokenizer(str2, "$D#C$");
			*/
			/*
			if(token2== null) {
				System.out.println("살아있는 게시글");
			} else {
				System.out.println(token.nextToken());
			}
			*/
			
			
			//Footage f1=new Footage();
			//dao.create(f1);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
			SQLException ex = (SQLException)e;
			System.out.println(ex.getErrorCode());
		}

	}

}
