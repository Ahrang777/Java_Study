import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnonymousClassListener extends JFrame {
    public AnonymousClassListener(){
        setTitle("Action 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                JButton btn = (JButton) e.getSource();
                if(btn.getText().equals("Action"))
                    btn.setText("액션");
                else
                    btn.setText("Action");
                setTitle(btn.getText());
            }
        });
        contentPane.add(btn);
        setSize(350,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnonymousClassListener();
    }
}
