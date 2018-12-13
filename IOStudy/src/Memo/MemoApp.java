package Memo;

import java.io.FileNotFoundException;

public class MemoApp {

	public static void main(String[] args) throws FileNotFoundException {
		MemoUI memoUI= new MemoUI();
		FileDao fileDao = new FileDao();
		memoUI.setFileDao(fileDao);
		
		memoUI.setContents();
		memoUI.eventRegist();
		memoUI.setSize(600,500);
		memoUI.setVisible(true);
	}

}
