import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameFrame extends Frame implements Runnable {
	
	int x=50, distance = 5;
	Image unit;
	Toolkit toolkit;
	
	public GameFrame (String title) {
		super(title);
		toolkit= Toolkit.getDefaultToolkit();
		unit= Toolkit.getDefaultToolkit().getImage("./src/Mushroom.png");
	}
	
	public void setContents() {
		
	}
	
	
	public void eventRegist() {
		addWindowListener( new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				gameStart();
			}
		});
	}
	
	public void gameStart() {
		Thread thread= new Thread(this); 
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) {
	//	g.fillOval(x, 50, 80, 80);
	//	g.drawImage(unit, x, 50, this);
		g.drawImage(unit, x, 50, 70, 70, this);
		toolkit.beep();
		System.out.println("paint called");
	}
	
	/*
	@Override
	public void update(Graphics g) {
		//super.update(g);
		paint(g);
		System.out.println("update called");
	}
*/
	
	@Override
	public void run() {
		Random random= new Random();
		while (true) {
			x  += distance; //좌표값 바꾸고
			repaint();//원 다시 그리기
			try {
				Thread.sleep(random.nextInt(200));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
