package com.yangyang.Java8;

import com.utils.SleepUtils;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class TestCompleteFuture {

    private static String getName(){
        SleepUtils.sleep1Second();
        return "yangyang";
    }
    private static int getAge(){
        SleepUtils.sleep4Second();
        return 22;
    }
    private static String getAddress(){
        SleepUtils.sleep3Second();
        return "anhui Wuhu";
    }
    @Test
    public void testDemo1() throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(8);

        //CompletableFuture<Void> future = CompletableFuture
        //        .supplyAsync(() -> getName(),service)
        //        .thenAccept(name -> System.out.println("name: " + name));
        //
        //while (!future.isDone());

        //CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> getName(), service)
        //        .whenComplete((name, ex) -> System.out.println("name is: " + name))
        //        .thenApplyAsync(age -> getAge())
        //        .thenAccept(age -> System.out.println("age is: " + age))
        //        .thenApplyAsync(address -> getAddress())
        //        .thenAccept(address -> System.out.println("address: " + address))
        //        .thenRun(() -> System.out.println("mission success!!!"));
        //
        //while (!future.isDone());
        //
        //CompletableFuture<String> futureName = CompletableFuture.supplyAsync(() -> getName());
        //CompletableFuture<Integer> futureAge = CompletableFuture.supplyAsync(() -> getAge());
        //CompletableFuture<String> futureAddress = CompletableFuture.supplyAsync(() -> getAddress());
        //
        //CompletableFuture<Void> tt = futureName.thenCombine(futureAge,
        //        (name, age) -> name + " --> " + age)
        //        .thenAccept(name -> System.out.println("name is: " + name));
        //
        //while (!tt.isDone());

        //List<String> words = Arrays.asList("hello","world","hello","yangyang","nihao","hehe");
        //Map<String,LongAdder> maps = new ConcurrentHashMap<>();
        //for(String s:words){
        //    maps.computeIfAbsent(s,e->new LongAdder()).increment();
        //}
        //System.out.println(maps);
        //
        //Map<String,Integer> maps2 = new ConcurrentHashMap<>();
        //for(String s: words){
        //    maps2.merge(s,1,(value,init)->value+init);
        //}
        //System.out.println(maps2);


        CompletableFuture<String> closing = new CompletableFuture<>();
        Stream<String> strings = Stream.of("one","two","three","four","yangyang","he","hi");

        CompletableFuture<String> future = strings.onClose(() -> closing.complete("closing"))
                .map(CompletableFuture::completedFuture)
                .filter(cf -> cf.join().length() < 4)
                .reduce(
                        closing,
                        (cf1, cf2) -> cf1.thenCombine(cf2, (s1,s2)->s1+" - "+s2)
                );

        strings.close();

        while (!future.isDone());
        System.out.println("get: "+future.get());

    }
}
