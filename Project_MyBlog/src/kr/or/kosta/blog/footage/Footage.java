package kr.or.kosta.blog.footage;
/**
 * 방명록 정보 저장 객체
 * @author 송주현
 *
 */
public class Footage {
	
    private int gestbook_id;
	private String userID;
	private String contents;
	private String regdate;
	
	public Footage() {
		super();
	}

	public Footage(int gestbook_id, String userID, String contents, String regdate) {
		super();
		this.gestbook_id = gestbook_id;
		this.userID = userID;
		this.contents = contents;
		this.regdate = regdate;
	}

	public int getGestbook_id() {
		return gestbook_id;
	}

	public void setGestbook_id(int gestbook_id) {
		this.gestbook_id = gestbook_id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Footage [gestbook_id=" + gestbook_id + ", userID=" + userID + ", contents=" + contents + ", regdate="
				+ regdate + "]";
	}
	
}
