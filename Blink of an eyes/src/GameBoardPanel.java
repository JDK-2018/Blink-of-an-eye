import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {
    LeftPanel leftPanel = new LeftPanel(); //���� ȭ�� : ����, Ÿ�̸� �� ���� �۾�
    RightPanel rightPanel = new RightPanel();
    //������ ȭ�� : ������
    //�������� ��ư : rightPanel.boardPanel.buttons (2�߹迭)
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
        BoardPanel boardPanel = new BoardPanel(); //������ ȭ���� �������� ���� �г�
        public RightPanel(){
            this.setSize(720,720);
            this.setBackground(Color.BLACK);
            this.add(boardPanel);
        }
        class BoardPanel extends JPanel{
            JButton buttons[][] = new JButton[5][5];; //�������� �� ĭ(��ư) 2�� �迭�� ����
            public BoardPanel(){
                this.setLayout(new GridLayout(5,5,0,0));
                Dimension button_size = new Dimension(134,134);
                for(int i = 0;i<5;i++){
                    for(int j=0;j<5;j++){
                        buttons[i][j] = new JButton();
                        buttons[i][j].setPreferredSize(button_size);
                        buttons[i][j].setBackground(Color.WHITE);
                        buttons[i][j].setFont(new Font("���ʷҹ���",Font.PLAIN,50));
                        this.add(buttons[i][j]);
                    }
                }
            }
        }
    }
}