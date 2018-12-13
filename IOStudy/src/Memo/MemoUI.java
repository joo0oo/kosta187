package Memo;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MemoUI extends Frame {
	
	MenuBar menuBar;
	Menu fileM,fontSizeM;
	MenuItem newMI, openMI, saveMI, exitMI, size10MI,size20MI,size30MI,size40MI; 
	TextArea memoTA;
	
	FileDao fileDao;
	
	public MemoUI() {
		this("제목 없음 - 메모장 ");
	}
	
	public MemoUI(String title) {
		super(title);
		
		menuBar=new MenuBar(); //메뉴를 담기위한 컨테이너
		fileM=new Menu("파일");
		newMI = new MenuItem("새로만들기");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_N));
		openMI= new MenuItem("열기");
		openMI.setShortcut(new MenuShortcut(KeyEvent.VK_O));
		saveMI= new MenuItem("저장");
		saveMI.setShortcut(new MenuShortcut(KeyEvent.VK_S));
		exitMI= new MenuItem("종료");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_X)); //단축키만 정해두고 아직 이벤트 처리를 안한 상태
		
		fontSizeM=new Menu("글자크기");
		size10MI=new MenuItem("10 size");
		size20MI=new MenuItem("20 size");
		size30MI=new MenuItem("30 size");
		size40MI=new MenuItem("40 size");
		
		memoTA=new TextArea();
	}
	
	public void setFileDao(FileDao fileDao) {
		this.fileDao = fileDao;
	}

	public void setContents() {
		setMenuBar(menuBar);
		menuBar.add(fileM);
		fileM.add(newMI);
		fileM.add(openMI);
		fileM.add(saveMI);
		fileM.add(exitMI);
		
		menuBar.add(fontSizeM);
		fontSizeM.add(size10MI);
		fontSizeM.add(size20MI);
		fontSizeM.add(size30MI);
		fontSizeM.add(size40MI);
		
		memoTA.setFont(new Font("돋움",Font.BOLD,15));
		add(memoTA,BorderLayout.CENTER);
	}
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	public void eventRegist() {
		
		//프레임의 x버튼으로 창끄기
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		
		//메뉴에서 [종료]눌러서 창끄기		
		exitMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				finish();
			}
		});
		
		//새로만들기 (textArea 리셋)
		newMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setText("");
			}
		});
		
		//불러오기
		openMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					openTXT();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "파일명 다시 확인하세요");
				}
			}
		});
		
		
		//저장하기 
		saveMI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveTXT();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "파일명 다시 확인하세요");
				}
			}
		});
		
		
		//글자크기 변경
		size10MI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setFont(new Font("돋움",Font.BOLD,10));
			}
		});
		size20MI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setFont(new Font("돋움",Font.BOLD,20));
			}
		});
		size30MI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setFont(new Font("돋움",Font.BOLD,30));
			}
		});
		size40MI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoTA.setFont(new Font("돋움",Font.BOLD,40));
			}
		});
	}
	
	public void saveTXT() throws IOException {
		FileDialog fd= new FileDialog(this, "저장", FileDialog.SAVE);
		fd.setVisible(true);
		String dir=fd.getDirectory();
		String title=fd.getFile();
		String context=memoTA.getText();
		
		fileDao.saveTXT(dir,title,context);
	}
	
	public void openTXT() throws IOException {
		FileDialog fd= new FileDialog(this, "열기", FileDialog.LOAD);
		fd.setVisible(true);
		String dir=fd.getDirectory();
		String title=fd.getFile();
	
		String txt= fileDao.openTXT(dir,title);
		memoTA.setText(txt);
	}

}
