import java.util.Scanner;

class CountingThread implements Runnable{
    @Override
    public void run(){
        System.out.println("스레드 실행 시작");
        for(int i=1;i<=10;i++)
            System.out.print(i+" ");
        System.out.println();
        System.out.println("스레드 종료");
    }
}

public class Test1_class13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("아무 키나 입력>> ");
        sc.nextLine();
        sc.close();

        Thread th = new Thread(new CountingThread());
        th.start();
    }
}
