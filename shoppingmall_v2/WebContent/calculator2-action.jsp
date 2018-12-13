<%@ page contentType="text/html; charset=utf-8" %>

<%
String num1= request.getParameter("num1");
String num2= request.getParameter("num2");
String op= request.getParameter("op");

System.out.println("[from client]"+num1+" : "+num2+" : "+op);
int res=0;

if(num1 != null && num2 != null){
  int n1= Integer.parseInt(num1);
  int n2= Integer.parseInt(num2);
  
  switch(op){
  case "plus":
    res=n1+n2;
    break;
  case "-":
    res=n1-n2;
    break;
  case "*":
    res=n1*n2;
    break;
  case "/":
    res=n1/n2;
    break;
  }
}
  System.out.println("res : "+res);
  String url= "/shoppingmall_v2/calculator2.jsp?res="+res;
  
  response.sendRedirect(url);
%>

