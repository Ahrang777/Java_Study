import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Class10_test5 extends JFrame {
    private final int FONT_SIZE = 5;
    private JLabel la = null;

    public Class10_test5(){
        setTitle("test5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        la = new JLabel("Love Java");

        c.setLayout(new FlowLayout());
        la.setFont(new Font("Arial",Font.PLAIN,10));
        la.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                Font f = la.getFont();
                int size = f.getSize();

                switch (keyChar){
                    case '+':
                        la.setFont(new Font("Arial",Font.PLAIN,size+FONT_SIZE));
                        break;
                    case '-':
                        if(size>FONT_SIZE)
                            la.setFont(new Font("Arial",Font.PLAIN,size-FONT_SIZE));
                        break;

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
        new Class10_test5();
    }
}
