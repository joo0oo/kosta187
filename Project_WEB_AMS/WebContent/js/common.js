/**
 * html에서 관리
 */

window.onload = function(){
	init();
	eventRegist();
}

function init(){
	//초기화 작업
    manager=new AccountManager();
    table_doc= document.getElementById('viewTable'); //iframe의 html에 접근
	table_body= table_doc.contentWindow.document.getElementById('contents');
	console.log(table_body);
    
    var acc=new Account('111-111-111','김기정',1111,2000);
	var mAcc= new MinusAccount('1111-2222-2222','마기정',1111,2000,5000);
	manager.add(acc);
	manager.add(mAcc);
	manager.add(new Account('222-222-222','이기정',2222,2000));
    manager.add(new MinusAccount('333-333-333','삼기정',3333,3000,30000));
    manager.add(new MinusAccount('1111-2222-3333','마기정',1111,500,5500));
    manager.add(new Account('1111-2222-4444','마기정',1111,8000));
    
}

function eventRegist(){
	//이벤트 등록
	document.getElementById('accSearch').onclick= searchByAccNum;
	document.getElementById('accDelete').onclick= removeByAccNum;
	document.getElementById('accSearchByName').onclick= searchByName;
	document.getElementById('createAcc').onclick= createAcc;
	document.getElementById('listAll').onclick= listAllAccs;
	
	document.getElementById('deposit_or_withdraw_button').onclick=setEditMoneyForm;
	document.getElementById('defaultForm_button').onclick=setDefaultForm;
	
	
	document.getElementById('deposit_id').onclick=depositMoney;
	document.getElementById('withdraw_id').onclick=withdrawMoney;
	
	document.getElementById('accNum').onkeyup=function(e){
		isValidAccNum();
		if( e.keyCode == 13) {//키보드의 엔터(13)가 눌렸을 때
			searchByAccNum();
		} 
	}
	
	document.getElementById('accName').onkeyup=function(e){
		isValidAccName();
		if( e.keyCode == 13) {//키보드의 엔터(13)가 눌렸을 때
			searchByName();
		} 
	}
	
	document.getElementById('passwd').onkeyup=function(e){
		isValidPasswd();
	}
	document.getElementById('depositMoney').onkeyup=function(e){
		isValidMoney();
	}
	document.getElementById('borrowMoney').onkeyup=function(e){
		isValidMoney();
	}
	
}


//표 리셋
function clearTable(){
	table_body.innerHTML = '';
}

//계좌 정보 표에 보이기
function appendTable(account){
	var res='';
	res += '<tr>';
	res += '<td>';
	if( account instanceof MinusAccount ){
		res += '마이너스';
	} else{
		res += '입출금';
	}
	res += '</td>';
	res += '<td>';
	res += account.accountNum;
	res += '</td>';
	res += '<td>';
	res += account.accountOwner;
	res += '</td>';
	res += '<td>';
	res += account.restMoney;
	res += '</td>';
	res += '<td>';
	if( account instanceof MinusAccount ){
		res += account.borrowMoney;
	} else{
		res += '-';
	}
	res += '</td>';
	res += '</tr>';
	
	table_body.innerHTML += res;
}

//표에 에러 메세지 표시
function setMessage_onTable(message){
	table_body.innerHTML += '<tr> <td colspan="7"> <font size="7pt">'+message+'</font> </td> </tr>';
}

//폼의 모든 에러 메세지 숨기기
function hideMessages_onTable(){
	document.getElementById('checkType_id').style.visibility='hidden';
	document.getElementById('checkAccNum_id').style.visibility='hidden';
	document.getElementById('checkName_id').style.visibility='hidden';
	document.getElementById('checkPasswd_id').style.visibility='hidden';
	document.getElementById('checkMoney_id').style.visibility='hidden';
}

//폼의 모든 입력필드 초기화
function resetForm(){
	document.getElementById('accNum').value='';
	document.getElementById('accName').value='';
	document.getElementById('passwd').value='';
	document.getElementById('depositMoney').value='';
	document.getElementById('borrowMoney').value='';
}

//빈 텍스트인지 검사
function isEmptyTxt(txt){
	if(txt=='' || txt.trim().length==0){
		return true;
	}
	return false;
}

//계좌 유형 가져오기
function getAccTypefromSelect(){
	var target= document.getElementById('accType');
	var accType= target.options[target.selectedIndex].text;
	return accType;
}

