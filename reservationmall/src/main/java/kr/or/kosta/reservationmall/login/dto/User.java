package kr.or.kosta.reservationmall.login.dto;

public class User {
	
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_age;
	private String user_address;
	private String user_phonenum;
	private String user_email;
	private String user_rate;
	private String user_regdate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String user_id, String user_pw, String user_name, String user_age, String user_address,
			String user_phonenum, String user_email, String user_rate, String user_regdate) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_age = user_age;
		this.user_address = user_address;
		this.user_phonenum = user_phonenum;
		this.user_email = user_email;
		this.user_rate = user_rate;
		this.user_regdate = user_regdate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_age() {
		return user_age;
	}

	public void setUser_age(String user_age) {
		this.user_age = user_age;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_phonenum() {
		return user_phonenum;
	}

	public void setUser_phonenum(String user_phonenum) {
		this.user_phonenum = user_phonenum;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_rate() {
		return user_rate;
	}

	public void setUser_rate(String user_rate) {
		this.user_rate = user_rate;
	}

	public String getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(String user_regdate) {
		this.user_regdate = user_regdate;
	}
	
	
	
	
	
	
}
