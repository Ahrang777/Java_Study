import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

class MyLabelTest3 extends JLabel implements Runnable {
    private Thread timerThread = null;

    public String makeClockText(){
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int min = now.get(Calendar.MINUTE);
        int sec = now.get(Calendar.SECOND);
        String clockText = hour+":"+min+":"+sec;
        return clockText;
    }

    public MyLabelTest3(){
        setText(makeClockText());
        setFont(new Font("TimesRoman", Font.ITALIC, 50));
        setHorizontalAlignment(JLabel.CENTER);
        timerThread = new Thread(this);
        timerThread.start();
    }

    @Override
    public void run(){
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            setText(makeClockText());
        }
    }
}

public class Test3_class13 extends JFrame {
    public Test3_class13(){
        setTitle("Test3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();

        c.add(new MyLabelTest3());

        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Test3_class13();
    }
}
