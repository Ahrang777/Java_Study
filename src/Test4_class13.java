import javax.swing.*;
import java.awt.*;

/*
class MyLabelTest4 extends JLabel implements Runnable{
    int x;
    int y;

    public MyLabelTest4(int x,int y){
        this.x = x;
        this.y = y;
        setText("진동 레이블");
        setFont(new Font("TimesRoman", Font.ITALIC, 20));
        setHorizontalAlignment(JLabel.CENTER);

        Thread th = new Thread(this);
        th.start();
    }

    @Override
    public void run(){
        while(true){
            setLocation(x,y);
            setLocation(x+10,y+10);

            try{
                Thread.sleep(100);
            } catch (InterruptedException e){return;}
            setLocation(x-10,y-10);
        }
    }
}

 */

class VibrationThread extends Thread{
    private JLabel label = null;
    int x;
    int y;

    public VibrationThread(JLabel label){
        this.label = label;
        x = label.getX();
        y = label.getY();
    }
    @Override
    public void run(){
        while(true) {
            label.setLocation(x + 10, y - 10);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                return;
            }
            label.setLocation(x, y);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                return;
            }
            label.setLocation(x - 10, y + 10);
        }
    }
}

public class Test4_class13 extends JFrame {


    public Test4_class13(){
        setTitle("Test4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        /*
        MyLabelTest4 label = new MyLabelTest4(100,100);
        label.setSize(200,30);
        label.setLocation(100,100);
        c.add(label);

         */

        JLabel label = new JLabel("진동 레이블");
        label.setSize(200,30);
        label.setLocation(100,100);
        c.add(label);

        setSize(400,400);
        setVisible(true);

        VibrationThread th = new VibrationThread(label);
        th.start();
    }

    public static void main(String[] args) {
        new Test4_class13();
    }
}
