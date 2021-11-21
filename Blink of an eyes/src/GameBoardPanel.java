import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {
    LeftPanel leftPanel = new LeftPanel(); //왼쪽 화면 : 점수, 타이머 등 각자 작업
    RightPanel rightPanel = new RightPanel();
    //오른쪽 화면 : 격자판
    //격자판의 버튼 : rightPanel.boardPanel.buttons (2중배열)
    public GameBoardPanel(){
        this.setSize(1080,720);
        this.setBackground(Color.BLACK);
        this.setLayout(null);
        leftPanel.setLocation(0,0);
        rightPanel.setLocation(360,0);
        this.add(leftPanel);
        this.add(rightPanel);
    }
    class LeftPanel extends JPanel{
        public LeftPanel(){
            this.setSize(360,720);
            this.setBackground(Color.BLACK);
        }
    }
    class RightPanel extends JPanel{
        BoardPanel boardPanel = new BoardPanel(); //오른쪽 화면의 격자판을 담을 패널
        public RightPanel(){
            this.setSize(720,720);
            this.setBackground(Color.BLACK);
            this.add(boardPanel);
        }
        class BoardPanel extends JPanel{
            JButton buttons[][]; //격자판의 각 칸(버튼) 2중 배열로 관리
            public BoardPanel(){
                this.setLayout(new GridLayout(5,5,0,0));
                Dimension button_size = new Dimension(134,134);
                buttons = new JButton[5][5];
                for(int i = 0;i<5;i++){
                    for(int j=0;j<5;j++){
                        buttons[i][j] = new JButton();
                        buttons[i][j].setPreferredSize(button_size);
                        buttons[i][j].setBackground(Color.WHITE);
                        this.add(buttons[i][j]);
                    }
                }
            }
        }
    }
}
