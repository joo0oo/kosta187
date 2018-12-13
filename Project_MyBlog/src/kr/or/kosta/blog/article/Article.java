package kr.or.kosta.blog.article;
/*
 * 게시글 정보 저장하는 객체
 */
public class Article {
	
	private int article_id; //게시글 식별번호 PK sq
	private int board_id; //소속 게시판 번호  Default NN
	private String writer; //작성자 아이디 NN
	private String subject; //게시글 제목 NN
	private String content; //게시글 내용 NN
	private String regdate; //게시글 등록일자 Default
	private int hitCount; //게시글 조회수 Default
	private String ip; //작성자 아이피 NN
	private String passwd; //게시글 비밀번호 NN
	private String attachFile;// 첨부파일
	private int groupNum;  //계층형 게시판 구조를 위한 게시글 그룹번호 NN sq
	private int levelNum; //계층형 게시판 구조를 위한 그룹내 게시글 레벨 NN
	private int orderNum; //계층형 게시판 구조를 위한 그룹내 게시글 순서 NN
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(int article_id, int board_id, String writer, String subject, String content, String regdate,
			int hitCount, String ip, String passwd, String attachFile, int groupNum, int levelNum, int orderNum) {
		super();
		this.article_id = article_id;
		this.board_id = board_id;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.hitCount = hitCount;
		this.ip = ip;
		this.passwd = passwd;
		this.attachFile = attachFile;
		this.groupNum = groupNum;
		this.levelNum = levelNum;
		this.orderNum = orderNum;
	}
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
	/**
	 * ip주소 보안처리
	 * @return 뒷자리 가려진 ip
	 */
	public String getIp() { 
		String[] IPs= this.ip.split("\\.");
		String secureIP="";
		for(int i=0; i<IPs.length; i++) {
			if(i >= IPs.length-2) {
				secureIP += "xxx";
			} else {
				secureIP+= IPs[i];
			} 
			
			if(i != IPs.length-1) {
				secureIP += '.';
			}
		}
		return secureIP;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	public int getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}
	public int getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", board_id=" + board_id + ", writer=" + writer + ", subject="
				+ subject + ", content=" + content + ", regdate=" + regdate + ", hitCount=" + hitCount + ", ip=" + ip
				+ ", passwd=" + passwd + ", attachFile=" + attachFile + ", groupNum=" + groupNum + ", levelNum="
				+ levelNum + ", orderNum=" + orderNum + "]";
	}

	
}
