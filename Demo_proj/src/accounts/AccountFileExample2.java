package accounts;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccountFileExample2 {
	
	static final String path = "accounts2.dat";
	
	public static void main(String[] args) throws IOException {
		// 계좌정보 파일 저장 테스트
		Account account= new Account("1111-2222-3333", "김기정", 1111, 1000000);
		MinusAccount maccount= new MinusAccount("2222-2222-3333", "김대출", 1111, 1000000, 10000000);
		
		// 자바 데이터타입별로 저장
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		
		out.writeUTF(account.getAccountNum());
		out.writeUTF(account.getAccountOwner());
		out.writeInt(account.getPasswd());
		out.writeLong(account.getRestMoney());
		out.writeLong(0L);
		
		out.writeUTF(maccount.getAccountNum());
		out.writeUTF(maccount.getAccountOwner());
		out.writeInt(maccount.getPasswd());
		out.writeLong(maccount.getRestMoney());
		out.writeLong(maccount.getBorrowMoney());
		out.close();
		
		/*
		 * TXT가 아니라 Byte로 저장해야 하는 이유 : 보안의 문제 
		 * TXT로 저장하면 아무나 접근해서 데이터를 읽을 수 있기 때문
		 * 
		 * 문제1> byte 단위로 파일을 쓰면 일렬로 나열되어 저장됨 : String타입이 아니므로 각 레코드의 구분이 불가능
		 * 해결 : 각 레코드 단위의 용량을 미리 설정해둔다
		 * 단 writeUTF()는 가변형 데이터를 받기 때문에(입력에 따라 용량이 달라짐) writeChar()를 사용해야 미리 용량을 설정해둘수 있음
		 * 예를 들어 각 레코드를 80byte로 설정해두면 (계좌번호 40byte, 이름 20byte, 비밀번호 4byte, 예금 8byte, 대출금 8byte)
		 * 나중에 파일에 접근해서 데이터를 검색할 수 있음 (각 데이터 구분 가능)
		 * 
		 * 문제2> 파일에 접근해서 데이터를 검색할 때 순차접근이므로 비효율적
		 * 해결 : 일렬 데이터 레코드에 임의 접근이 가능하게 한다 (Buffer 사용)
		 */
		
		
		// 계좌정보 파일 읽기 테스트
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		String num = in.readUTF();
		String owner = in.readUTF();
		int passwd = in.readInt();
		long restMoney = in.readLong();
		long borrowMoney = in.readLong();
		
		System.out.println(num);
		System.out.println(owner);
		System.out.println(passwd);
		System.out.println(restMoney);
		System.out.println(borrowMoney);
		
		num = in.readUTF();
		owner = in.readUTF();
		passwd = in.readInt();
		restMoney = in.readLong();
		borrowMoney = in.readLong();
		
		System.out.println(num);
		System.out.println(owner);
		System.out.println(passwd);
		System.out.println(restMoney);
		System.out.println(borrowMoney);
		
		in.close();

	}

}
