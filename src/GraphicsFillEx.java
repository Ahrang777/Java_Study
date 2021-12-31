import javax.swing.*;
import java.awt.*;

public class GraphicsFillEx extends JFrame {
    private MyPanel panel = new MyPanel();

    public GraphicsFillEx(){
        setTitle("GraphicsFillEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        setSize(100,350);
        setVisible(true);
    }

    private class MyPanel extends JPanel {
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(10,10,50,50);
            g.setColor(Color.BLACK);
            g.drawRect(10,10,50,50);
        }
    }

    public static void main(String[] args) {
        new GraphicsFillEx();
    }
}
