import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

public class GraphicsDrawLineMouseEx extends JFrame {
    private MyPanel panel = new MyPanel();

    public GraphicsDrawLineMouseEx(){
        setTitle("drawing Line by Mouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);
        setSize(300,300);
        setVisible(true);
    }

    private class MyPanel extends JPanel{
        private ArrayList<Point> aStart = new ArrayList<>();
        private ArrayList<Point> aEnd = new ArrayList<>();

        public MyPanel(){
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Point start = e.getPoint();
                    aStart.add(start);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Point end = e.getPoint();
                    aEnd.add(end);
                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLUE);

            for(int i=0;i<aStart.size();i++){
                Point start = aStart.get(i);
                Point end = aEnd.get(i);

                g.drawLine((int)start.getX(),(int)start.getY(),(int)end.getX(),(int)end.getY());
            }
        }
    }

    public static void main(String[] args) {
        new GraphicsDrawLineMouseEx();
    }
}
