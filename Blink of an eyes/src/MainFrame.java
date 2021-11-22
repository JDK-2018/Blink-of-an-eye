import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    MainMenuPanel mainMenuPanel = new MainMenuPanel();
    GameSelectPanel modeSelectPanel = new GameSelectPanel();
    GameBoardPanel gameBoardPanel = new GameBoardPanel();
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        setTitle("눈 깜짝할 사이");
        setSize(1080,720);
        setVisible(true);
        changePanel(mainMenuPanel);
        mainMenuPanel.gamePlay.addActionListener(new ScreenChangeActionListener(modeSelectPanel));
        modeSelectPanel.timeAttackButton.addActionListener(new ScreenChangeActionListener(gameBoardPanel));
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
}
