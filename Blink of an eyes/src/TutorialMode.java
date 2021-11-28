import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import static java.lang.Thread.*;

public class TutorialMode extends GameBoardPanel {
    private boolean buttonEnable = false;
    private boolean NextbuttonEnable = true;
    private boolean PlayEnable = false;
    private  int maxNumber = 5;
    private  int nowNumber = 1;
    private int[][] board = new int[5][5];
    private JLabel explain1Label;
    private JButton nextButton;
    private int chk= 0;
    private int[] chknum1 = new int[5];
    private int[] chknum2 = new int[5];
    private Timer timer = new Timer();
    MainMenuGo MainMenuGo = new MainMenuGo();

    public TutorialMode() {
        super();
        MainMenuGo.setLocation(0,0);
        MainMenuGo.setVisible(false);
        this.add(MainMenuGo);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = 0;
                rightPanel.boardPanel.buttons[i][j].addActionListener(new GameBoardButtonActionListener(i, j));
            }
        }
        explain1Label = new JLabel("<html><body style='text-align:center;'>튜토리얼에 오신것을<br>환영합니다!</body></html>");
        explain1Label.setFont(new Font("한초롬바탕", Font.PLAIN, 30));
        explain1Label.setForeground(Color.WHITE);
        explain1Label.setPreferredSize(new Dimension(360, 500));
        explain1Label.setHorizontalAlignment(JLabel.CENTER);
        leftPanel.add(explain1Label);

        nextButton = new JButton("다음");
        nextButton.setFont(new Font("한초롬바탕", Font.PLAIN, 20));
        nextButton.setForeground(Color.BLACK);
        nextButton.setBounds(10, 500, 100, 50); //안?됨
        nextButton.addActionListener(new ExplanButtonActionListener());
        leftPanel.add(nextButton);
    }

    public void play() {
        timer.schedule(backgroundBlack(),500);
        buttonEnable = false;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                board[i][j] = 0;
                rightPanel.boardPanel.buttons[i][j].setText("");
            }
        }
        nowNumber = 1;
        setBoard();
        timer.schedule(invisibleButtonText(), 3000);
    }

    private void setBoard(){
        for(int i=1;i<=maxNumber;){
            int random = (int)(Math.random()*24);
            if(board[random/5][random%5] == 0){
                board[random/5][random%5] = i;
                rightPanel.boardPanel.buttons[random/5][random%5].setText(Integer.toString(i));
                chknum1[i-1] = random/5;
                chknum2[i-1] = random%5;
                i++;
            }
        }
    }

    private TimerTask invisibleButtonText(){
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                hideButtonText();
                buttonEnable = true;
                NextbuttonEnable = true;
                //timerTimerTask = timePassing();
                //timer.schedule(timerTimerTask,1000,1000);
            }
        };
        return task;
    }

    private TimerTask backgroundBlack(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                leftPanel.setBackground(Color.BLACK);
                rightPanel.setBackground(Color.BLACK);
            }
        };
        return task;
    }

    private void hideButtonText(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                rightPanel.boardPanel.buttons[i][j].setText("");
                rightPanel.boardPanel.buttons[i][j].setBackground(new Color(255, 255, 255));
            }
        }
    }

    public void Explay(){
        NextbuttonEnable = false;
        timer.schedule(ExplayCollect(), 1000);
    }


    private TimerTask ExplayCollect(){
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                rightPanel.boardPanel.buttons[chknum1[0]][chknum2[0]].setText(Integer.toString(board[chknum1[0]][chknum2[0]]));
                rightPanel.boardPanel.buttons[chknum1[0]][chknum2[0]].setBackground(new Color(102, 102, 102));
                Dellay();
                rightPanel.boardPanel.buttons[chknum1[2]][chknum2[2]].setText(Integer.toString(board[chknum1[2]][chknum2[2]]));
                rightPanel.boardPanel.buttons[chknum1[2]][chknum2[2]].setBackground(new Color(102, 102, 102));
                leftPanel.setBackground(Color.RED);
                rightPanel.setBackground(Color.RED);
                Dellay();
                for(int i=0;i<5;i++){
                    for(int j=0;j<5;j++){
                        rightPanel.boardPanel.buttons[i][j].setText("");
                        rightPanel.boardPanel.buttons[i][j].setBackground(new Color(255, 255, 255));
                    }
                }
                leftPanel.setBackground(Color.BLACK);
                rightPanel.setBackground(Color.BLACK);
                Dellay();
                rightPanel.boardPanel.buttons[chknum1[0]][chknum2[0]].setText("1");
                rightPanel.boardPanel.buttons[chknum1[0]][chknum2[0]].setBackground(new Color(102, 102, 102));
                Dellay();
                rightPanel.boardPanel.buttons[chknum1[1]][chknum2[1]].setText("2");
                rightPanel.boardPanel.buttons[chknum1[1]][chknum2[1]].setBackground(new Color(102, 102, 102));
                Dellay();
                rightPanel.boardPanel.buttons[chknum1[2]][chknum2[2]].setText("3");
                rightPanel.boardPanel.buttons[chknum1[2]][chknum2[2]].setBackground(new Color(102, 102, 102));
                Dellay();
                rightPanel.boardPanel.buttons[chknum1[3]][chknum2[3]].setText("4");
                rightPanel.boardPanel.buttons[chknum1[3]][chknum2[3]].setBackground(new Color(102, 102, 102));
                Dellay();
                rightPanel.boardPanel.buttons[chknum1[4]][chknum2[4]].setText("5");
                rightPanel.boardPanel.buttons[chknum1[4]][chknum2[4]].setBackground(new Color(102, 102, 102));
                leftPanel.setBackground(Color.BLUE);
                rightPanel.setBackground(Color.BLUE);
                Dellay();
                hideButtonText();
                leftPanel.setBackground(Color.BLACK);
                rightPanel.setBackground(Color.BLACK);
                NextbuttonEnable = true;
                //timerTimerTask = timePassing();
                //timer.schedule(timerTimerTask,1000,1000);
            }
        };
        return task;
    }

    private void Dellay(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    class GameBoardButtonActionListener implements ActionListener {
        int i,j;
        public GameBoardButtonActionListener(int i, int j){
            this.i = i;
            this.j = j;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(buttonEnable && PlayEnable) {
                if (board[i][j] == nowNumber) {
                    nowNumber++;
                    rightPanel.boardPanel.buttons[i][j].setText(Integer.toString(board[i][j]));
                    if (nowNumber > maxNumber) {
                        leftPanel.setBackground(Color.BLUE);
                        rightPanel.setBackground(Color.BLUE);
                        explain1Label.setText("<html><body style='text-align:center;'>잘하셨습니다!<br><br>모든 모드는 이러한 형식을" +
                                "기반으로 플레이 가능하며<br><br>스토리, 챌린지, 타임어택<br>3가지 모드가 있습니다.<br>이제 메인메뉴로 가셔서<br>모드들을 플레이 해보세요!</body></html>");
                        timer.schedule(backgroundBlack(),500);
                        PlayEnable = false;
                        nextButton.setVisible(true);
                    }
                } else {
                    leftPanel.setBackground(Color.RED);
                    rightPanel.setBackground(Color.RED);
                    explain1Label.setText("<html><body style='text-align:center;'>다시한번 보신다음<br>시도해보세요!</body></html>");
                    play();
                }
            }
        }
    }
    class ExplanButtonActionListener implements ActionListener {
        public ExplanButtonActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (NextbuttonEnable) {
                if (e.getSource() == nextButton)
                    if (chk == 0) {
                        explain1Label.setText("<html><body style='text-align:center;'>처음에는 오른쪽에<br>보이는 격자판의<br>랜덤한 위치에<br>1부터 n까지의<br>랜덤한 숫자가<br>들어갑니다.</body></html>");
                        play();
                        chk++;
                    } else if (chk == 1) {
                        explain1Label.setText("<html><body style='text-align:center;'>숫자가 나타나면 몆초 뒤<br>사라지게 됩니다.<br>모드와 난이도에 따라<br>소멸 시간이 달라집니다.</body></html>");
                        NextbuttonEnable = false;
                        timer.schedule(invisibleButtonText(), 1500);
                        chk++;
                    } else if (chk == 2) {
                        explain1Label.setText("<html><body style='text-align:center;'>숫자의 위치를 순서대로<br>기억하여 알맞은 위치의<br>버튼을 누르셔야합니다.<br><br>만약 다른버튼을 누르면" +
                                "<br>빨간색으로 점등하고<br>마지막 숫자까지 누르면<br>파란색으로 점등합니다.</body></html>");
                        Explay();
                        chk++;
                    } else if (chk == 3) {
                        explain1Label.setText("<html><body style='text-align:center;'>한번 플레이 해보세요!</body></html>");
                        nextButton.setVisible(false);
                        PlayEnable = true;
                        chk++;
                    } else if (chk == 4) {
                        leftPanel.setVisible(false);
                        rightPanel.setVisible(false);
                        MainMenuGo.setVisible(true);
                    }
            }
        }
    }
    class MainMenuGo extends JPanel {
        JButton mainMenuButton;
        JLabel TutorialEndLabel;
        public MainMenuGo(){
            this.setSize(1080,720);
            this.setBackground(Color.BLACK);
            this.setLayout(null);
            TutorialEndLabel = new JLabel("Tutorial Clear!");
            TutorialEndLabel.setFont(new Font("함초롱바탕",Font.BOLD,80));
            TutorialEndLabel.setForeground(Color.WHITE);
            TutorialEndLabel.setSize(1080,100);
            TutorialEndLabel.setLocation(0,60);
            TutorialEndLabel.setHorizontalAlignment(JLabel.CENTER);
            mainMenuButton = new JButton("메인메뉴");
            mainMenuButton.setFont(new Font("한초롬바탕",Font.PLAIN,60));
            mainMenuButton.setBackground(Color.GRAY);
            mainMenuButton.setForeground(Color.BLACK);
            mainMenuButton.setSize(320,100);
            mainMenuButton.setLocation(360,300);
            this.add(mainMenuButton);
            this.add(TutorialEndLabel);
            mainMenuButton.addActionListener(e->{});
        }
    }
}