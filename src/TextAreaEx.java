import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaEx extends JFrame {
    private JTextField tf = new JTextField(20);
    private JTextArea ta = new JTextArea(7,20);

    public TextAreaEx(){
        setTitle("TextAreaEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("입력후 <Enter>키 입력"));
        c.add(tf);
        c.add(new JScrollPane(ta));

        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField text = (JTextField)e.getSource();
                ta.append(text.getText()+"\n");
                tf.setText("");
            }
        });

        setSize(300,300);
        setVisible(true);
/*
        ta.setFocusable(true);
        ta.requestFocus();

 */
    }

    public static void main(String[] args) {
        new TextAreaEx();
    }
}
