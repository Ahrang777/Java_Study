import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Test7_class13 extends JFrame {
    private GroundPanel p;
    private Thread snakeThread = null;

    public Test7_class13(){
        setTitle("스네이크 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        p=new GroundPanel();
        setContentPane(p);

        setSize(400,400);
        setVisible(true);

        p.setFocusable(true);
        p.requestFocus();

        snakeThread = new Thread(p);
        snakeThread.start();
    }

    class GroundPanel extends JPanel implements Runnable{
        private static final int LEFT = 0;
        private static final int RIGHT = 1;
        private static final int UP = 2;
        private static final int DOWN = 3;
        private int direction;
        private int delay = 200;
        private Image img;
        private SnakeBody snakeBody = null;

        public GroundPanel(){
            setLayout(null);
            snakeBody = new SnakeBody();
            snakeBody.addPanel(this);
            direction = LEFT;
            this.addKeyListener(new MyKeyListener());
            ImageIcon icon = new ImageIcon("images/bg.jpg");
            img = icon.getImage();

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    GroundPanel.this.setFocusable(true);
                    GroundPanel.this.requestFocus();
                }
            });
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(),getHeight(),null);
        }

        // 방향조절
        @Override
        public void run(){
            while(true){
                try{
                    Thread.sleep(delay);
                    snakeBody.move(direction);
                    //repaint();
                } catch (InterruptedException e){
                    return;
                }
            }
        }

        class MyKeyListener extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e){
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:
                        direction = LEFT;
                        break;
                    case KeyEvent.VK_RIGHT:
                        direction = RIGHT;
                        break;
                    case KeyEvent.VK_UP:
                        direction = UP;
                        break;
                    case KeyEvent.VK_DOWN:
                        direction = DOWN;
                        break;
                }
            }
        }
    }

    // JLabel ArrayList
    class SnakeBody extends JLabel{
        private ArrayList<JLabel> snake = null;

        public SnakeBody(){
            snake = new ArrayList<>();
            ImageIcon head = new ImageIcon("images/head.jpg");
            JLabel headLabel = new JLabel(head);
            headLabel.setSize(head.getIconWidth(),head.getIconHeight());
            headLabel.setLocation(100,100);
            snake.add(headLabel);

            ImageIcon body = new ImageIcon("images/body.jpg");
            for(int i=1;i<10;i++) {
                JLabel bodyLabel = new JLabel(body);
                bodyLabel.setSize(body.getIconWidth(), body.getIconHeight());
                bodyLabel.setLocation(100+i*20, 100);
                snake.add(bodyLabel);
            }
        }

        public void addPanel(JPanel panel){
            for(int i=0;i<snake.size();i++) {
                panel.add(snake.get(i));
            }
        }

        public void move(int direction){
            for(int i=snake.size()-1;i>0;i--){
                JLabel b = snake.get(i);
                JLabel a = snake.get(i-1);
                b.setLocation(a.getX(),a.getY());
            }

            JLabel head = snake.get(0);

            switch (direction){
                case GroundPanel.LEFT:
                    head.setLocation(head.getX()-20,head.getY());
                    break;
                case GroundPanel.RIGHT:
                    head.setLocation(head.getX()+20,head.getY());
                    break;
                case GroundPanel.UP:
                    head.setLocation(head.getX(),head.getY()-20);
                    break;
                case GroundPanel.DOWN:
                    head.setLocation(head.getX(),head.getY()+20);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Test7_class13();
    }
}
