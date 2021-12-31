@FunctionalInterface
interface GenericMyFunction<T>{
    void print(T x);
}

public class LambdaEx2 {
    public static void main(String[] args) {
        GenericMyFunction<String> f1 = (x)-> System.out.println(x.toString());
        f1.print("ABC");

        GenericMyFunction<Integer> f2 = (x)-> System.out.println(x.toString());
        f2.print(100);
    }
}
