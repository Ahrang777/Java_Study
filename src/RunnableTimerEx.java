import javax.swing.*;
import java.awt.*;

class TimerRunnable implements Runnable{
    private JLabel timerLabel = null;

    public TimerRunnable(JLabel timerLabel){
        this.timerLabel = timerLabel;
    }

    @Override
    public void run() {
        int n=0;
        while(true) {
            timerLabel.setText(Integer.toString(n));
            n++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class RunnableTimerEx extends JFrame {
    public RunnableTimerEx(){
        setTitle("RunnableTimerEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel timerLabel = new JLabel();
        timerLabel.setFont(new Font("Gothic",Font.ITALIC,80));
        c.add(timerLabel);

        Thread th = new Thread(new TimerRunnable(timerLabel));

        setSize(250,150);
        setVisible(true);

        th.run();
    }
    public static void main(String[] args) {
        new RunnableTimerEx();
    }
}
