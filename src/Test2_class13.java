import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

// 수정 : 현재 한번만 이동하고 안 움직임

class Test2Thread extends Thread{
    private MyPanel panel = null;
    private boolean flag = false;

    public Test2Thread(MyPanel panel){
        this.panel = panel;
    }

    public void finish(){
        flag = true;
    }

    // 400ms마다 panel.move
    @Override
    public void run(){
        while(true){
            panel.move();
            try{
                sleep(400);
                if(flag == true){
                    return;
                }
            } catch (InterruptedException e){return;}
        }
    }
}

class MyPanel extends JPanel {
    //public Point point = null;
    private int x = 80;
    private int y = 80;
    //private JLabel label = new JLabel(Integer.toString(x)+", "+Integer.toString(y));
/*
    public MyPanel(){

        label.setSize(100,100);
        label.setLocation(300,300);
        this.add(label);
    }
*/

    // 원 그리기
    // point 객체를 중심으로 원그리기
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.MAGENTA);
        g.drawOval(x,y,50,50);
    }

    // 원 랜덤하게 이동
    public void move(){
        x = (int)(Math.random()*this.getWidth());
        y = (int)(Math.random()*this.getHeight());
        // 랜덤한 포인트로 point 객체 수정
        //point.setLocation(x,y);
        //label.setText(Integer.toString(x)+", "+Integer.toString(y));

        repaint();
    }

}


public class Test2_class13 extends JFrame {
    private MyPanel panel = null;
    private Test2Thread th = null;
    public Test2_class13(){
        setTitle("Test2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new MyPanel();
        setContentPane(panel);

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //스레드 시작
                th = new Test2Thread(panel);
                th.start();
            }
        });

        panel.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(th != null)
                    th.finish();
            }
        });

        setSize(800,800);
        setVisible(true);

        panel.setFocusable(true);
        panel.requestFocus();
    }

    public static void main(String[] args) {
        new Test2_class13();
    }
}
