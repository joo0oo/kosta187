package kr.or.kosta.reservationmall.individual.service;



import kr.or.kosta.reservationmall.individual.dao.UserDao;
import kr.or.kosta.reservationmall.login.dto.User;


public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void createUser(User user) throws Exception {
		//회원가입
		userDao.create(user);
	}

	@Override
	public void deleteUser(String user_id) throws Exception {
		//회원탈퇴
		userDao.delete(user_id);
	}

	@Override
	public void updateUser(User user) throws Exception{
		//회원정보수정
		userDao.update(user);
		
	}

	@Override
	public User searchById(String id) throws Exception {
		//아이디로 회원 찾기
		return userDao.searchById(id);
	}

	@Override
	public User searchByEmail(String email) throws Exception {
		//이메일로 회원 찾기
		return userDao.searchByEmail(email);
	}
	


}





