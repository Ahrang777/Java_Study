import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Test9_class13 extends JFrame {
    public Test9_class13(){
        setTitle("Test9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamblingPanel());
        setSize(300,220);
        setVisible(true);
    }

    class GamblingPanel extends JPanel{
        private JLabel[] numbers = new JLabel[3];
        private JLabel result = new JLabel("마우스로 클릭할때 마다 게임합니다.");
        private GamblingThread th = new GamblingThread(numbers, result);

        public GamblingPanel(){
            setLayout(null);

            for(int i=0;i<numbers.length;i++){
                numbers[i] = new JLabel("0");
                numbers[i].setOpaque(true);
                numbers[i].setBackground(Color.MAGENTA);
                numbers[i].setForeground(Color.YELLOW);
                numbers[i].setHorizontalAlignment(JLabel.CENTER);
                numbers[i].setFont(new Font("Tahoma", Font.ITALIC, 30));
                numbers[i].setSize(60,30);
                numbers[i].setLocation(30+80*i, 50);
                add(numbers[i]);
            }

            result.setHorizontalAlignment(JLabel.CENTER);
            result.setSize(250, 20);
            result.setLocation(30, 120);
            add(result);
            th.start();

            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if(th.isReady())
                        th.startForGambling();
                }
            });
        }

    }

    class GamblingThread extends Thread{
        private JLabel[] numbers = null;
        private JLabel result = null;
        private boolean gambling = false;
        private int delay = 200;

        public GamblingThread(JLabel[] numbers, JLabel result){
            this.numbers = numbers;
            this.result = result;
        }

        synchronized public void waitForGambling(){
            if(!gambling){
                try{
                    this.wait();
                } catch (InterruptedException e){
                    return;
                }
            }
        }

        synchronized public void startForGambling(){
            gambling = true;
            this.notify();
        }

        boolean isReady() {
            return !gambling; // 게임 중이면 준비되지 않았음
        }

        @Override
        public void run(){
            while(true){
                waitForGambling();

                try {
                    int number1 = (int)(Math.random()*5);
                    int number2 = (int)(Math.random()*5);
                    int number3 = (int)(Math.random()*5);

                    numbers[0].setForeground(Color.BLUE);
                    sleep(delay);
                    numbers[0].setForeground(Color.YELLOW);
                    numbers[0].setText(Integer.toString(number1));

                    numbers[1].setForeground(Color.BLUE);
                    sleep(delay);
                    numbers[1].setForeground(Color.YELLOW);
                    numbers[1].setText(Integer.toString(number2));

                    numbers[2].setForeground(Color.BLUE);
                    sleep(delay);
                    numbers[2].setForeground(Color.YELLOW);
                    numbers[2].setText(Integer.toString(number3));

                    if(number1==number2 && number2==number3){
                        result.setText("축하");
                    }
                    else{
                        result.setText("아쉽");
                    }

                    gambling = false;
                } catch (InterruptedException e){
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Test9_class13();
    }
}