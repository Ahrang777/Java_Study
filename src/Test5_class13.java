import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 전체적인 배치
public class Test5_class13 extends JFrame {
    public Test5_class13(){
        setTitle("Test5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        setContentPane(panel);

        setSize(300,300);
        setResizable(false);
        setVisible(true);
        panel.startGame();
    }
    public static void main(String[] args) {
        new Test5_class13();
    }
}
class GamePanel extends JPanel {
    private JLabel base = new JLabel();
    private JLabel bullet = new JLabel();
    private JLabel target = null;
    private TargetThread targetThread = null;


    // 컴포넌트 size 같은 속성 설정만
    public GamePanel(){
        setLayout(null);

        base.setSize(40,40);
        base.setOpaque(true);
        base.setBackground(Color.BLACK);

        ImageIcon img = new ImageIcon("images/chicken.png");
        target = new JLabel(img);
        target.setSize(img.getIconWidth(),img.getIconHeight());

        bullet.setSize(10,10);
        bullet.setOpaque(true);
        bullet.setBackground(Color.RED);

        add(base);
        add(target);
        add(bullet);

        // base가 키 입력을 받을 수 있도록 포커스 강제 지정
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                base.setFocusable(true);
                base.requestFocus();
            }
        });
    }

    // 컴포넌트 위치, 스레드 생성, 시작
    public void startGame(){
        base.setLocation(this.getWidth()/2-20,this.getHeight()-40);
        bullet.setLocation(this.getWidth()/2-5, this.getHeight()-50);
        target.setLocation(0,0);

        targetThread = new TargetThread(target);
        targetThread.start();

        base.setFocusable(true);
        base.requestFocus();
        base.addKeyListener(new KeyAdapter() {
            BulletThread bulletThread = null;
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar() == '\n'){
                    if(bulletThread == null || !bulletThread.isAlive()){
                        bulletThread = new BulletThread(bullet, target, targetThread);
                        bulletThread.start();
                    }
                }
            }
        });
    }

    // target 움직이는 스레드
    class TargetThread extends Thread{
        private JComponent target = null;

        public TargetThread(JComponent target){
            this.target = target;
            target.setLocation(0,0);
            target.getParent().repaint();
        }

        @Override
        public void run(){
            while(true){
                int x = target.getX()+5;
                int y = target.getY();

                if(x>target.getParent().getWidth())
                    target.setLocation(0,0);
                else target.setLocation(x,y);

                target.getParent().repaint();
                try{
                    sleep(20);
                } catch (InterruptedException e){
                    target.setLocation(0,0);
                    target.getParent().repaint();
                    try{
                        sleep(500);
                    } catch (InterruptedException e2){}
                }
            }
        }
    }

    // bullet 움직이는 스레드
    class BulletThread extends Thread{
        private JComponent bullet, target = null;
        private Thread targetThread = null;

        public BulletThread(JComponent bullet, JComponent target, Thread targetThread){
            this.bullet = bullet;
            this.target = target;
            this.targetThread = targetThread;
        }

        @Override
        public void run(){
            while(true){
                // 명중
                if(hit()){
                    targetThread.interrupt();
                    bullet.setLocation(bullet.getParent().getWidth()/2-5, bullet.getParent().getHeight()-50);
                    return;
                }
                else{
                    int x = bullet.getX();
                    int y = bullet.getY()-5;
                    if(y<0){
                        bullet.setLocation(bullet.getParent().getWidth()/2-5, bullet.getParent().getHeight()-50);
                        bullet.getParent().repaint();
                        return;
                    }
                    bullet.setLocation(x,y);
                    bullet.getParent().repaint();
                }
                try{
                    sleep(20);
                }catch (InterruptedException e){}
            }
        }

        public boolean hit(){
            if(targetContains(bullet.getX(), bullet.getY()) ||
                    targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()) ||
                    targetContains(bullet.getX() + bullet.getWidth() - 1, bullet.getY()+bullet.getHeight() - 1) ||
                    targetContains(bullet.getX(), bullet.getY()+bullet.getHeight() - 1))
                return true;
            else
                return false;
        }

        public boolean targetContains(int x, int y){
            if(((target.getX() <= x) && (target.getX() + target.getWidth() - 1 >= x)) &&
                    ((target.getY() <= y)&& (target.getY() + target.getHeight() - 1 >= y))) {
                return true;
            }
            else
                return false;
        }
    }
}