/**
 * 마이너스 계좌 객체 (Account 상속)
 */

function MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney){
	Account.call(this,accountNum, accountOwner, passwd, restMoney);
	this.borrowMoney = borrowMoney;
}

MinusAccount.bankName= Account.bankName;
MinusAccount.prototype= Object.create(Account.prototype);
MinusAccount.prototype.constructor= MinusAccount; //생성자 바꾸기

/*
MinusAccount.prototype.toString= function(){
	//오버라이딩
	return this.accountNum+"\t"+this.accountOwner+'\t'+this.passwd+'\t'+this.restMoney+'\t'+this.borrowMoney;
}
*/


