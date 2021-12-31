import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlyingTextEx extends JFrame {
    private final int FLYING_UNIT = 10;
    private JLabel label = null;

    public FlyingTextEx(){
        setTitle("화살표로 텍스트 이동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        label = new JLabel("HELLO");

        c.setLayout(null);
        label.setSize(100,20);
        label.setLocation(50,50);
        c.add(label);
        c.addKeyListener(new MyKeyListener());

        setSize(300,300);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component c = (Component)e.getSource();
                c.setFocusable(true);
                c.requestFocus();
            }
        });
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();

            switch(keyCode){
                case KeyEvent.VK_UP:
                    label.setLocation(label.getX(),label.getY()-FLYING_UNIT);
                    break;
                case KeyEvent.VK_DOWN:
                    label.setLocation(label.getX(),label.getY()+FLYING_UNIT);
                    break;
                case KeyEvent.VK_LEFT:
                    label.setLocation(label.getX()-FLYING_UNIT, label.getY());
                    break;
                case KeyEvent.VK_RIGHT:
                    label.setLocation(label.getX()+FLYING_UNIT, label.getY());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new FlyingTextEx();
    }
}
