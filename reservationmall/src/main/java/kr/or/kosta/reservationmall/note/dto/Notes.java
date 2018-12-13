package kr.or.kosta.reservationmall.note.dto;
/**
 * Notes 쪽지 보내기 
 * @author 이혜림
 *
 */
public class Notes {
	private String note_id;
	private String user_id;
	private String note_email;
	private String note_question;
	private String note_answer;
	private String note_date;
	private String note_checked;
	
	public Notes(String note_id, String user_id, String note_email, String note_question, String note_answer,
			String note_date, String note_checked) {
		super();
		this.note_id = note_id;
		this.user_id = user_id;
		this.note_email = note_email;
		this.note_question = note_question;
		this.note_answer = note_answer;
		this.note_date = note_date;
		this.note_checked = note_checked;
	}
	
	
	public Notes() {
		super();
	}


	public String getNote_id() {
		return note_id;
	}
	public void setNote_id(String note_id) {
		this.note_id = note_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNote_email() {
		return note_email;
	}
	public void setNote_email(String note_email) {
		this.note_email = note_email;
	}
	public String getNote_question() {
		return note_question;
	}
	public void setNote_question(String note_question) {
		this.note_question = note_question;
	}
	public String getNote_answer() {
		return note_answer;
	}
	public void setNote_answer(String note_answer) {
		this.note_answer = note_answer;
	}
	public String getNote_date() {
		return note_date;
	}
	public void setNote_date(String note_date) {
		this.note_date = note_date;
	}
	public String getNote_checked() {
		return note_checked;
	}
	public void setNote_checked(String note_checked) {
		this.note_checked = note_checked;
	}
	@Override
	public String toString() {
		return "Notes [note_id=" + note_id + ", user_id=" + user_id + ", note_email=" + note_email + ", note_question="
				+ note_question + ", note_answer=" + note_answer + ", note_date=" + note_date + ", note_checked="
				+ note_checked + "]";
	}
}
