import java.util.StringTokenizer;

public class StringTokenizerEx {
    public static void main(String[] args) {
        String str = "1+2+3+4+5+6+7+8+9+10";
        StringTokenizer st = new StringTokenizer(str,"+");

        int sum=0;
        while(st.hasMoreTokens())
            sum+=Integer.parseInt(st.nextToken());
        System.out.println(sum);
    }
}
