import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxItemEventEx extends JFrame {
    private JCheckBox[] fruits = new JCheckBox[3];
    private String[] names = {"사과", "배", "체리"};
    private JLabel sumLabel = null;
    public CheckBoxItemEventEx(){
        setTitle("CheckBoxItemEventsEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("사과 100원, 배 500원, 체리 2000원"));

        MyItemListener listener = new MyItemListener();
        for(int i=0;i<fruits.length;i++){
            fruits[i] = new JCheckBox(names[i]);
            fruits[i].setBorderPainted(true);
            fruits[i].addItemListener(listener);
            c.add(fruits[i]);
        }

        sumLabel = new JLabel("현재 0원 입니다.");
        c.add(sumLabel);

        setSize(250,200);
        setVisible(true);
    }

    private class MyItemListener implements ItemListener {
        private int sum = 0 ;

        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED){
                if(e.getItem() == fruits[0])
                    sum+=100;
                else if(e.getItem() == fruits[1])
                    sum+=500;
                else
                    sum+=2000;
            }
            else{
                if(e.getItem() == fruits[0])
                    sum-=100;
                else if(e.getItem() == fruits[1])
                    sum-=500;
                else
                    sum-=2000;
            }
            sumLabel.setText("현재 "+sum+"원 입니다.");
        }
    }

    public static void main(String[] args) {
        new CheckBoxItemEventEx();
    }
}
