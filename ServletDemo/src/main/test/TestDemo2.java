import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestDemo2 {
    @Test
    public void testDemo() {

        Map<Integer,String> maps = new LinkedHashMap<Integer,String>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 10;
            }
        };
        for (int i = 0; i < 10; ++i) {
            maps.put(i, i + "");
        }
        maps.forEach((k,v)-> System.out.println(k+" -> "+v));

        for (int i = 0; i < 5; ++i) {
            maps.put(i, i + "->");
        }
        maps.forEach((k,v)-> System.out.println(k+" -> "+v));

    }
}
