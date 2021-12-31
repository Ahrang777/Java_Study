import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Class10_test3 extends JFrame {
    private JLabel la = null;

    public Class10_test3(){
        setTitle("Test3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        la = new JLabel("Love Java");

        c.setLayout(new FlowLayout());
        c.add(la);
        la.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                if(keyCode == KeyEvent.VK_LEFT){
                    if(la.getText().equals("Love Java"))
                        la.setText("avaJ evoL");
                    else if(la.getText().equals("avaJ evoL"))
                        la.setText("Love Java");
                }
            }
        });

        setSize(300,150);
        setVisible(true);

        la.setFocusable(true);
        la.requestFocus();

    }

    public static void main(String[] args) {
        new Class10_test3();
    }
}
