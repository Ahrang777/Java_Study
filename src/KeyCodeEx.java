import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyCodeEx extends JFrame {
    private JLabel label = null;

    public KeyCodeEx(){
        setTitle("KeyCodeEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel();
        Container c = getContentPane();

        c.addKeyListener(new MyKeyListener());
        c.add(label);

        setSize(300,150);
        setVisible(true);

        c.setFocusable(true);
        c.requestFocus();
    }

    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e){
            Component c = (Component)e.getSource();

            label.setText(KeyEvent.getKeyText(e.getKeyCode())+"키가 입력");

            if(e.getKeyChar() == '%')
                c.setBackground(Color.yellow);
            else if(e.getKeyCode() == KeyEvent.VK_F1)
                c.setBackground(Color.green);
        }
    }

    public static void main(String[] args) {
        new KeyCodeEx();
    }
}
