import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
	MainManuPanel mainMenuPanel = new MainManuPanel();
    GameSelectPanel modeSelectPanel = new GameSelectPanel();
    Chellengemode chellengemode = new Chellengemode("easy");
    ChellengeDifficultySelectPanel chellengeDifficultySelectPanel = new ChellengeDifficultySelectPanel();
    TimeAttackModePlayPanel timeAttackModePlayPanel = new TimeAttackModePlayPanel("easy");
    TimeAttackDifficultySelectPanel timeAttackDifficultySelectPanel = new TimeAttackDifficultySelectPanel();
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setTitle("´« ±ôÂ¦ÇÒ »çÀÌ");
        setSize(1080,720);
        setVisible(true);
        changePanel(mainMenuPanel);
        mainMenuPanel.gamePlay.addActionListener(new ScreenChangeActionListener(modeSelectPanel));
        modeSelectPanel.challengeButton.addActionListener(new ScreenChangeActionListener(chellengeDifficultySelectPanel));
        chellengeDifficultySelectPanel.easyButton.addActionListener(new ChllengeModeStartActionListener("easy"));
        chellengeDifficultySelectPanel.normalButton.addActionListener(new ChllengeModeStartActionListener("normal"));
        chellengeDifficultySelectPanel.hardButton.addActionListener(new ChllengeModeStartActionListener("hard"));
        modeSelectPanel.timeAttackButton.addActionListener(new ScreenChangeActionListener(timeAttackDifficultySelectPanel));
        timeAttackDifficultySelectPanel.easyButton.addActionListener(new TimeAttackModeStartActionListener("easy"));
        timeAttackDifficultySelectPanel.normalButton.addActionListener(new TimeAttackModeStartActionListener("normal"));
        timeAttackDifficultySelectPanel.hardButton.addActionListener(new TimeAttackModeStartActionListener("hard"));
    }
    void changePanel(Container container){
        this.setContentPane(container);
    }
    private class ScreenChangeActionListener implements ActionListener{
        JPanel panel;
        public ScreenChangeActionListener(JPanel panel){
            this.panel = panel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            changePanel(panel);
        }
    }
    private class ChllengeModeStartActionListener implements ActionListener{
        String difficulty;
        public ChllengeModeStartActionListener(String difficulty){
            this.difficulty = difficulty;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
        	chellengemode = new Chellengemode(difficulty);
            changePanel(chellengemode);
            chellengemode.gameOverPanel.mainMenuButton.addActionListener(new ScreenChangeActionListener(mainMenuPanel));
        }
    }
    private class TimeAttackModeStartActionListener implements ActionListener{
        String difficulty;
        public TimeAttackModeStartActionListener(String difficulty){
            this.difficulty = difficulty;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            timeAttackModePlayPanel = new TimeAttackModePlayPanel(difficulty);
            changePanel(timeAttackModePlayPanel);
            timeAttackModePlayPanel.gameOverPanel.mainMenuButton.addActionListener(new ScreenChangeActionListener(mainMenuPanel));
        }
    }
}