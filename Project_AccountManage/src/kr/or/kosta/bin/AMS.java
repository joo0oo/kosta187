package kr.or.kosta.bin;

import kr.or.kosta.boundary.AMSViewFrame;
import kr.or.kosta.entity.AccountManager;

/**
 * 
 * 은행 계좌 관리 애플리케이션
 * 
 * @author 송주현
 *
 */
public class AMS {

	public static void main(String[] args) {
		AccountManager manager = new AccountManager(100);
		AMSViewFrame amsFrame = new AMSViewFrame();
		amsFrame.setAccountManager(manager);

		amsFrame.setContents();
		amsFrame.eventRegist();

		amsFrame.setSize(700, 600);
		amsFrame.setVisible(true);

	}

}
