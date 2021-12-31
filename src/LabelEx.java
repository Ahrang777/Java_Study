import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame {
    public LabelEx(){
        setTitle("LabelEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JLabel textLabel = new JLabel("문자열 레이블");

        ImageIcon imageIcon = new ImageIcon("images/apple.png");
        JLabel imageLabel = new JLabel(imageIcon);

        ImageIcon image = new ImageIcon("images/banana.png");
        JLabel label = new JLabel("텍스트+이미지",image,SwingConstants.CENTER);

        c.add(textLabel);
        c.add(imageLabel);
        c.add(label);

        setSize(400,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LabelEx();
    }
}
