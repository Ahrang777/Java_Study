import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Test11_class13 extends JFrame {
    private GamePanel gamePanel = null;
    private TypingPanel typingPanel = null;
    public Test11_class13(){
        setTitle("Test11");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        gamePanel = new GamePanel();
        c.add(gamePanel,BorderLayout.CENTER);
        typingPanel = new TypingPanel(gamePanel);
        c.add(typingPanel,BorderLayout.SOUTH);

        setSize(300,500);
        setVisible(true);

        gamePanel.startGame();
    }

    // words.txt 읽고 리스트에 저장, 랜덤 추출
    class Words {
        private ArrayList<String> words = new ArrayList<>();

        public Words(String fileName){
            try{
                Scanner scanner = new Scanner(new FileReader(fileName));
                while(scanner.hasNext()){
                    String word = scanner.nextLine();
                    words.add(word);
                }
                scanner.close();
            } catch (FileNotFoundException e){
                System.out.println("file not found error");
                System.exit(0);
            }
        }

        public String getRandomWord(){
            final int WORDMAX = words.size();
            int index = (int)(Math.random()*WORDMAX);
            return words.get(index);
        }
    }

    // 글자 떨어지기
    class FallingThread extends Thread{
        private JLabel label = null;
        private GamePanel gamePanel = null;
        
        public FallingThread(JLabel label, GamePanel gamePanel){
            this.label = label;
            this.gamePanel = gamePanel;
        }
        
        public boolean depart(int y){
            if(y >= gamePanel.getHeight())
                return true;
            else
                return false;
        }

        // 200ms 당 5픽셀 아래로 이동
        @Override
        public void run(){
            while(true) {
                int x = label.getX();
                int y = label.getY() + 5;

                if(depart(y)){
                    y = 0;
                    // 글자 다른걸로 세팅
                }
                label.setLocation(x,y);

                try {
                    sleep(200);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    // 떨어지는 글자, 결과 출력
    class GamePanel extends JPanel{
        private JLabel label = new JLabel();
        private JLabel result = new JLabel();
        private Words words = null;
        private boolean gameOn = false; // 게임중인가?
        private FallingThread th = null;

        public GamePanel(){
            setLayout(null);

            result.setSize(100,30);
            result.setLocation(0,0);
            add(result);

            words = new Words("words.txt");
        }

        public boolean isGameOn(){
            return gameOn;
        }

        // label 세팅
        public void startGame(){
            String fallingWord = words.getRandomWord();
            label.setText(fallingWord);
            label.setSize(200,30);
            label.setLocation((getWidth()-200)/2,0);
            label.setForeground(Color.MAGENTA); //레이블의 글자 색을 설정한다.
            label.setFont(new Font("Tahoma", Font.ITALIC, 20)); // 레이블 글자의 폰트를 설정한다.

            th = new FallingThread(label, this);
            th.start();
            gameOn = true;
        }

        public void stopGame(){
            if(th == null)
                return;
            th.interrupt();
            th = null;
            gameOn = false;
        }

        /*
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);

        }
         */
    }

    // typing, GamePanel의 떨어지는 글자랑 같으면 글자 처리
    class TypingPanel extends JPanel{
        private JTextField tf = null;
        private GamePanel gamePanel = null;

        public TypingPanel(GamePanel gamePanel){
            this.gamePanel = gamePanel;

        }
    }

    public static void main(String[] args) {
        new Test11_class13();
    }
}
