import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Class10_test4 extends JFrame {
    private JLabel la = null;

    public Class10_test4(){
        setTitle("test4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        la = new JLabel("Love Java");

        c.setLayout(new FlowLayout());
        la.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                String str = la.getText();

                if(keyCode == KeyEvent.VK_LEFT){
                    String sub1 = str.substring(0,1);
                    String sub2 = str.substring(1);
                    String result = sub2+sub1;
                    la.setText(result);
                }
            }
        });
        c.add(la);

        setSize(300,150);
        setVisible(true);

        la.setFocusable(true);
        la.requestFocus();
    }

    public static void main(String[] args) {
        new Class10_test4();
    }
}
