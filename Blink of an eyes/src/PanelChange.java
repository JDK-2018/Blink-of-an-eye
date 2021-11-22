import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PanelChange extends JFrame{
	public Base jpanel1 = null; // Base 클래스의 객체 생성
	public Base1 jpanel2 = null; // Base1 클래스의 객체 생성
	public MainManu jpanel3 = null; // 메인메뉴 클래스 객체 생성
	
	public void change(String panelName) { //패널을 바꿔주는 함수
		if(panelName.equals("jpanel1")) { // 만약 paneName이 "jpanel1"이면 원래 패널 삭제 후, Base패널을 넣는다
			getContentPane().removeAll();
			getContentPane().add(jpanel1);
			revalidate();
			repaint();
		}
		else if(panelName.equals("jpanel2")){ // 만약 paneName이 "jpanel2"이면 원래 패널 삭제 후, Base1패널을 넣는다
			getContentPane().removeAll();
			getContentPane().add(jpanel2);
			revalidate();
			repaint();
		}

	}
	public static void main(String[] args) {

		PanelChange win = new PanelChange();
		
		win.setTitle("start");
		win.jpanel3 = new MainManu(win);
		win.add(win.jpanel3);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(1920,1080);
		win.setVisible(true);
		
	}

}
