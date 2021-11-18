import javax.swing.*;
import java.awt.*;

public class GameSelectPanel extends JPanel{
    public GameSelectPanel(){
        this.setSize(1920,1080);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
        Dimension button_size = new Dimension(960,120);
        JLabel gameSelectTitle = new JLabel("모 드 선 택");
        gameSelectTitle.setForeground(Color.WHITE);
        gameSelectTitle.setFont(new Font("한초롬바탕",Font.BOLD,50));
        gameSelectTitle.setPreferredSize(new Dimension(960,80));
        gameSelectTitle.setHorizontalAlignment(JLabel.CENTER);
        JButton storyButton = new JButton("스 토 리 모 드");
        storyButton.setBackground(Color.GRAY);
        storyButton.setPreferredSize(button_size);
        storyButton.setForeground(Color.BLACK);
        storyButton.setFont(new Font("한초롬바탕",Font.BOLD,40));
        JButton challengeButton = new JButton("챌 린 지 모 드");
        challengeButton.setBackground(Color.GRAY);
        challengeButton.setPreferredSize(button_size);
        challengeButton.setForeground(Color.BLACK);
        challengeButton.setFont(new Font("한초롬바탕",Font.BOLD,40));
        JButton timeAttackButton = new JButton("타 임 어 택 모 드");
        timeAttackButton.setBackground(Color.GRAY);
        timeAttackButton.setPreferredSize(button_size);
        timeAttackButton.setForeground(Color.BLACK);
        timeAttackButton.setFont(new Font("한초롬바탕",Font.BOLD,40));
        JButton tutorialButton = new JButton("튜 토 리 얼");
        tutorialButton.setBackground(Color.GRAY);
        tutorialButton.setPreferredSize(button_size);
        tutorialButton.setForeground(Color.BLACK);
        tutorialButton.setFont(new Font("한초롬바탕",Font.BOLD,40));
        this.add(gameSelectTitle);
        this.add(storyButton);
        this.add(challengeButton);
        this.add(timeAttackButton);
        this.add(tutorialButton);
    }
}
