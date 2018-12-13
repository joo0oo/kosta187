<%@ page contentType="text/html; charset=utf-8" %>
<%
String res= null;
if(request.getParameter("res") != null){
	res= request.getParameter("res");
}
System.out.println("[from server]"+res);
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>미션) 계산기</title>
</head>
<body>
  <input type="number" name="num1">
  <select name="operator">
    <option>+</option>
    <option>-</option>
    <option>*</option>
    <option>/</option>
  </select>
  <input type="number" name="num2">
  <span id="output"><%=res %></span>
  <input type="button" id="result" value="결과보기" >
  
</body>
</html>



<script type="text/javascript">

window.onload=function(){
	//init();
	eventRegist();
}

function eventRegist(){
//	document.getElementById('result').onclick=calculate;	
	document.getElementById('result').onclick=calculate2;	
}

function calculate2(){
	//setOpAttribute();
	var num1= Number(document.getElementsByName('num1')[0].value);
	var num2= Number(document.getElementsByName('num2')[0].value);

	var target= document.getElementsByName('operator')[0];
	var op= target.options[target.selectedIndex].text;
	if(op == '+'){
		op='plus';
	}
	var url = '/shoppingmall_v2/calculator2-action.jsp?num1='+num1+'&num2='+num2+'&op='+op;
	console.log(url);
	location.href=url;
	
}

function setOpAttribute(){
	var target= document.getElementsByName('operator')[0];
	var op= target.options[target.selectedIndex].setAttribute('name','selected');
}

</script>
