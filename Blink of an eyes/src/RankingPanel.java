import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingPanel extends JPanel {
    JLabel menuTitle;
    JButton Story;
    JButton Challenge;
    JButton TimeAttack;
    StoryRankPanel easyPanel = new StoryRankPanel();
    ChallengeRankPanel normalPanel = new ChallengeRankPanel();
    TimeAttackPanel hardPanel = new TimeAttackPanel();
    public RankingPanel(){
        this.setBackground(Color.BLACK);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,5,40));
        Dimension button_size = new Dimension(720,100);
        menuTitle = new JLabel(" 랭킹 모드 선택");
        menuTitle.setForeground(Color.WHITE);
        menuTitle.setFont(new Font("한초롬바탕",Font.BOLD,70));
        menuTitle.setPreferredSize(new Dimension(960, 80));
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        Story = new JButton("스토리");
        Story.setBackground(Color.GRAY);
        Story.setPreferredSize(button_size);
        Story.setForeground(Color.BLACK);
        Story.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        Challenge = new JButton("챌린지");
        Challenge.setBackground(Color.GRAY);
        Challenge.setPreferredSize(button_size);
        Challenge.setForeground(Color.BLACK);
        Challenge.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        TimeAttack = new JButton("타임어택");
        TimeAttack.setBackground(Color.GRAY);
        TimeAttack.setPreferredSize(button_size);
        TimeAttack.setForeground(Color.BLACK);
        TimeAttack.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        this.add(menuTitle);
        this.add(Story);
        this.add(Challenge);
        this.add(TimeAttack);
        changePanel(menuTitle);
        Story.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoryRankPanel();
                setVisible(false);

            }
        });
    }
    void changePanel(Container container){
        this.setContentPane(container);
    }

    private void setContentPane(Container container) {
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
