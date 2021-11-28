import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StageSelectPannel extends JPanel{
    JLabel title;
    JButton next;
    JButton prev;
    public final int STAGE = 5;
    int now = 0;
    JButton[][][] stages = new JButton[STAGE][3][3];
    public StageSelectPannel(int now){
        this.now = now;
        StagePannel stagePannel = new StagePannel(now);
        BottomPannel bottomPannel = new BottomPannel();
        this.setSize(1080,720);
        this.setBackground(Color.black);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        title = new JLabel("스테이지 %d".formatted(now+1));
        title.setForeground(Color.WHITE);
        title.setPreferredSize(new Dimension(960,80));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("함초롱바탕",Font.PLAIN,48));
        stagePannel.setLocation(0,160);
        bottomPannel.setLocation(0,640);
        this.add(title);
        this.add(stagePannel);
        this.add(bottomPannel);
    }

    class StagePannel extends JPanel{

        public StagePannel(int now) {
            this.setSize(1080,560);
            this.setBackground(Color.BLACK);
            this.setLayout(new GridLayout(3,3,100,50));
            Dimension buttonSize = new Dimension(100,100);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    stages[now][i][j] = new JButton();
                    stages[now][i][j].setPreferredSize(buttonSize);
                    stages[now][i][j].setBackground(Color.WHITE);
                    stages[now][i][j].setText("%d-%d".formatted(now+1, (i*3 + j + 1)));
                    stages[now][i][j].setFont(new Font("한초롬바탕", Font.PLAIN, 24));
                    this.add(stages[now][i][j]);
                }
            }
        }
    }

    class BottomPannel extends JPanel{

        public BottomPannel(){
            Dimension stageButtonSize = new Dimension(100,60);
            this.setSize(1080,80);
            this.setBackground(Color.BLACK);
            this.setLayout(new FlowLayout(FlowLayout.LEFT,700,10));
            next = new JButton("다 음");
            next.setBackground(Color.GRAY);
            next.setPreferredSize(stageButtonSize);
            next.setForeground(Color.BLACK);
            next.setFont(new Font("함초롱바탕",Font.PLAIN,24));
            next.addActionListener(new StageNextButtonActionListener(this));
            prev = new JButton("이 전");
            prev.setBackground(Color.GRAY);
            prev.setPreferredSize(stageButtonSize);
            prev.setForeground(Color.BLACK);
            prev.setFont(new Font("함초롱바탕",Font.PLAIN,24));
            this.add(prev);
            this.add(next);
        }
    }

    class StageNextButtonActionListener implements ActionListener{
        private final JPanel jPanel;
        public StageNextButtonActionListener(JPanel jPanel){
            this.jPanel = jPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (now < STAGE-1)
                now++;
            else
                now = STAGE-1;
            setStages(now);
            jPanel.repaint();
        }
    }

    class StagePrevButtonActionListener implements ActionListener{
        private final JPanel jPanel;
        public StagePrevButtonActionListener(JPanel jPanel){
            this.jPanel = jPanel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (now > 0)
                now--;
            else
                now = 0;
            setStages(now);
            jPanel.updateUI();
        }
    }

    private void setStages(int now){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stages[now][i][j]= new JButton();
                stages[now][i][j].setText("%d-%d".formatted(now+1, (i*3 + j + 1)));
            }
        }
    }
}
