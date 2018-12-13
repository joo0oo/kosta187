package kr.or.kosta.reservationmall.board.dto;
/**
 * Board 추가 
 * @author 이혜림
 *
 */
public class Board {

	private String id;
	private String name;
	private String info;
	
	public Board() {
		super();
	}

	public Board(String id, String name, String info) {
		super();
		this.id = id;
		this.name = name;
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	
	
}
