package kr.or.kosta.reservationmall.login.service;



import kr.or.kosta.reservationmall.login.dao.LoginDao;


public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;
	
	public LoginDao getloginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	@Override
	public Boolean checkLogin_hjh(String id, String pw) throws Exception {
		return loginDao.checkLogin_hjh(id, pw);
	}

	@Override
	public Boolean isWithdrawal_sjh(String id) throws Exception {
		return loginDao.isWithdrawal_sjh(id);
	}


}





