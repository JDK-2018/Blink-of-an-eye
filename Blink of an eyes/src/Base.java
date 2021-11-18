import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class TimeRunnable implements Runnable { // 시간을 체크 해주는 함수 
	private JLabel timerLable; // 새로운 라벨선언
	public int n = 0; // 시간 변수
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
	private JLabel [] label = new JLabel[5]; // 격자판에 보여줄 숫자 라벨
	private JButton restart = new JButton("Restart"); // 게임이 끝났을 때 다시시작하는 버튼
	private JButton [] button = new JButton[5]; // 숫자를 클릭할 버튼
	private JLabel clearlabel; // 게임을 클리어 했을 때 보여줄 라벨
	private JLabel timerLabel = new JLabel(); // 시간을 보여줄 라벨
	Container c= getContentPane(); // 컨테이너 생성
	private int index = 0; // 버튼을 클릭했을 때 맞는지 판단할 변수
	private int [] getX = new int[5]; // 처음에 보여주는 숫자의 x좌표를 저장할 배열
	private int [] getY = new int[5]; // 처음에 보여주는 숫자의 y좌표를 저장할 배열
	public Base() {

		this.setTitle("Base"); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(getOwner());
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 40)); // 시간라벨의 글자크기와 폰트설정
		c.setLayout(null); // 레이아웃을 설정하여 내가 원하는 자리에 설정할 수 있겠끔 했음
		clearlabel = new JLabel("Clear!!");  // 게임을 클리어했을 때 보여주는 라벨을 "Clear!!"로 설정
		c.add(clearlabel); //컨테이너에 게임을 클리어했을 때 보여주는 라벨을 추가
		c.add(timerLabel); //컨테이너에 시간을 보여주는 라벨 추가
		c.add(restart); // 재시작 버튼 추가
		restart.addActionListener(new MyActionListener()); // ActionListener 사용
		clearlabel.setBounds(180,120,100,100); // Clear의 위치와 크기를 설정
		clearlabel.setVisible(false); // 게임이 진행중에는  안보이게 함
		restart.setBounds(235, 200, 100, 100); // 재시작 버튼 위치와 크기를 설정
		restart.setVisible(false); // 재시작 버튼 또한 게임 진행중일 땐 안보이게 함. 
		c.setBackground(Color.BLACK); // 백그라운드를 검은색으로 설정
		timerLabel.setForeground(Color.WHITE); // 시간 라벨의 색상을 흰색으로 설정
		timerLabel.setBounds(270,0,50,50); // 시간 라벨의 위치와 크기 설정
		TimeRunnable runnable = new TimeRunnable(timerLabel); // 타이머 스레드로 사용할 객체 생성, 타이머 값을 출력할 레이블을 생성자에 전달
		Thread th = new Thread(runnable); // 스레드 객체 생성
		
		for(int i = 0; i<label.length;i++) { // 격자판에 보여줄 숫자를 원하는 갯수만큼 생성(배열의 크기만큼) 
			int x = (int)(Math.random()*255); // x의 값을 랜덤으로 받음
			int y = (int)(Math.random()*255); // y의 값을 랜덤으로 받음
			getX[i] = x; // 숫자들의 x좌표들을 배열에 저장
			getY[i] = y; // 숫자들의 y좌표들을 배열에 저장
			label[i] = new JLabel(Integer.toString(i)); // i가 int형이어서 문자열로 바꾸고 이름을 저장
			label[i].setBounds(x,y,60,60); // 숫자의 위치를 설정한다.
			label[i].setForeground(Color.WHITE); // 숫자의 색상을 흰색으로 설정
			label[i].setFont(new Font("Gothic", Font.ITALIC, 25)); // 숫자의 폰트와 크기 설정 
			c.add(label[i]); // 컨테이너에 숫자 추가
			
		}
		for(int i = 0; i<button.length;i++) { // 숫자를 클릭할 버튼을 원하는 갯수만큼 생성(배열의 크기만큼)
			button[i] = new JButton(""+i); // 버튼의 정보를 담는다
			button[i].setBounds(getX[i], getY[i], 20,20); // 버튼의 위치와 크기를 설정한다.
			button[i].addActionListener(new MyActionListener()); // ActionListener 사용
			button[i].setForeground(new Color(0,0,0,0)); // 버튼의 글자의 투명도를 0으로 설정(투명하게 한다) 
			button[i].setBackground(Color.WHITE); // 버튼의 색상을 흰색으로 설정
			button[i].setBorderPainted(false); // 버튼의 테두리를 제거해준다.
			c.add(button[i]); // 컨테이너에 버튼을 추가해준다.
			button[i].setVisible(false); // 숫자가 없어질 때까지 안 보이게 한다.
			
		}
		setSize(1200,1200); //창 크기를 설정
		setVisible(true); 
		
		th.start(); //스레드 시작
		try { // 3초 동안 글자를 보이게 해주고, 3초 후 사라지며 버튼이 나오게 해준다
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
	private class MyActionListener implements ActionListener{ //ActionListener 클래스 
		
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource(); // 
			Restart a = new Restart();
			for(int i = 0; i<button.length; i++) {
				if(e.getSource() == button[i]) { // 버튼을 누르면 버튼이 사라지게 만듦
					button[i].setVisible(false);
				}
				
			}
			if(b.getText().equals("Restart")) { //재시작 버튼을 누르면 재시작
				a.restart();
			}
			
			else if(b.getText().equals(Integer.toString(index))) { // 버튼이 누른게 같을 경우
				label[index].setVisible(true); // index가 처음은 0이므로 0인 버튼을 누른다면 숫자 라벨을 다시 보여줌
				index++; // 그리고 인덱스를 1증가
				if(index == 5) { // 모두 맞춘경우
					for(int i =0; i<label.length;i++) { //화면에 모든것을 끈다
						label[i].setVisible(false); 
						timerLabel.setVisible(false);
					}
					c.setBackground(Color.GRAY); // 백그라운드를 회색으로 설정
					clearlabel.setVisible(true); // 게임 클리어 문구 표시
				}
			}
			else { //만약 틀린경우 화면에 모든 것을 끄고 재시작 버튼 표시
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