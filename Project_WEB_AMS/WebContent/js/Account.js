/**
 * 입출금 계좌 객체
 */


function Account(accountNum, accountOwner, passwd, restMoney){
	this.accountNum= accountNum;
	this.accountOwner= accountOwner;
	this.passwd= passwd;
	this.restMoney= restMoney;
}

Account.bankName= 'KOSTA은행';

//프로토타입에 메소드 저장
Account.prototype.deposit= function(money){
	if(money<=0){
		//입금 금액 음수 불가
	}
	var res=parseInt(money+this.restMoney);
	this.restMoney=res;
	//this.restMoney +=money;
}

Account.prototype.withdraw= function(money){
	if(money<=0){
		//출금 금액 음수 불가
	}
	this.restMoney -=money;
}

Account.prototype.checkPasswd= function(passwd){
	return this.passwd==passwd;
}

Account.prototype.toString= function(){
	var output = '';
	for ( var key in this) {
		
		if(!(key in Account.prototype)){
			output += key + ':'+this[key] +'\t';
		}
	}
	return output;
	//return this.accountNum+"\t"+this.accountOwner+'\t'+this.passwd+'\t'+this.restMoney;
}

Account.prototype.checkAccountNum= function(accountNum){
	return this.accountNum==accountNum;
}