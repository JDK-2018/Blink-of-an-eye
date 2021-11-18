import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TimeRunnable implements Runnable { // �ð��� üũ ���ִ� �Լ� 
	private JLabel timerLable; // ���ο� �󺧼���
	public int n = 0; // �ð� ����
	public TimeRunnable(JLabel timerLabel) { 
		this.timerLable = timerLabel;
	}
	public void run() {
		while(true) {
			timerLable.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}
public class Base extends JFrame{
	private JLabel [] label = new JLabel[5]; // �����ǿ� ������ ���� ��
	private JButton restart = new JButton("Restart"); // ������ ������ �� �ٽý����ϴ� ��ư
	private JButton [] button = new JButton[5]; // ���ڸ� Ŭ���� ��ư
	private JLabel clearlabel; // ������ Ŭ���� ���� �� ������ ��
	private JLabel timerLabel = new JLabel(); // �ð��� ������ ��
	Container c= getContentPane(); // �����̳� ����
	private int index = 0; // ��ư�� Ŭ������ �� �´��� �Ǵ��� ����
	private int [] getX = new int[5]; // ó���� �����ִ� ������ x��ǥ�� ������ �迭
	private int [] getY = new int[5]; // ó���� �����ִ� ������ y��ǥ�� ������ �迭
	public Base() {

		this.setTitle("Base"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 40)); // �ð����� ����ũ��� ��Ʈ����
		c.setLayout(null); // ���̾ƿ��� �����Ͽ� ���� ���ϴ� �ڸ��� ������ �� �ְڲ� ����
		clearlabel = new JLabel("Clear!!");  // ������ Ŭ�������� �� �����ִ� ���� "Clear!!"�� ����
		c.add(clearlabel); //�����̳ʿ� ������ Ŭ�������� �� �����ִ� ���� �߰�
		c.add(timerLabel); //�����̳ʿ� �ð��� �����ִ� �� �߰�
		c.add(restart); // ����� ��ư �߰�
		restart.addActionListener(new MyActionListener()); // ActionListener ���
		clearlabel.setBounds(180,120,100,100); // Clear�� ��ġ�� ũ�⸦ ����
		clearlabel.setVisible(false); // ������ �����߿���  �Ⱥ��̰� ��
		restart.setBounds(235, 200, 100, 100); // ����� ��ư ��ġ�� ũ�⸦ ����
		restart.setVisible(false); // ����� ��ư ���� ���� �������� �� �Ⱥ��̰� ��. 
		c.setBackground(Color.BLACK); // ��׶��带 ���������� ����
		timerLabel.setForeground(Color.WHITE); // �ð� ���� ������ ������� ����
		timerLabel.setBounds(270,0,50,50); // �ð� ���� ��ġ�� ũ�� ����
		TimeRunnable runnable = new TimeRunnable(timerLabel); // Ÿ�̸� ������� ����� ��ü ����, Ÿ�̸� ���� ����� ���̺��� �����ڿ� ����
		Thread th = new Thread(runnable); // ������ ��ü ����
		
		for(int i = 0; i<label.length;i++) { // �����ǿ� ������ ���ڸ� ���ϴ� ������ŭ ����(�迭�� ũ�⸸ŭ) 
			int x = (int)(Math.random()*255); // x�� ���� �������� ����
			int y = (int)(Math.random()*255); // y�� ���� �������� ����
			getX[i] = x; // ���ڵ��� x��ǥ���� �迭�� ����
			getY[i] = y; // ���ڵ��� y��ǥ���� �迭�� ����
			label[i] = new JLabel(Integer.toString(i)); // i�� int���̾ ���ڿ��� �ٲٰ� �̸��� ����
			label[i].setBounds(x,y,60,60); // ������ ��ġ�� �����Ѵ�.
			label[i].setForeground(Color.WHITE); // ������ ������ ������� ����
			label[i].setFont(new Font("Gothic", Font.ITALIC, 25)); // ������ ��Ʈ�� ũ�� ���� 
			c.add(label[i]); // �����̳ʿ� ���� �߰�
			
		}
		for(int i = 0; i<button.length;i++) { // ���ڸ� Ŭ���� ��ư�� ���ϴ� ������ŭ ����(�迭�� ũ�⸸ŭ)
			button[i] = new JButton(""+i); // ��ư�� ������ ��´�
			button[i].setBounds(getX[i], getY[i], 20,20); // ��ư�� ��ġ�� ũ�⸦ �����Ѵ�.
			button[i].addActionListener(new MyActionListener()); // ActionListener ���
			button[i].setForeground(new Color(0,0,0,0)); // ��ư�� ������ ������ 0���� ����(�����ϰ� �Ѵ�) 
			button[i].setBackground(Color.WHITE); // ��ư�� ������ ������� ����
			button[i].setBorderPainted(false); // ��ư�� �׵θ��� �������ش�.
			c.add(button[i]); // �����̳ʿ� ��ư�� �߰����ش�.
			button[i].setVisible(false); // ���ڰ� ������ ������ �� ���̰� �Ѵ�.
			
		}
		setSize(1200,1200); //â ũ�⸦ ����
		setVisible(true); 
		
		th.start(); //������ ����
		try { // 3�� ���� ���ڸ� ���̰� ���ְ�, 3�� �� ������� ��ư�� ������ ���ش�
			for(int i = 0; i<label.length;i++) {
				label[i].setVisible(true);
			}
			th.sleep(3000);
			for(int i = 0; i<label.length;i++) {
				label[i].setVisible(false);
			}
			for(int i =0;i<button.length;i++) {
				button[i].setVisible(true);
			}
		}
		catch(InterruptedException e) {
			return;
		}
	}
	private class MyActionListener implements ActionListener{ //ActionListener Ŭ���� 
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); // 
			Restart a = new Restart();
			for(int i = 0; i<button.length; i++) {
				if(e.getSource() == button[i]) { // ��ư�� ������ ��ư�� ������� ����
					button[i].setVisible(false);
				}
				
			}
			if(b.getText().equals("Restart")) { //����� ��ư�� ������ �����
				a.restart();
			}
			
			else if(b.getText().equals(Integer.toString(index))) { // ��ư�� ������ ���� ���
				label[index].setVisible(true); // index�� ó���� 0�̹Ƿ� 0�� ��ư�� �����ٸ� ���� ���� �ٽ� ������
				index++; // �׸��� �ε����� 1����
				if(index == 5) { // ��� ������
					for(int i =0; i<label.length;i++) { //ȭ�鿡 ������ ����
						label[i].setVisible(false); 
						timerLabel.setVisible(false);
					}
					c.setBackground(Color.GRAY); // ��׶��带 ȸ������ ����
					clearlabel.setVisible(true); // ���� Ŭ���� ���� ǥ��
				}
			}
			else { //���� Ʋ����� ȭ�鿡 ��� ���� ���� ����� ��ư ǥ��
				for(int i=0; i<button.length;i++) {
					button[i].setVisible(false);
				}
				for(int i =0;i<label.length;i++) {
					label[i].setVisible(false);
				}
				timerLabel.setVisible(false);
				restart.setVisible(true);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Base();
	}
}

class Restart {
	public void restart() {
		
	}
}