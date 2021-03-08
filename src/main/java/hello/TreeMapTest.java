package hello;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author 86176
 * @package hello
 * @date 2021/2/18 15:53
 */
public class TreeMapTest {
    public static void main(String[] args) {
        Map<Persont, Integer> map = new TreeMap<>(new Comparator<Persont>() {
            @Override
            public int compare(Persont p1, Persont p2) {
                return p1.name.compareTo(p2.name);
            }
        });
        map.put(new Persont("Tom"), 1);
        map.put(new Persont("Bob"), 2);
        map.put(new Persont("Lily"), 3);
        for (Persont key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println(map.get(new Persont("Bob"))); // 2
    }
}

class Persont {
    public String name;
    Persont(String name) {
        this.name = name;
    }
    public String toString() {
        return "{Person: " + name + "}";
    }
}
