package kr.or.kosta.chat.client;

public class kotalk {

	public static void main(String[] args) {
		
		ChatFrame frame=new ChatFrame("::: kotalk :::");		
		ChatClient chatClient = new ChatClient(frame);
		
		frame.setContents();
		frame.setSize(400,600);
		frame.setCenter();
		frame.eventRegist();
		
		frame.setChatClient(chatClient);
		
		frame.setVisible(true);
	}

}
