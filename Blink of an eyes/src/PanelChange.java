import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class PanelChange extends JFrame{
	public Base jpanel1 = null; // Base Ŭ������ ��ü ����
	public Base1 jpanel2 = null; // Base1 Ŭ������ ��ü ����
	public MainManu jpanel3 = null; // ���θ޴� Ŭ���� ��ü ����
	
	public void change(String panelName) { //�г��� �ٲ��ִ� �Լ�
		if(panelName.equals("jpanel1")) { // ���� paneName�� "jpanel1"�̸� ���� �г� ���� ��, Base�г��� �ִ´�
			getContentPane().removeAll();
			getContentPane().add(jpanel1);
			revalidate();
			repaint();
		}
		else if(panelName.equals("jpanel2")){ // ���� paneName�� "jpanel2"�̸� ���� �г� ���� ��, Base1�г��� �ִ´�
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
