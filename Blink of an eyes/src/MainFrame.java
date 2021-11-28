import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private int now = 0;
    private int index = 0;
    MainMenuPanel mainMenuPanel = new MainMenuPanel();
    GameSelectPanel modeSelectPanel = new GameSelectPanel();
    TimeAttackModePlayPanel timeAttackModePlayPanel = new TimeAttackModePlayPanel("easy");
    TimeAttackDifficultySelectPanel timeAttackDifficultySelectPanel = new TimeAttackDifficultySelectPanel();
    Challengemode challengemode = new Challengemode("easy");
    ChallengeDifficultySelectPanel challengeDifficultySelectPanel = new ChallengeDifficultySelectPanel();
    StageSelectPannel stageSelectPannel = new StageSelectPannel(now);
    StoryMode storyMode;
    TutorialMode TutorialMode = new TutorialMode();
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setTitle("눈 깜짝할 사이");
        setSize(1080,720);
        setVisible(true);
        changePanel(mainMenuPanel);
        mainMenuPanel.gamePlay.addActionListener(new ScreenChangeActionListener(modeSelectPanel));
        modeSelectPanel.timeAttackButton.addActionListener(new ScreenChangeActionListener(timeAttackDifficultySelectPanel));
        modeSelectPanel.challengeButton.addActionListener(new ScreenChangeActionListener(challengeDifficultySelectPanel));
        modeSelectPanel.storyButton.addActionListener(new ScreenChangeActionListener(stageSelectPannel));
        modeSelectPanel.tutorialButton.addActionListener(new TutorialModeActionListener(TutorialMode));
        timeAttackDifficultySelectPanel.easyButton.addActionListener(new TimeAttackModeStartActionListener("easy"));
        timeAttackDifficultySelectPanel.normalButton.addActionListener(new TimeAttackModeStartActionListener("normal"));
        timeAttackDifficultySelectPanel.hardButton.addActionListener(new TimeAttackModeStartActionListener("hard"));
        challengeDifficultySelectPanel.easyButton.addActionListener(new ChllengeModeStartActionListener("easy"));
        challengeDifficultySelectPanel.normalButton.addActionListener(new ChllengeModeStartActionListener("normal"));
        challengeDifficultySelectPanel.hardButton.addActionListener(new ChllengeModeStartActionListener("hard"));
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                stageSelectPannel.stages[now][i][j].addActionListener(new StoryModeStartActionListener(now, i * 3 + j));
            }
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

    private class ChllengeModeStartActionListener implements ActionListener{
        String difficulty;
        public ChllengeModeStartActionListener(String difficulty){
            this.difficulty = difficulty;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            challengemode = new Challengemode(difficulty);
            changePanel(challengemode);
            challengemode.gameOverPanel.mainMenuButton.addActionListener(new ScreenChangeActionListener(mainMenuPanel));
        }
    }
    private class StoryModeStartActionListener implements ActionListener {
        int now, i;

        public StoryModeStartActionListener(int now, int j) {
            this.now = now;
            this.i = j;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            storyMode = new StoryMode(now + 1, i + 1);
            changePanel(storyMode);
            storyMode.gameWinPannel.stageButton.addActionListener(new ScreenChangeActionListener(stageSelectPannel));
            storyMode.gameWinPannel.mainMenuButton.addActionListener(new ScreenChangeActionListener(mainMenuPanel));
            storyMode.gameOverPannel.mainMenuButton.addActionListener(new ScreenChangeActionListener(mainMenuPanel));
        }
    }
    private class StoryStagePrevActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (now > 0)
                now--;
            else
                now = 0;
            stageSelectPannel = new StageSelectPannel(now);
            changePanel(stageSelectPannel);
            stageSelectPannel.prev.addActionListener(new StoryStagePrevActionListener());
            stageSelectPannel.next.addActionListener(new StoryStageNextActionListener());
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    stageSelectPannel.stages[now][i][j].addActionListener(new StoryModeStartActionListener(now, i * 3 + j));
                }
            }
        }
    }
    private class StoryStageNextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (now < 4)
                now++;
            else
                now = 4;
            stageSelectPannel = new StageSelectPannel(now);
            changePanel(stageSelectPannel);
            stageSelectPannel.next.addActionListener(new StoryStageNextActionListener());
            stageSelectPannel.prev.addActionListener(new StoryStagePrevActionListener());
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    stageSelectPannel.stages[now][i][j].addActionListener(new StoryModeStartActionListener(now, i * 3 + j));
                }
            }
        }
    }
    private  class TutorialModeActionListener implements  ActionListener{
        public TutorialModeActionListener(TutorialMode tutorialMode) {
        }

        @Override
        public void actionPerformed(ActionEvent e){
            TutorialMode = new TutorialMode();
            changePanel(TutorialMode);
            TutorialMode.MainMenuGo.mainMenuButton.addActionListener(new ScreenChangeActionListener(mainMenuPanel));

        }
    }
}
