import javax.swing.*;
import java.awt.*;

public class TimeAttackDifficultySelectPanel extends JPanel {
	JLabel title;
	JButton easyButton;
	JButton normalButton;
	JButton hardButton;
	public TimeAttackDifficultySelectPanel(){
        this.setSize(1080,720);
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,30));
        Dimension button_size = new Dimension(720,120);
        title = new JLabel("타임어택 모드");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("한초롬바탕",Font.BOLD,70));
        title.setPreferredSize(new Dimension(960, 80));
        title.setHorizontalAlignment(JLabel.CENTER);
        easyButton = new JButton("E A S Y");
        easyButton.setBackground(Color.GRAY);
        easyButton.setPreferredSize(button_size);
        easyButton.setForeground(Color.BLACK);
        easyButton.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        normalButton = new JButton("N O R M A L");
        normalButton.setBackground(Color.GRAY);
        normalButton.setPreferredSize(button_size);
        normalButton.setForeground(Color.BLACK);
        normalButton.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        hardButton = new JButton("H A R D");
        hardButton.setBackground(Color.GRAY);
        hardButton.setPreferredSize(button_size);
        hardButton.setForeground(Color.BLACK);
        hardButton.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        this.add(title);
        this.add(easyButton);
        this.add(normalButton);
        this.add(hardButton);
    }
}
