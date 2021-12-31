import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerRunnable1 implements Runnable {
    private JLabel timerLabel = null;

    public TimerRunnable1(JLabel timerLabel){
        this.timerLabel = timerLabel;
    }

    @Override
    public void run() {
        int n=0;
        while(true){
            timerLabel.setText(Integer.toString(n));
            n++;
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                return;
            }
        }
    }
}

public class ThreadInterruptEx extends JFrame {
    public ThreadInterruptEx(){
        setTitle("ThreadInterruptEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));

        Thread th = new Thread(new TimerRunnable1(timerLabel));
        c.add(timerLabel);

        JButton btn = new JButton("Kill Timer");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                th.interrupt();
                JButton btn = (JButton)e.getSource();
                btn.setEnabled(false);
            }
        });
        c.add(btn);

        setSize(300,170);
        setVisible(true);

        th.start();
    }

    public static void main(String[] args) {
        new ThreadInterruptEx();
    }
}
