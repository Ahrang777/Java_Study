import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Class10_test2 extends JFrame {
    public Class10_test2(){
        setTitle("test2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        MyMouseListener listener = new MyMouseListener();

        c.setBackground(Color.green);
        c.addMouseMotionListener(listener);
        c.addMouseListener(listener);

        setSize(300,150);
        setVisible(true);
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            Container c = (Container) e.getSource();
            c.setBackground(Color.yellow);
        }

        @Override
        public void mouseReleased(MouseEvent e){
            Component c = (Component)e.getSource();
            c.setBackground(Color.green);
        }
    }

    public static void main(String[] args) {
        new Class10_test2();
    }
}
