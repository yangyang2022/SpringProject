import com.yangyang.utils.SleepUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BiConsumer;


public class TestDemo {

    private static BiConsumer<Integer,String> printMap = (k,v)-> System.out.println(k+" -> "+v);

    private static Set<String> cset = new HashSet<>();//new ConcurrentSkipListSet<>();

    static class MyThread extends Thread{
        public MyThread(String name){
            super(name);
        }
        @Override
        public void run() {
            int i = 0;
            while (i++ < 10){
                cset.add(Thread.currentThread().getName()+""+i);
                printSet(cset);
            }
        }
    }
    private static void printSet(Set<String> sets){
        sets.forEach(e-> System.out.print(e+" ,"));
        System.out.println();
    }

    private static void addMap(Map<Integer,String> cmap){
        cmap.put(5,"asyc");
        cmap.put(5,"asyc");
        cmap.put(1,"hello");
        cmap.put(2,"world");
        cmap.put(3,"nihao");
        cmap.put(4,"yangyang");
    }
    @Test
    public void testSkipList() {
        Map<Integer,String> cmap = new ConcurrentHashMap<>();
        Map<Integer,String> hmap = new HashMap<>();

        Map<Integer,String> skipMap = new ConcurrentSkipListMap<>();

        addMap(hmap);
        addMap(cmap);
        addMap(skipMap);

        //cmap.forEach(printMap);
        //hmap.forEach(printMap);
        skipMap.forEach(printMap);

    }

    @Test
    public void testSets() {
        new MyThread("a").start();
        new MyThread("b").start();

        SleepUtils.sleep1Second();
    }
}
