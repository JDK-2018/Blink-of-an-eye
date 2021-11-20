import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TimeRunnables implements Runnable { // �ð��� üũ ���ִ� �Լ� 
	public JLabel timerLable; // ���ο� �󺧼���
	public int n = 0; // �ð� ����
	public TimeRunnables(JLabel timerLabel) { 
		this.timerLable = timerLabel;
	}
	public void run() {
		while(true) {
			timerLable.setText(Integer.toString(n));
			n++;
			if(timerLable.getText().equals("3")) {
				Base2 base = new Base2();
				base.DeletLabel();
			}
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}
public class Base2 extends JPanel{
	public JLabel [] label = new JLabel[5]; // �����ǿ� ������ ���� ��
	private JButton restart = new JButton("Restart"); // ������ ������ �� �ٽý����ϴ� ��ư
	private JButton [] button = new JButton[5]; // ���ڸ� Ŭ���� ��ư
	private JLabel clearlabel; // ������ Ŭ���� ���� �� ������ ��
	private JLabel timerLabel = new JLabel(); // �ð��� ������ ��
	private int index = 0; // ��ư�� Ŭ������ �� �´��� �Ǵ��� ����
	private int [] getX = new int[5]; // ó���� �����ִ� ������ x��ǥ�� ������ �迭
	private int [] getY = new int[5]; // ó���� �����ִ� ������ y��ǥ�� ������ �迭
	public int clock = 0;
	public int time = 0;
	public Base2() {
		play();
	}
	public void DeletLabel() {
		for(int i = 0; i<label.length;i++) { // �����ǿ� ������ ���ڸ� ���ϴ� ������ŭ ����(�迭�� ũ�⸸ŭ) 
			label[i].setVisible(false);
			
		}
	}
	public void play() {
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 40)); // �ð����� ����ũ��� ��Ʈ����
		this.setLayout(null); // ���̾ƿ��� �����Ͽ� ���� ���ϴ� �ڸ��� ������ �� �ְڲ� ����
		clearlabel = new JLabel("Clear!!");  // ������ Ŭ�������� �� �����ִ� ���� "Clear!!"�� ����
		this.add(clearlabel); //�����̳ʿ� ������ Ŭ�������� �� �����ִ� ���� �߰�
		this.add(timerLabel); //�����̳ʿ� �ð��� �����ִ� �� �߰�
		this.add(restart); // ����� ��ư �߰�
		restart.addActionListener(new MyActionListener()); // ActionListener ���
		clearlabel.setBounds(180,120,100,100); // Clear�� ��ġ�� ũ�⸦ ����
		clearlabel.setVisible(false); // ������ �����߿���  �Ⱥ��̰� ��
		restart.setBounds(235, 200, 100, 100); // ����� ��ư ��ġ�� ũ�⸦ ����
		restart.setVisible(false); // ����� ��ư ���� ���� �������� �� �Ⱥ��̰� ��. 
		this.setBackground(Color.BLACK); // ��׶��带 ���������� ����
		timerLabel.setForeground(Color.WHITE); // �ð� ���� ������ ������� ����
		timerLabel.setBounds(270,0,50,50); // �ð� ���� ��ġ�� ũ�� ����
		TimeRunnables runnable = new TimeRunnables(timerLabel); // Ÿ�̸� ������� ����� ��ü ����, Ÿ�̸� ���� ����� ���̺��� �����ڿ� ����
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
			this.add(label[i]); // �����̳ʿ� ���� �߰�
			
		}
		for(int i = 0; i<button.length;i++) { // ���ڸ� Ŭ���� ��ư�� ���ϴ� ������ŭ ����(�迭�� ũ�⸸ŭ)
			button[i] = new JButton(""+i); // ��ư�� ������ ��´�
			button[i].setBounds(getX[i], getY[i], 20,20); // ��ư�� ��ġ�� ũ�⸦ �����Ѵ�.
			button[i].addActionListener(new MyActionListener()); // ActionListener ���
			button[i].setForeground(new Color(0,0,0,0)); // ��ư�� ������ ������ 0���� ����(�����ϰ� �Ѵ�) 
			button[i].setBackground(Color.WHITE); // ��ư�� ������ ������� ����
			button[i].setBorderPainted(false); // ��ư�� �׵θ��� �������ش�.
			this.add(button[i]); // �����̳ʿ� ��ư�� �߰����ش�.
			button[i].setVisible(false); // ���ڰ� ������ ������ �� ���̰� �Ѵ�.
			
		}
		setSize(1200,1200); //â ũ�⸦ ����
		setVisible(true); 
		th.start(); //������ ����
		try {
			th.sleep(1000);
			for(int i = 0; i<label.length;i++) {
				label[i].setVisible(false);
			}
			for(int i = 0; i<button.length;i++) {
				button[i].setVisible(true);
			}
		}
		catch(InterruptedException e) {
			return;
		}
	}
	public void restart() {
		for(int i = 0; i<label.length;i++) {
			int x = (int)(Math.random()*255);
			int y = (int)(Math.random()*255);
			getX[i] = x;
			getY[i] = y;
			label[i].setBounds(x,y,60,60); // ������ ��ġ�� �����Ѵ�.
			label[i].setVisible(true);
		}
		for(int i = 0; i<button.length;i++) {
			button[i].setBounds(getX[i], getY[i], 20,20); // ��ư�� ��ġ�� ũ�⸦ �����Ѵ�.
			button[i].setVisible(false);
		}
		try {
			Thread.sleep(3000);
			for(int i = 0; i<label.length;i++) {
				label[i].setVisible(false);
			}
			for(int i = 0; i<button.length;i++) {
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
			for(int i = 0; i<button.length; i++) {
				if(e.getSource() == button[i]) { // ��ư�� ������ ��ư�� ������� ����
					button[i].setVisible(false);
				}
				
			}
			if(e.getSource() == restart) {
				restart.setVisible(false);
			}
			if(b.getText().equals("Restart")) { //����� ��ư�� ������ �����
				restart();

			}
			
			else if(b.getText().equals(Integer.toString(index))) { // ��ư�� ������ ���� ���
				label[index].setVisible(true); // index�� ó���� 0�̹Ƿ� 0�� ��ư�� �����ٸ� ���� ���� �ٽ� ������
				index++; // �׸��� �ε����� 1����
				if(index == 5) { // ��� ������
					for(int i =0; i<label.length;i++) { //ȭ�鿡 ������ ����
						label[i].setVisible(false); 
						timerLabel.setVisible(false);
					}
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

}

