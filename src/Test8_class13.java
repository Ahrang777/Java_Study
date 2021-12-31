import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Test8_class13 extends JFrame {
    private MyPanel panel = new MyPanel();

    public Test8_class13(){
        setTitle("Test8");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);

        setSize(300,300);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        private ImageIcon icon = null;
        private Image img = null;
        ArrayList<Point> points = new ArrayList<>();
        private SnowThread th = new SnowThread(points);

        public MyPanel(){
            setLayout(null);

            ImageIcon icon = new ImageIcon("images/bg.jpg");
            img = icon.getImage();

            // points 랜덤값으로 초기화?
            for(int i=0;i<50;i++){
                // 아직 제대로 화면에 생성x >>  getWidth 너무 일찍 호출함 0으로 나옴
                int x = (int)(Math.random()*300);
                int y = (int)(Math.random()*300);
                System.out.println(i+"번째: "+x+", "+y);
                //System.out.println(getWidth()+", "+getHeight());
                Point point = new Point(x,y);
                points.add(i,point);
            }

            th.start();
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img,0,0,getWidth(),getHeight(),null);

            g.setColor(Color.WHITE);
            for(int i=0;i<points.size();i++){
                Point p = points.get(i);
                g.fillOval(p.x, p.y, 10,10);
            }
        }
    }

    class SnowThread extends Thread{
        private ArrayList<Point> points = null;

        public SnowThread(ArrayList<Point> points){
            this.points = points;
        }

        public void changeSnowPosition(){
            for(int i=0;i<points.size();i++){
                int x = (int)points.get(i).getX();
                int y = (int)points.get(i).getY() + 10;

                if(depart(y)){
                    y = 0;
                }
                points.get(i).setLocation(x,y);

            }
        }

        public boolean depart(int y){
            if(y >= panel.getHeight())
                return true;
            else
                return false;
        }

        @Override
        public void run(){
            while(true){
                try{
                    sleep(300);

                } catch (InterruptedException e){
                    return;
                }
                changeSnowPosition();
                repaint();
            }
        }
    }

    public static void main(String[] args) {
        new Test8_class13();
    }
}
