import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

public class ContainerExample {

	public static void main(String[] args) {
		Frame owner= new Frame();
		owner.setSize(400,200);
		owner.setVisible(true);
		
		Dialog dialog= new Dialog(owner, "타이틀", false); //단독으로는 생성불가 
		dialog.setSize(200, 200);
		dialog.setVisible(true);
		
		Window window = new Window(owner); //단독으로는 생성불가
		window.setSize(100,200);
		window.setVisible(true);
		
		FileDialog fDialog=new FileDialog(owner,"파일 열기", FileDialog.LOAD);//Dialog에서 확장됨 (자식)
		fDialog.setVisible(true); //setSize는 없음
	}

}
