<%@page import="kr.or.kosta.blog.article.PageBuilder"%>
<%@page import="kr.or.kosta.blog.article.Params"%>
<%@page import="kr.or.kosta.blog.article.Article"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.blog.article.ArticleDao"%>
<%@page import="kr.or.kosta.blog.dao.JdbcDaoFactory"%>
<%@page import="kr.or.kosta.blog.dao.DaoFactory"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%
//로그인 확인
String loginId = null;

Cookie[] cookies = request.getCookies();
if(cookies != null) {
  for (Cookie cookie : cookies) {
    if(cookie.getName().equals("loginId")) {
      loginId = cookie.getValue();
      break;
    }
  }
}


// 페이지당 보여지는 목록수 설정
int listSize = 10;
//페이지당 보여지는 페이지수 설정
int pageSize = 10;

// 선택페이지 수신
String requestPage = request.getParameter("page");
if(requestPage == null || requestPage.equals("")){
  requestPage = "1";
}

// 검색 요청일 경우 파라메터 수신
String searchType = request.getParameter("searchType");
String searchValue = request.getParameter("searchValue");
if(searchType == null || searchType.equals("")){
  searchType = null;
  searchValue = null;
}

//요청파라메터 포장
Params params = new Params(Integer.parseInt(requestPage), listSize, pageSize, searchType, searchValue);
DaoFactory factory = (DaoFactory)application.getAttribute("factory");
ArticleDao daoA = factory.getArticleDao();
//List<Article> list= daoA.listAll();
List<Article> list= daoA.listByPage(1,params);

    
// 페이징 처리에 필요한 검색 개수 DB조회
int rowCount = daoA.countBySearch(1,params); //검색된 행수 

// PageBuilder를 이용하여 페이징 계산
PageBuilder pageBuilder = new PageBuilder(params, rowCount);
pageBuilder.build();


%>


<!--  자유게시판 테이블 -->
<div class="card-body">
  <div class="table-responsive">

    <%-- 검색 폼 --%>
    <div class="search">
      <form>
        <select name="searchType" class="set-border">
          <option value="">선택</option>
          <option value="writer">작성자</option>
          <option value="subject">글제목</option>
          <option value="content">글내용</option>
        </select> 
        <input type="text" name="searchValue" placeholder="Search..">
        <input type="submit" class="btn btn-primary set-border" value="검색">
      </form>
    </div>

    <table class="table table-bordered" id="dataTable" width="100%"
      cellspacing="0">
      <thead>
        <tr>
          <th class="sorting_desc" 
          aria-label="번호: activate to sort column ascending"
          aria-sort="descending">번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>아이피</th>
          <th>조회</th>
        </tr>
      </thead>
        <%
        for(int i=0; i<list.size(); i++){
         Article article= list.get(i); 
         
        //삭제된 게시글인지 확인
        boolean isDeleted= false;
        String[] strs= article.getSubject().split("\\^DEL%ETE\\^");
        System.out.println(strs.length);
        if(strs.length >1){
        isDeleted= true; //삭제된 게시글임 
        %>
        <tr class="pointer tr-subject">
        <%
        } else{
       %>
        <tr class="pointer tr-subject"
        onclick="location.href='view-article.jsp?article_id=<%=article.getArticle_id()%>'">
       <%
        }
        
        boolean isReply= false;//이 글이 원글인지 답변글인지 확인 
        if(isDeleted == false){ //삭제되지 않은 게시글이면 
        	if (article.getLevelNum()==0) { //원글임
        	 isReply= false;
        	} else{
        	 isReply= true;// 답변글임 -> 제목에 이미지 추가  
        	}
        }
        %>
            <td name= "article_id">
            <%=(rowCount - listSize * (params.getPage()-1) ) - i %>
          <%--  <%= article.getArticle_id() %> --%> 
            </td>
            
            <td>
            <%
           
            if(isDeleted == true){// 삭제된 게시글임
            	 System.out.println(strs[1]);
             %>
              <%= strs[1] %>             
             <% 
            } else{ 
              if(isReply== true){
                for( int k=0; k<article.getLevelNum(); k++){
              %>
              <i class="fas fa-angle-right"></i>
              <%
                }
              }
            %>
             <%= article.getSubject()  %>
            <% 	
            }
            %>
            </td>
            
            <td>
            <%= article.getWriter() %>
            </td>
            
            <td>
            <%= article.getRegdate() %>
            </td>
            
            <td>
            <%= article.getIp() %>
            </td>
            
            <td>
            <%= article.getHitCount() %>
            </td>
            </tr>
         
        <%
        }
        %>
      </tbody>
      </form>
    </table>
  </div>
  
      <%-- 페이징 처리 --%>
    <div class="pagination">
      <% //처음으로 보여주기
      if(pageBuilder.isShowFirst()){
      %>
        <a class="paging page-start" href="<%=pageBuilder.getQueryString(1)%>">처음으로</a>      
      <%        
      }
      %>
      
      <% //이전목록 보여주기
      if(pageBuilder.isShowPrevious()){
      %>
        <a class="paging page-prev" href="<%=pageBuilder.getQueryString(pageBuilder.getPreviousStartPage())%>">&laquo;</a>      
      <%        
      }
      %>
      
      <%
      for(int i=pageBuilder.getStartPage(); i<=pageBuilder.getEndPage(); i++){
        if(i == params.getPage()){
      %>
          <a class="active paging" ><%=i %></a>
      <%          
        }else{
      %>
           <a class="paging"  href="<%=pageBuilder.getQueryString(i)%>"><%=i %></a>
      <%          
        }
      }
      %>
      
      <% //다음으로 보여주기
      if(pageBuilder.isShowNext()){
      %>
        <a class="paging page-next" href="<%=pageBuilder.getQueryString(pageBuilder.getNextStartPage())%>">&raquo;</a>      
      <%        
      }
      %>
      <% //끝으로 보여주기
      if(pageBuilder.isShowLast()){
      %>
        <a class="paging page-end" href="<%=pageBuilder.getQueryString(pageBuilder.getPageCount())%>">끝으로</a>      
      <%        
      }
      %>
    </div>
    
</div>
