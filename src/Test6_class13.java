import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Test6_class13 extends JFrame {
    public Test6_class13(){
        setTitle("Test6");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BubblePanel p = new BubblePanel();
        setContentPane(p);

        setSize(300,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test6_class13();
    }
}

class BubblePanel extends JPanel {
    //ArrayList<JLabel> bubbles = new ArrayList<>();
    private JLabel bubble = null;

    public BubblePanel(){
        setLayout(null);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                createBubble();
                MoveThread th = new MoveThread(bubble);
                th.start();
            }
        });
    }

    // 버블 생성
    public void createBubble(){
        int x = (int)(Math.random()*this.getWidth());
        int y = (int)(Math.random()*this.getHeight());
        ImageIcon img = new ImageIcon("images/bubble.png");
        bubble = new JLabel(img);
        bubble.setSize(img.getIconWidth(), img.getIconHeight());
        bubble.setLocation(x,y);
        add(bubble);
    }

    // bubble 이 위로 이동하는 스레드
    class MoveThread extends Thread{
        private JLabel bubble = null;

        public MoveThread(JLabel bubble){
            this.bubble = bubble;
        }

        @Override
        public void run(){
            while(true) {
                int x = bubble.getX();
                int y = bubble.getY() - 5;

                // 도착
                if (depart()) {
                    bubble.getParent().remove(bubble);
                    //System.out.println("제거");
                    return;
                } else {
                    bubble.setLocation(x,y);
                    bubble.getParent().repaint();
                }
                try{
                    sleep(20);
                } catch (InterruptedException e){
                    return;
                }
            }
        }

        public boolean depart(){
            if(bubble.getY()+bubble.getHeight() <= 0)
                return true;
            else
                return false;
        }
    }
}