package kr.or.kosta.reservationmall.board.dto;
/**
 * Article
 * @author 이혜림
 *
 */
public class Article {

	private String id;
	private String title;
	private String contents;
	private String date;
	private String hitCount;
	private String checked;
	private String userId;
	private String boardId;
	
	
	public Article() {
	}
	
	public Article(String id, String title, String contents, String date, String hitCount, String checked,
			String userId, String boardId) {
		super();
		
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.date = date;
		this.hitCount = hitCount;
		this.checked = checked;
		this.userId = userId;
		this.boardId = boardId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHitCount() {
		return hitCount;
	}
	public void setHitCount(String hitCount) {
		this.hitCount = hitCount;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}


	
}
