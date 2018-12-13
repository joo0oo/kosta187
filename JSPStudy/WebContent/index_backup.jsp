<%@ page contentType="text/html; charset=utf-8" %>
<%!
boolean isLogin;
String userId;

//선언문 : 인스턴스 변수 -> 초기화 하려면 init()을 오버라이딩 해야한다 

public void jspInit() {
	isLogin=false;
	userId=null;
}

public void jspDestroy() {
	isLogin=false;
	userId=null;
}

public void logout(){
	isLogin=false;
	userId=null;
}

%>


<% 
//boolean isLogin= false;
//String userId= null;

//boolean isLogoutClicked = false;
if (request.getParameter("logout") != null){
	logout(); 
  
  System.out.println("logout : "+ request.getParameter("logout"));
  System.out.println("userId : "+ request.getParameter("userId"));
  System.out.println("isLogin : "+ request.getParameter("isLogin"));
 
}


session.setAttribute("isLogin", isLogin);
session.setAttribute("userId", userId);
System.out.println("userId : "+ request.getParameter("userId"));
System.out.println("isLogin : "+ request.getParameter("isLogin"));
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/basic.css">

</head>
<body>

<div class="header">
  <h1>My Website</h1>
  <p>Resize the browser window to see the effect.</p>
</div>

<div class="topnav">
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#">Link</a>
  <a href="#" style="float:right">Link</a>
</div>

<div class="row">
  <div class="leftcolumn">
    <div class="card">
      <h2>TITLE HEADING</h2>
      <h5>Title description, Dec 7, 2017</h5>
      <div class="fakeimg" style="height:200px;">Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
    <div class="card">
      <h2>TITLE HEADING</h2>
      <h5>Title description, Sep 2, 2017</h5>
      <div class="fakeimg" style="height:200px;">Image</div>
      <p>Some text..</p>
      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>
    </div>
  </div>
  
  <div class="rightcolumn">
    <div class="card">
     <div>
     
    <%
      if(request.getParameter("userid") != null){
        userId= request.getParameter("userid");
        if(userId != "" || userId.length()!= 0){
      	     isLogin=true; 
      	     session.setAttribute("isLogin", isLogin);
      	    } 
      }
   
    isLogin = (boolean)session.getAttribute("isLogin");
    
    if(isLogin==true){
    %>
      <p> [<%= userId%>] 님 로그인중 </p>
      <form method="post" action="index.jsp" >
        <input type="hidden" name="logout">
        <input type="submit"  value="Logout">
      </form>
    
    <%
    }else{
    %> 
       <form method="post" action="index.jsp" >
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
  </div>
</div>

<div class="footer">
  <h2>Footer</h2>
</div>

</body>
</html>
