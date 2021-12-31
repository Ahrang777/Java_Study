import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Class10_test1 extends JFrame {
    private JLabel la = null;

    public Class10_test1(){
        setTitle("Test1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        la = new JLabel("시작");
        la.addMouseListener(new MyMouseListener());
        c.add(la);

        setSize(300,150);
        setVisible(true);
    }

    private class MyMouseListener extends MouseAdapter {
        public void mouseEntered(MouseEvent e){
            JLabel label = (JLabel)e.getSource();
            label.setText("Love Java");
        }

        public void mouseExited(MouseEvent e){
            JLabel label = (JLabel)e.getSource();
            label.setText("사랑해");
        }
    }

    public static void main(String[] args) {
        new Class10_test1();
    }
}
