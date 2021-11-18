import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("눈 깜짝할 사이");
        setSize(1920,1080);
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLACK);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,60));
        Dimension button_size = new Dimension(960,120);
        JLabel menuTitle = new JLabel("눈 깜짝할 사이");
        menuTitle.setForeground(Color.WHITE);
        menuTitle.setFont(new Font("한초롬바탕",Font.BOLD,70));
        menuTitle.setPreferredSize(new Dimension(960, 80));
        menuTitle.setHorizontalAlignment(JLabel.CENTER);
        JButton gamePlay = new JButton("게 임 시 작");
        gamePlay.setBackground(Color.GRAY);
        gamePlay.setPreferredSize(button_size);
        gamePlay.setForeground(Color.BLACK);
        gamePlay.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        JButton checkRanking = new JButton("등 수 확 인");
        checkRanking.setBackground(Color.GRAY);
        checkRanking.setPreferredSize(button_size);
        checkRanking.setForeground(Color.BLACK);
        checkRanking.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        JButton gameExplain = new JButton("게 임 설 명");
        gameExplain.setBackground(Color.GRAY);
        gameExplain.setPreferredSize(button_size);
        gameExplain.setForeground(Color.BLACK);
        gameExplain.setFont(new Font("한초롬바탕",Font.PLAIN,50));
        contentPane.add(menuTitle);
        contentPane.add(gamePlay);
        contentPane.add(checkRanking);
        contentPane.add(gameExplain);
        gamePlay.addActionListener(new gamePlayButtonActionListener());
    }
    void changePannel(Container container){
        this.setContentPane(container);

    }
    private class gamePlayButtonActionListener implements ActionListener { //게임 시작 버튼 이벤트 리스너
        @Override
        public void actionPerformed(ActionEvent e) {
            GameSelectPanel mode = new GameSelectPanel();
            mode.revalidate();
            changePannel(mode);

        }
    }
}
