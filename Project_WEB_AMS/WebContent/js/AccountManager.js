/**
 * 은행 계좌 관리 
 */

function AccountManager(){
	this.accounts= new Array(); //계좌 저장하는 배열
	
}

//계좌를 새로 생성해서 추가
AccountManager.prototype.add= function(account){
	
	//이미 등록된 계좌번호 예외처리
	for ( var i in this.accounts) {
		if(this.accounts[i].accountNum == account.accountNum){
			//중복 계좌번호
			console.log('중복계좌번호');
			return;
		}
	}
	this.accounts.push(account);
}

//현재 저장된 계좌 목록 정렬해서 리턴
AccountManager.prototype.list= function(){
	this.accounts.sort;
	return this.accounts;
}

//계좌번호로 계좌 검색
AccountManager.prototype.get= function(accountNum){
	for ( var i in this.accounts) {
		if(this.accounts[i].accountNum == accountNum){
			return this.accounts[i];
		}
	}
	//없는 계좌번호 예외처리
}

//예금주명으로 계좌 검색 (중복검색 처리)
AccountManager.prototype.search= function(name){
	var accs=new Array();
	for ( var i in this.accounts) {
		if(this.accounts[i].accountOwner== name){
			accs.push(this.accounts[i]);
		}
	}
	if(accs.length==0){
		//해당 이름이 없음 예외처리
	}
	return accs;
}

//계좌번호로 삭제하기 
AccountManager.prototype.remove= function(accountNum){
	for ( var i in this.accounts) {
		if(this.accounts[i].accountNum== accountNum){
			this.accounts.splice(i,1);
			return true;
		}
	}
	return false;
}