import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseListenerAllEx extends JFrame {
    private JLabel lb = null;

    public MouseListenerAllEx(){
        setTitle("Mouse 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lb = new JLabel("No Mouse Event");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        MyMouseListener listener = new MyMouseListener();
        c.addMouseListener(listener);
        c.addMouseMotionListener(listener);

        c.add(lb);
        setSize(300,200);
        setVisible(true);
    }

    private class MyMouseListener implements MouseListener, MouseMotionListener{

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
            lb.setText("mousePressed ("+e.getX()+", "+e.getY()+")");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            lb.setText("mouseReleased ("+e.getX()+", "+e.getY()+")");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            Component c = (Component)e.getSource();
            c.setBackground(Color.cyan);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            Component c = (Component)e.getSource();
            c.setBackground(Color.yellow);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            lb.setText("mouseDragged ("+e.getX()+", "+e.getY()+")");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            lb.setText("mouseMoved ("+e.getX()+", "+e.getY()+")");
        }
    }

    public static void main(String[] args) {
        new MouseListenerAllEx();
    }
}
