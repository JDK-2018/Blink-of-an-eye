import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class TimeAttackModePlayPanel extends GameBoardPanel{
    private final int INVISIBLE_DELAY = 3000;
    private int[][] board = new int[5][5];
    private String difficulty;
    private int maxNumber;
    private int time = 60;
    private int score = 0;
    private int nowNumber = 1; //현재 찾아야할 숫자
    private boolean buttonEnable = false;
    private Timer timer = new Timer();
    private TimerTask timerTimerTask;
    private JLabel timerLabel;
    private JLabel scoreLabel;
    GameOverPanel gameOverPanel = new GameOverPanel();
    public TimeAttackModePlayPanel(String difficulty){
        super();
        gameOverPanel.setLocation(0,0);
        gameOverPanel.setVisible(false);
        this.add(gameOverPanel);
        this.difficulty = difficulty;
        for(int i = 0;i<5;i++){
            for(int j=0;j<5;j++){
                board[i][j] = 0;
                rightPanel.boardPanel.buttons[i][j].addActionListener(new GameBoardButtonActionListener(i,j));
            }
        }
        if(difficulty == "easy") {
            maxNumber = 5;
        } else if(difficulty == "normal"){
            maxNumber = 7;
        } else if(difficulty == "hard"){
            maxNumber = 10;
        }
        timerLabel = new JLabel("Timer : 60초");
        timerLabel.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setPreferredSize(new Dimension(360,80));
        leftPanel.add(timerLabel);
        scoreLabel = new JLabel("Score : 0");
        scoreLabel.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setPreferredSize(new Dimension(360,80));
        leftPanel.add(scoreLabel);
        play();
    }
    private TimerTask invisibleButtonText(){
        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                hideButtonText();
                buttonEnable = true;
                timerTimerTask = timePassing();
                timer.schedule(timerTimerTask,1000,1000);
            }
        };
        return task;
    }
    private TimerTask timePassing(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                time--;
                timerLabel.setText("Timer : "+time+"초");
                if(time == 0){
                    //게임 종료
                    this.cancel();
                    leftPanel.setVisible(false);
                    rightPanel.setVisible(false);
                    gameOverPanel.finalScoreLabel.setText("Score : "+score+"점");
                    gameOverPanel.setVisible(true);
                }
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
    private void play(){
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
        timer.schedule(invisibleButtonText(), INVISIBLE_DELAY);
    }
    private void hideButtonText(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                rightPanel.boardPanel.buttons[i][j].setText("");
            }
        }
    }
    private void setBoard(){
        for(int i=1;i<=maxNumber;){
            int random = (int)(Math.random()*24);
            if(board[random/5][random%5] == 0){
                board[random/5][random%5] = i;
                rightPanel.boardPanel.buttons[random/5][random%5].setText(Integer.toString(i));
                i++;
            }
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
            if(buttonEnable){
                if(board[i][j] == nowNumber){
                    nowNumber++;
                    rightPanel.boardPanel.buttons[i][j].setText(Integer.toString(board[i][j]));
                    if(nowNumber > maxNumber){
                        score += 1;
                        scoreLabel.setText("Score : " + score);
                        leftPanel.setBackground(Color.BLUE);
                        rightPanel.setBackground(Color.BLUE);
                        play();
                        timerTimerTask.cancel();
                    }
                } else{
                    leftPanel.setBackground(Color.RED);
                    rightPanel.setBackground(Color.RED);
                    play();
                    timerTimerTask.cancel();
                }
            }
        }
    }
    class GameOverPanel extends JPanel{
        JLabel gameOverLabel;
        JLabel finalScoreLabel;
        JLabel initialLAbel;
        JTextField nameTextField;
        JButton restartButton;
        JButton mainMenuButton;
        public GameOverPanel(){
            this.setSize(1080,720);
            this.setBackground(Color.BLACK);
            this.setLayout(null);
            gameOverLabel = new JLabel("Game Over");
            gameOverLabel.setFont(new Font("함초롱바탕",Font.BOLD,80));
            gameOverLabel.setForeground(Color.RED);
            gameOverLabel.setSize(1080,100);
            gameOverLabel.setLocation(0,60);
            gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
            finalScoreLabel = new JLabel("Score : "+score+"점");
            finalScoreLabel.setFont(new Font("한초롬바탕",Font.PLAIN,50));
            finalScoreLabel.setForeground(Color.WHITE);
            finalScoreLabel.setSize(1080,80);
            finalScoreLabel.setLocation(0,170);
            finalScoreLabel.setHorizontalAlignment(JLabel.CENTER);
            initialLAbel = new JLabel("이니셜 : ");
            initialLAbel.setFont(new Font("한초롬바탕",Font.PLAIN,50));
            initialLAbel.setForeground(Color.WHITE);
            initialLAbel.setSize(240,60);
            initialLAbel.setLocation(270,310);
            initialLAbel.setHorizontalAlignment(JLabel.CENTER);
            nameTextField = new JTextField();
            nameTextField.setFont(new Font("한초롬바탕",Font.PLAIN,50));
            nameTextField.setBackground(Color.BLACK);
            nameTextField.setForeground(Color.WHITE);
            nameTextField.setSize(240,60);
            nameTextField.setLocation(570,310);
            restartButton = new JButton("재시작");
            restartButton.setFont(new Font("한초롬바탕",Font.PLAIN,60));
            restartButton.setBackground(Color.WHITE);
            restartButton.setForeground(Color.BLACK);
            restartButton.setSize(320,100);
            restartButton.setLocation(120,430);
            mainMenuButton = new JButton("메인메뉴");
            mainMenuButton.setFont(new Font("한초롬바탕",Font.PLAIN,60));
            mainMenuButton.setBackground(Color.WHITE);
            mainMenuButton.setForeground(Color.BLACK);
            mainMenuButton.setSize(320,100);
            mainMenuButton.setLocation(600,430);
            this.add(gameOverLabel);
            this.add(finalScoreLabel);
            this.add(initialLAbel);
            this.add(nameTextField);
            this.add(restartButton);
            this.add(mainMenuButton);
            restartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameOverPanel.setVisible(false);
                    leftPanel.setVisible(true);
                    rightPanel.setVisible(true);
                    time = 60;
                    timerLabel.setText("Timer : "+time+"초");
                    score = 0;
                    scoreLabel.setText("Score : "+score);
                    play();
                }
            });
        }
    }
}
