package kr.or.kosta.entity;
/*
 * Account 객체 추가시 예외처리하는 클래스
 * @author 송주현 
 */

public class AccountException extends Exception {

	private int errorCode;

	public AccountException() {
		this("계좌처리중 예기치 않은 에러가 발생하였습니다.", -9);
	}

	public AccountException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
	}

}