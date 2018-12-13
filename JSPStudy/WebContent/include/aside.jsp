<%@ page language="java" contentType="text/html; charset=utf-8" %>
<div class="rightcolumn">
    <div class="card">
     <div>
     
    <%
    
    String userId=null;
    boolean isLogin= false;

    Cookie[] cookies= request.getCookies();
    if(cookies != null) {
      for (Cookie cookie : cookies) {
        System.out.println(cookie.getName()+" : "+cookie.getValue());
        
        if(cookie.getName().equals("userid")) {
        	userId= cookie.getValue();
        } else if(cookie.getName().equals("isLogin")) {
        	if(cookie.getValue().equals("true")){
              isLogin= true;
          }
        } 
      }
    }
    
    
    if(isLogin==true){
    %>
      <p> [<%= userId%>] 님 로그인중 </p>
      <form method="post" action="jsp/user/loginAction.jsp" >
        <input type="hidden" name="logout">
        <input type="submit"  value="Logout">
      </form>
    
    <%
    }else{
    %> 
       <form method="post" action="/jsp/user/loginAction.jsp" >
          <input type="text" id="userid" name="userid" placeholder="Identifier...">
          <input type="password" id="userpw" name="userpw" placeholder="Password...">
          <input type="submit" value="Login">
        </form>
    <% 
    }
    %>
       
      </div>
    </div>
    <div class="card">
      <h3>Popular Post</h3>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
      <div class="fakeimg"><p>Image</p></div>
    </div>
    <div class="card">
      <h3>Follow Me</h3>
      <p>Some text..</p>
    </div>
  </div> <!-- right column 종료 -->