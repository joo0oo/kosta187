package kr.or.kosta.reservationmall.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import kr.or.kosta.reservationmall.board.dto.Article;
import kr.or.kosta.reservationmall.board.dto.Board;
import kr.or.kosta.reservationmall.board.service.ArticleService;
import kr.or.kosta.reservationmall.board.service.ArticleServiceImpl;
import kr.or.kosta.reservationmall.board.service.BoardService;
import kr.or.kosta.reservationmall.common.controller.Controller;
import kr.or.kosta.reservationmall.common.controller.ModelAndView;
import kr.or.kosta.reservationmall.common.factory.XMLObjectFactory;
import kr.or.kosta.reservationmall.login.service.LoginService;
import kr.or.kosta.reservationmall.login.service.LoginServiceImpl;
/**
 * 전체 공지사항 리스트 인출을 위한 컨트롤러 설정
 * @author 이혜림
 *
 */
public class ArticleController implements Controller {
	
	private ArticleService articleService;
	Logger logger = Logger.getLogger(Controller.class);

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		articleService = (ArticleService)factory.getBean(ArticleServiceImpl.class);

		List <Article> list= null;
	
		try {
			list = articleService.listAll_hr();
			for (Article article : list) {
				
				String articleId = article.getId();
				System.out.println("아티클 아이디 들어오니?? 확인 " + articleId);
				articleService.increaseHitCount_hr(articleId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.setContentType("text/plain; charset=utf-8");
		PrintWriter out = null;
		String result = "";
		for (Article article : list) {
			result += 	"	<tr class='tr_visible' >" + 
						"  		 <td scope='row'>"+article.getId()+"</td>\r\n" + 
						"   	 <td>"+article.getTitle()+ 	  "</td>\r\n"+ 
						"    	 <td>"+article.getUserId()+	  "</td>\r\n" + 
						"    	 <td>"+article.getDate()+	  "</td>\r\n" + 
						"    	 <td>"+article.getHitCount()+ "</td>\r\n" +
						"    	 <td><button name='myhide' class='btn btn-primary' type='button'>상세보기</button></td>\r\n" +
						"	</tr>\r\n"+ 
						"	<tr name='conts' style='display:none;'>\r\n" + 
						"  		 <td scope='row' colspan='6'>"+article.getContents()+"</td>\r\n" + 
						"	</tr>";
		}
		try {
		out = response.getWriter();
		out.println(result);
		}catch(IOException e) {
		
		}
		return null;
	}
}