//마이너스 계좌일때만 대출금 입력칸 활성화
function chageAccTypeSelect(){
	var target= document.getElementById('accType');
	var accType= target.options[target.selectedIndex].text;
	document.getElementById('borrowMoney').value='';
	
	isValidAccType();
	if(accType=='마이너스'){
		document.getElementById('borrowMoney').removeAttribute('disabled');
		document.getElementById('borrowMoney').setAttribute('placeholder','0이상의 금액 입력');
	}
	if(accType=='입출금' || accType=='전체'){
		document.getElementById('borrowMoney').setAttribute('disabled','disabled');
		document.getElementById('borrowMoney').setAttribute('placeholder','현재 사용불가');
	}
}


//계좌 종류 유효성 검사
function isValidAccType(){
	var accType= getAccTypefromSelect();
	if(accType=='전체'){
		document.getElementById('checkType_id').style.visibility='visible';
		return false;
	}
	document.getElementById('checkType_id').style.visibility='hidden';
	return true;
}

//계좌 번호 유효성 검사
function isValidAccNum(){
	var accNum= document.getElementById('accNum').value;
	if(isEmptyTxt(accNum)){
		document.getElementById('checkAccNum_id').style.visibility='visible';
		return false;
	}
	
	var reg= /^\d{3,5}-\d{3,5}-\d{3,5}$/;
	if( ! reg.test(accNum) ){
		document.getElementById('checkAccNum_id').style.visibility='visible';
		return false;
	}
	document.getElementById('checkAccNum_id').style.visibility='hidden';
	return true;
}

//예금주명 유효성 검사
function isValidAccName(){
	var name= document.getElementById('accName').value;
	if(isEmptyTxt(name)){
		document.getElementById('checkName_id').style.visibility='visible';
		return false;
	}
	
	var regK= /^[가-힣]{2,5}$/; //한글이름
	var regE= /^[a-zA-Z]{2,15}$/; //영어이름

	if( !(regK.test(name) || regE.test(name)) ){
		document.getElementById('checkName_id').style.visibility='visible';
		return false;
	}
	document.getElementById('checkName_id').style.visibility='hidden';
	return true;
}

//비밀번호 유효성 검사
function isValidPasswd(){
	var passwd= document.getElementById('passwd').value;
	var reg= /^\d{4}$/;
	if( ! reg.test(passwd) ){
		document.getElementById('checkPasswd_id').style.visibility='visible';
		return false;
	}
	document.getElementById('checkPasswd_id').style.visibility='hidden';
	return true;
}

//입금 대출 금액 유효성 검사
function isValidMoney(){
	
	var accType= getAccTypefromSelect();
	
	var depositMoney= document.getElementById('depositMoney').value;
	document.getElementById('checkMoney_id').firstChild.nodeValue='올바른 입금금액을 입력하세요';
	var positiveNum = /^\d*[^.]$/;
	
	
	if(isEmptyTxt(depositMoney)){
		document.getElementById('checkMoney_id').style.visibility='visible';
		return false;
	}
	if (depositMoney <0 || !(positiveNum.test(depositMoney)) ){
		document.getElementById('checkMoney_id').style.visibility='visible';
		return false;
	}
	
	if(accType=='마이너스'){
		document.getElementById('checkMoney_id').firstChild.nodeValue='올바른 대출금액을 입력하세요';
		
		var borrowMoney= document.getElementById('borrowMoney').value;
		if(isEmptyTxt(borrowMoney)){
			document.getElementById('checkMoney_id').style.visibility='visible';
			return false;
		}
		if (borrowMoney <0 || !(positiveNum.test(borrowMoney)) ){
			document.getElementById('checkMoney_id').style.visibility='visible';
			return false;
		}
	}
	document.getElementById('checkMoney_id').style.visibility='hidden';
	return true;
}

//계좌번호로 찾기
function searchByAccNum(){
	clearTable();
	hideMessages_onTable();
	if( isValidAccNum() ){ //유효성 검사
		var accNum= document.getElementById('accNum').value;
		var acc= manager.get(accNum);
		if(acc== null){
			setMessage_onTable('존재하지 않는 계좌번호');
		}else{
			appendTable(acc);
		}
	}
}

//계좌번호로 지우기
function removeByAccNum(){
	clearTable();
	hideMessages_onTable();
	if( isValidAccNum() ){ //유효성 검사
		var accNum= document.getElementById('accNum').value;
		if (manager.remove(accNum)){
			setMessage_onTable('계좌 삭제됨');
		} else{
			setMessage_onTable('존재하지 않는 계좌번호');
		}
	}
}

//예금주명으로 찾기
function searchByName(){
	clearTable();
	hideMessages_onTable();
	if( isValidAccName() ) {//유효성 검사
		var name= document.getElementById('accName').value;
		var accs= manager.search(name);
		if(accs.length==0){
			setMessage_onTable('존재하지 않는 이름');
		} else{
			for ( var i in accs) {
				appendTable(accs[i]);
			}
		}
	}
}

