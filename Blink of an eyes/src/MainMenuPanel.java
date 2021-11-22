import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {
    JLabel menuTitle;
    JButton gamePlay;
    JButton checkRanking;
    JButton gameExplain;
    public MainMenuPanel(){
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,40));
        Dimension button_size = new Dimension(720,100);
        menuTitle = new JLabel("눈 깜짝할 사이");
        menuTitle.setForeground(Color.WHITE);
        menuTitle.setFont(new Font("한초롬바탕",Font.BOLD,70));
        menuTitle.setPreferredSize(new Dimension(960, 80));
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        gamePlay = new JButton("게 임 시 작");
        gamePlay.setBackground(Color.GRAY);
        gamePlay.setPreferredSize(button_size);
        gamePlay.setForeground(Color.BLACK);
        gamePlay.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        checkRanking = new JButton("등 수 확 인");
        checkRanking.setBackground(Color.GRAY);
        checkRanking.setPreferredSize(button_size);
        checkRanking.setForeground(Color.BLACK);
        checkRanking.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        gameExplain = new JButton("게 임 설 명");
        gameExplain.setBackground(Color.GRAY);
        gameExplain.setPreferredSize(button_size);
        gameExplain.setForeground(Color.BLACK);
        gameExplain.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        this.add(menuTitle);
        this.add(gamePlay);
        this.add(checkRanking);
        this.add(gameExplain);
    }
}