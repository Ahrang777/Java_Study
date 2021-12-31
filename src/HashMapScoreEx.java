import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapScoreEx {
    public static void main(String[] args) {
        HashMap<String, Integer> scoreMap = new HashMap<>();

        scoreMap.put("김성동",97);
        scoreMap.put("황기태",88);
        scoreMap.put("김남윤",98);
        scoreMap.put("이재문",70);
        scoreMap.put("한원선",99);

        Set<String> keys = scoreMap.keySet();
        Iterator<String> it = keys.iterator();

        while(it.hasNext()){
            String name = it.next();
            int score = scoreMap.get(name);
            System.out.println(name+":"+score);
        }
    }
}
