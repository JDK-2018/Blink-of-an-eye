import javax.swing.*;
import java.awt.*;

public class MainManuPanel extends JPanel {
    JLabel menuTitle;
    JButton gamePlay;
    JButton checkRanking;
    JButton gameExplain;
    public MainManuPanel(){
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,40));
        Dimension button_size = new Dimension(720,120);
        menuTitle = new JLabel("�� ��¦�� ����");
        menuTitle.setForeground(Color.WHITE);
        menuTitle.setFont(new Font("���ʷҹ���",Font.BOLD,70));
        menuTitle.setPreferredSize(new Dimension(960, 80));
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        gamePlay = new JButton("�� �� �� ��");
        gamePlay.setBackground(Color.GRAY);
        gamePlay.setPreferredSize(button_size);
        gamePlay.setForeground(Color.BLACK);
        gamePlay.setFont(new Font("���ʷҹ���",Font.PLAIN,50));
        checkRanking = new JButton("�� �� Ȯ ��");
        checkRanking.setBackground(Color.GRAY);
        checkRanking.setPreferredSize(button_size);
        checkRanking.setForeground(Color.BLACK);
        checkRanking.setFont(new Font("���ʷҹ���",Font.PLAIN,50));
        gameExplain = new JButton("�� �� �� ��");
        gameExplain.setBackground(Color.GRAY);
        gameExplain.setPreferredSize(button_size);
        gameExplain.setForeground(Color.BLACK);
        gameExplain.setFont(new Font("���ʷҹ���",Font.PLAIN,50));
        this.add(menuTitle);
        this.add(gamePlay);
        this.add(checkRanking);
        this.add(gameExplain);
    }
}