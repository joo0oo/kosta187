<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%
request.setCharacterEncoding("utf-8");

String num1= request.getParameter("num1");
String num2= request.getParameter("num2");
String op= request.getParameter("op");
System.out.println("[from client]"+num1+" : "+num2+" : "+op);
//Thread.sleep(5000);

int n1= Integer.parseInt(num1);
int n2= Integer.parseInt(num2);
int res=0;
switch(op){
case "plus":
  res =n1+n2;
  break;
case "-":
  res= n1-n2;
  break;
case "*":
  res= n1*n2;
  break;
case "/":
  res= n1/n2;
  break;
}

out.println(res);
%>