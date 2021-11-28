import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class StoryMode extends GameBoardPanel {
    private final int INVISIBLE_DELAY = 3000;
    private int[][] board = new int[5][5];
    private int stage;
    private int index;
    private int maxNumber ;
    private int time = 60;
    private int score = 0;
    private int nowNumber = 1;
    private boolean buttonEnable = false;
    private Timer timer = new Timer();
    private TimerTask timerTask;
    private JLabel timerLabel;
    private JLabel stageLabel;
    private JLabel scoreLabel;
    GameOverPannel gameOverPannel;
    GameWinPannel gameWinPannel;
    public StoryMode(int stage, int index) {
        super();
        this.stage = stage;
        this.index = index;
        this.time -= index-1;
        this.maxNumber = 2 + stage;
        gameOverPannel = new GameOverPannel(stage,index);
        gameOverPannel.setLocation(0,0);
        gameOverPannel.setVisible(false);
        gameWinPannel = new GameWinPannel(stage,index);
        gameWinPannel.setLocation(0,0);
        gameWinPannel.setVisible(false);
        this.add(gameOverPannel);
        this.add(gameWinPannel);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = 0;
                rightPanel.boardPanel.buttons[i][j].addActionListener(new GameBoardButtonActionListener(i, j));
            }
        }
        timerLabel = new JLabel("Timer : %d초".formatted(time));
        timerLabel.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        timerLabel.setForeground(Color.WHITE);
        timerLabel.setPreferredSize(new Dimension(360,80));
        leftPanel.add(timerLabel);
        scoreLabel = new JLabel("Score : 0");
        scoreLabel.setFont(new Font("함초롱바탕",Font.PLAIN,50));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setPreferredSize(new Dimension(360,80));
        leftPanel.add(scoreLabel);
        stageLabel = new JLabel("Stage : %d - %d".formatted(this.stage,this.index));
        stageLabel.setFont(new Font("함초롱바탕",Font.PLAIN,50));
        stageLabel.setForeground(Color.WHITE);
        stageLabel.setPreferredSize(new Dimension(360,80));
        leftPanel.add(stageLabel);
        play();
    }

    private TimerTask invisibleButtonText() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                hideButtonText();
                buttonEnable = true;
                timerTask = timePassing();
                timer.schedule(timerTask, 1000, 1000);
            }
        };
        return task;
    }

    private TimerTask timePassing() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                time--;
                timerLabel.setText("Timer : " + time + "초");
                if(time == 0){
                    //게임 종료
                    this.cancel();
                    leftPanel.setVisible(false);
                    rightPanel.setVisible(false);
                    gameOverPannel.finalScoreLabel.setText("Score : "+score+"점");
                    gameOverPannel.setVisible(true);
                }
            }
        };
        return task;
    }

    private TimerTask backgroundBlack() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                leftPanel.setBackground(Color.BLACK);
                rightPanel.setBackground(Color.BLACK);
            }
        };
        return task;
    }

    private void play() {
        timer.schedule(backgroundBlack(), 500);
        buttonEnable = false;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = 0;
                rightPanel.boardPanel.buttons[i][j].setText("");
            }
        }
        nowNumber = 1;
        setBoard();
        timer.schedule(invisibleButtonText(), INVISIBLE_DELAY);
    }

    private void hideButtonText() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                rightPanel.boardPanel.buttons[i][j].setText("");
            }
        }
    }

    private void setBoard() {
        for (int i = 1; i <= maxNumber; ) {
            int random = (int) (Math.random() * 24);
            if (board[random / 5][random % 5] == 0) {
                board[random / 5][random % 5] = i;
                rightPanel.boardPanel.buttons[random / 5][random % 5].setText(Integer.toString(i));
                i++;
            }
        }
    }

    class GameBoardButtonActionListener implements ActionListener {
        int i, j;

        public GameBoardButtonActionListener(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buttonEnable) {
                if (board[i][j] == nowNumber) {
                    nowNumber++;
                    score += 1;
                    scoreLabel.setText("Score : " + score);
                    rightPanel.boardPanel.buttons[i][j].setText(Integer.toString(board[i][j]));
                    if (nowNumber > maxNumber) {
                        leftPanel.setBackground(Color.BLUE);
                        rightPanel.setBackground(Color.BLUE);
                        timerTask.cancel();
                        leftPanel.setVisible(false);
                        rightPanel.setVisible(false);
                        gameWinPannel.finalScoreLabel.setText("Score : "+score+"점");
                        gameWinPannel.setVisible(true);
                    }
                } else {
                    leftPanel.setBackground(Color.RED);
                    rightPanel.setBackground(Color.RED);
                    timerTask.cancel();
                    leftPanel.setVisible(false);
                    rightPanel.setVisible(false);
                    gameOverPannel.finalScoreLabel.setText("Score : "+score+"점");
                    gameOverPannel.setVisible(true);
                }
            }
        }
    }
    class GameOverPannel extends JPanel {
        JLabel gameOverLabel;
        JLabel stageLabel;
        JLabel finalScoreLabel;
        JLabel initialLAbel;
        JTextField nameTextField;
        JButton restartButton;
        JButton mainMenuButton;

        public GameOverPannel(int s, int i) {
            this.setSize(1080, 720);
            this.setBackground(Color.BLACK);
            this.setLayout(null);
            gameOverLabel = new JLabel("Game Over");
            gameOverLabel.setFont(new Font("함초롱바탕", Font.BOLD, 80));
            gameOverLabel.setForeground(Color.RED);
            gameOverLabel.setSize(1080, 100);
            gameOverLabel.setLocation(0, 60);
            gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
            stageLabel = new JLabel("Stage : %d-%d".formatted(s,i));
            stageLabel.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            stageLabel.setForeground(Color.WHITE);
            stageLabel.setSize(1080, 80);
            stageLabel.setLocation(0, 170);
            stageLabel.setHorizontalAlignment(JLabel.LEFT);
            finalScoreLabel = new JLabel("Score : " + score + "점");
            finalScoreLabel.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            finalScoreLabel.setForeground(Color.WHITE);
            finalScoreLabel.setSize(1080, 80);
            finalScoreLabel.setLocation(0, 170);
            finalScoreLabel.setHorizontalAlignment(JLabel.CENTER);
            initialLAbel = new JLabel("이니셜 : ");
            initialLAbel.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            initialLAbel.setForeground(Color.WHITE);
            initialLAbel.setSize(240, 60);
            initialLAbel.setLocation(270, 310);
            initialLAbel.setHorizontalAlignment(JLabel.CENTER);
            nameTextField = new JTextField();
            nameTextField.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            nameTextField.setBackground(Color.BLACK);
            nameTextField.setForeground(Color.WHITE);
            nameTextField.setSize(240, 60);
            nameTextField.setLocation(570, 310);
            restartButton = new JButton("재시작");
            restartButton.setFont(new Font("한초롬바탕", Font.PLAIN, 60));
            restartButton.setBackground(Color.WHITE);
            restartButton.setForeground(Color.BLACK);
            restartButton.setSize(320, 100);
            restartButton.setLocation(120, 430);
            mainMenuButton = new JButton("메인메뉴");
            mainMenuButton.setFont(new Font("한초롬바탕", Font.PLAIN, 60));
            mainMenuButton.setBackground(Color.WHITE);
            mainMenuButton.setForeground(Color.BLACK);
            mainMenuButton.setSize(320, 100);
            mainMenuButton.setLocation(600, 430);
            this.add(gameOverLabel);
            this.add(stageLabel);
            this.add(finalScoreLabel);
            this.add(initialLAbel);
            this.add(nameTextField);
            this.add(restartButton);
            this.add(mainMenuButton);
            restartButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameOverPannel.setVisible(false);
                    leftPanel.setVisible(true);
                    rightPanel.setVisible(true);
                    time = 60 - index + 1;
                    timerLabel.setText("Timer : %d초".formatted(time));
                    score = 0;
                    scoreLabel.setText("Score : %d".formatted(score));
                    play();
                }
            });
        }
    }

    class GameWinPannel extends JPanel{
        JLabel gameOverLabel;
        JLabel finalScoreLabel;
        JLabel initialLabel;
        JLabel stageLable;
        JTextField nameTextField;
        JButton stageButton;
        JButton mainMenuButton;
        int stage;
        int index;
        public GameWinPannel(int s, int i) {
            this.stage = s;
            this.index = i;
            this.setSize(1080, 720);
            this.setBackground(Color.BLACK);
            this.setLayout(null);
            gameOverLabel = new JLabel("Game Clear");
            gameOverLabel.setFont(new Font("함초롱바탕", Font.BOLD, 80));
            gameOverLabel.setForeground(Color.BLUE);
            gameOverLabel.setSize(1080, 100);
            gameOverLabel.setLocation(0, 60);
            gameOverLabel.setHorizontalAlignment(JLabel.CENTER);
            stageLabel = new JLabel("Stage : %d-%d".formatted(s,i));
            stageLabel.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            stageLabel.setForeground(Color.WHITE);
            stageLabel.setSize(1080, 80);
            stageLabel.setLocation(0, 170);
            stageLabel.setHorizontalAlignment(JLabel.LEFT);
            finalScoreLabel = new JLabel("Score : " + score + "점");
            finalScoreLabel.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            finalScoreLabel.setForeground(Color.WHITE);
            finalScoreLabel.setSize(1080, 80);
            finalScoreLabel.setLocation(0, 170);
            finalScoreLabel.setHorizontalAlignment(JLabel.CENTER);
            initialLabel = new JLabel("이니셜 : ");
            initialLabel.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            initialLabel.setForeground(Color.WHITE);
            initialLabel.setSize(240, 60);
            initialLabel.setLocation(270, 310);
            initialLabel.setHorizontalAlignment(JLabel.CENTER);
            nameTextField = new JTextField();
            nameTextField.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            nameTextField.setBackground(Color.BLACK);
            nameTextField.setForeground(Color.WHITE);
            nameTextField.setSize(240, 60);
            nameTextField.setLocation(570, 310);
            stageButton = new JButton("스테이지");
            stageButton.setFont(new Font("한초롬바탕", Font.PLAIN, 50));
            stageButton.setBackground(Color.WHITE);
            stageButton.setForeground(Color.BLACK);
            stageButton.setSize(320, 100);
            stageButton.setLocation(120, 430);
            mainMenuButton = new JButton("메인메뉴");
            mainMenuButton.setFont(new Font("한초롬바탕", Font.PLAIN, 60));
            mainMenuButton.setBackground(Color.WHITE);
            mainMenuButton.setForeground(Color.BLACK);
            mainMenuButton.setSize(320, 100);
            mainMenuButton.setLocation(600, 430);
            this.add(gameOverLabel);
            this.add(stageLabel);
            this.add(finalScoreLabel);
            this.add(initialLabel);
            this.add(nameTextField);
            this.add(stageButton);
            this.add(mainMenuButton);

        }
    }
}
