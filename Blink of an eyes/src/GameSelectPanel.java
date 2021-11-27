import javax.swing.*;
import java.awt.*;

public class GameSelectPanel extends JPanel{
    JButton storyButton;
    JButton challengeButton;
    JButton timeAttackButton;
    JButton tutorialButton;
    public GameSelectPanel(){
        this.setSize(1080,720);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
        Dimension button_size = new Dimension(720,100);
        JLabel gameSelectTitle = new JLabel("�� �� �� ��");
        gameSelectTitle.setForeground(Color.WHITE);
        gameSelectTitle.setFont(new Font("���ʷҹ���",Font.BOLD,50));
        gameSelectTitle.setPreferredSize(new Dimension(960,80));
        gameSelectTitle.setHorizontalAlignment(JLabel.CENTER);
        storyButton = new JButton("�� �� �� �� ��");
        storyButton.setBackground(Color.GRAY);
        storyButton.setPreferredSize(button_size);
        storyButton.setForeground(Color.BLACK);
        storyButton.setFont(new Font("���ʷҹ���",Font.BOLD,40));
        challengeButton = new JButton("ç �� �� �� ��");
        challengeButton.setBackground(Color.GRAY);
        challengeButton.setPreferredSize(button_size);
        challengeButton.setForeground(Color.BLACK);
        challengeButton.setFont(new Font("���ʷҹ���",Font.BOLD,40));
        timeAttackButton = new JButton("Ÿ �� �� �� �� ��");
        timeAttackButton.setBackground(Color.GRAY);
        timeAttackButton.setPreferredSize(button_size);
        timeAttackButton.setForeground(Color.BLACK);
        timeAttackButton.setFont(new Font("���ʷҹ���",Font.BOLD,40));
        tutorialButton = new JButton("Ʃ �� �� ��");
        tutorialButton.setBackground(Color.GRAY);
        tutorialButton.setPreferredSize(button_size);
        tutorialButton.setForeground(Color.BLACK);
        tutorialButton.setFont(new Font("���ʷҹ���",Font.BOLD,40));
        this.add(gameSelectTitle);
        this.add(storyButton);
        this.add(challengeButton);
        this.add(timeAttackButton);
        this.add(tutorialButton);
    }
}