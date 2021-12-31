import java.util.HashMap;
import java.util.Scanner;

public class HashMapDicEx {
    public static void main(String[] args) {
        HashMap<String, String> dic = new HashMap<>();

        dic.put("baby","아기");
        dic.put("love","사랑");
        dic.put("apple","사과");

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("찾고 싶은 단어는?");
            String eng = sc.next();
            if(eng.equals("exit")){
                System.out.println("시스템 종료...");
                break;
            }

            String kor = dic.get(eng);
            if(kor==null)
                System.out.println(kor+"는 없는 단어,,,");
            else
                System.out.println(kor);
        }
    }
}
