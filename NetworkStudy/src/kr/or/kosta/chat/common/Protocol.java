package kr.or.kosta.chat.common;

/**
 * 문자열을 서버-클라이언트에 주고받을 때 필요한 구분자 (프로토콜)
 * 문자열 파싱할때 유용하게 사용됨
 * @author 송주현
 *
 */
public interface Protocol {
	
	public static final String DELEMETER= ","; //구분자
	
	public static final int CONNECT = 1000; //최초 연결 (닉네임)
	public static final int CONNECT_RESULT = 1001; //서버-클라이언트 연결 잘 되었는지 확인
	public static final int GET_USERLIST=1002; //존재하는 유저리스트 리턴
	//public static final int SET_MYNAME=1003; //내 이름 리스트에 추가하기
	
	
	public static final int MULTI_CHAT = 2000; //채팅 메세지
	public static final int DISCONNECT= 3000; //연결 끊기 
	

}
