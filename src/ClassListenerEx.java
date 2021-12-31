import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassListenerEx extends JFrame {
    public ClassListenerEx(){
        setTitle("Action 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.setLayout(new FlowLayout());
        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionListener());
        c.add(btn);

        setSize(350,150);
        setVisible(true);
    }

    private class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JButton btn = (JButton)e.getSource();
            if(btn.getText().equals("Action"))
                btn.setText("액션");
            else
                btn.setText("Action");

            ClassListenerEx.this.setTitle(btn.getText());
        }
    }

    public static void main(String[] args) {
        new ClassListenerEx();
    }
}
/*
class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e){
        JButton btn = (JButton)e.getSource();
        if(btn.getText().equals("Action"))
            btn.setText("액션");
        else
            btn.setText("Action");
    }
}

 */