//계좌 새로 만들기
function createAcc(){
	clearTable();
	hideMessages_onTable();
	
	var accType= getAccTypefromSelect();
	var accNum= document.getElementById('accNum').value;
	var name= document.getElementById('accName').value;
	var passwd= document.getElementById('passwd').value;
	var depositMoney= document.getElementById('depositMoney').value;
	var borrowMoney= document.getElementById('borrowMoney').value;
		
	//console.log(accType+" : "+accNum+" : "+name+" : "+passwd+" : "+depositMoney+" : "+borrowMoney);
	

	if (isValidAccType() && isValidAccNum() && isValidAccName()
		&& isValidPasswd() && isValidMoney()) {
	
		if(accType=='입출금'){
			var acc=new Account(accNum,name,passwd,depositMoney);
			manager.add(acc);
		}else if(accType=='마이너스'){
			var mAcc= new MinusAccount(accNum,name,passwd,depositMoney,borrowMoney);
			manager.add(mAcc);
		}
		setMessage_onTable('계좌 등록 완료');
		resetForm();
	}
}

//전체 조회
function listAllAccs(){
	clearTable();
	hideMessages_onTable();
	if(getAccTypefromSelect()== '입출금'){
		for ( var i in manager.accounts) {
			if(manager.accounts[i] instanceof MinusAccount){
				
			}else{
				appendTable(manager.accounts[i]);
			}
		}
	}else if(getAccTypefromSelect()=='마이너스'){
		for ( var i in manager.accounts) {
			if(manager.accounts[i] instanceof MinusAccount){
				appendTable(manager.accounts[i]);
			}
		}
	}else{
		//전체 출력
		for ( var i in manager.accounts) {
			appendTable(manager.accounts[i]);
		}
	}
	
}
//일반관리 창 띄우기
function setDefaultForm(){
	document.getElementById('editMoney_form').style.display='none';
	document.getElementsByName('accInputForm').item(0).style.display='block';
	
}
//입금 출금 창 띄우기
function setEditMoneyForm(){
	document.getElementById('editMoney_form').style.display='block';
	document.getElementsByName('accInputForm').item(0).style.display='none';
}

//입금출금 계좌번호 유효성 검사
function isValidNumForDW(){
	var accNum= document.getElementById('accNum_forDW').value;
	if(isEmptyTxt(accNum)){
		//console.log('계좌번호 임력하세요');
		document.getElementById('checkAccNum_id_forDW').style.visibility='visible';
		return false;
	}
	
	var reg= /^\d{3,5}-\d{3,5}-\d{3,5}$/;
	if( ! reg.test(accNum) ){
		//console.log('올바른 계좌번호를 입력하세요');
		document.getElementById('checkAccNum_id_forDW').style.visibility='visible';
		return false;
	}
	document.getElementById('checkAccNum_id_forDW').style.visibility='hidden';
	return true;
}

//입금 출금 금액 유효성 검사
function isValidMoneyForDW(){
	
	var depositMoney= document.getElementById('moeny_forDW').value;
	var positiveNum = /^\d*[^.]$/;
	
	if(isEmptyTxt(depositMoney)){
		//console.log('입금액 입력하세요');
		document.getElementById('checkMoney_id_forDW').style.visibility='visible';
		return false;
	}
	if (depositMoney <0 || !(positiveNum.test(depositMoney)) ){
		//console.log('올바른 입금액 입력하세요');
		document.getElementById('checkMoney_id_forDW').style.visibility='visible';
		return false;
	}

	document.getElementById('checkMoney_id_forDW').style.visibility='hidden';
	return true;
}

//입금하기
function depositMoney(){
	clearTable();
	if(isValidNumForDW() && isValidMoneyForDW()){
		
	var accNum= document.getElementById('accNum_forDW').value;
	var acc= manager.get(accNum);
	if(acc== null){
			setMessage_onTable('존재하지 않는 계좌번호');
		}else{
			var money= document.getElementById('moeny_forDW').value;
			for ( var i in manager.accounts) {
				if(manager.accounts[i]==acc){
					manager.accounts[i].deposit(parseInt(money));
					setMessage_onTable('입금 완료');
				}
			}
		}
	}
}

//출금하기
function withdrawMoney(){
	clearTable();
	if(isValidNumForDW() && isValidMoneyForDW()){
		
	var accNum= document.getElementById('accNum_forDW').value;
	var acc= manager.get(accNum);
	if(acc== null){
			setMessage_onTable('존재하지 않는 계좌번호');
		}else{
			var money= document.getElementById('moeny_forDW').value;
			for ( var i in manager.accounts) {
				if(manager.accounts[i]==acc){
					manager.accounts[i].withdraw(parseInt(money));
					setMessage_onTable('출금 완료');
				}
			}
		}
	}
}

