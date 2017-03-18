package utils;


import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class StaticUtils {

    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";

    public static final String REDIRECT = "redirect:";
    public static final String FORWARD = "forward:";

    public static final String SCOPE_PROTOTYPE = "prototype";

    public static Consumer print = System.out::print;
    public static Consumer println = System.out::println;
    public static BiConsumer printMap = (k,v)-> System.out.println(k+" : "+v);

    public static final String encoding = System.getProperty("file.encoding");//utf-8

    public static void printArray(Object[] objs){
        Arrays.stream(objs).forEach(println);
    }

    public static final Integer PORT = 8888;
    public static final String HOST = "127.0.0.1";

    public static final Charset UTF8 = Charset.forName("utf-8");

}
