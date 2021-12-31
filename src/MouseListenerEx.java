import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseListenerEx extends JFrame {
    private JLabel label = null;
    public MouseListenerEx(){
        setTitle("Mouse 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        label = new JLabel("Hello");

        c.setLayout(null);
        c.addMouseListener(new MyMouseListener());
        label.setSize(50,20);
        label.setLocation(30,30);
        c.add(label);

        setSize(350,150);
        setVisible(true);
    }

    private class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            label.setLocation(x,y);
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
    public static void main(String[] args) {
        new MouseListenerEx();
    }
}
