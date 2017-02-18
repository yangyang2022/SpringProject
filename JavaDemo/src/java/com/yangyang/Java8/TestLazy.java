package com.yangyang.Java8;


import com.utils.SleepUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Heavy{
    public Heavy(){
        System.out.println("Heavy created ... ");
        SleepUtils.sleep4Second();
    }

    @Override
    public String toString() {
        return "quiet heavy ... ";
    }
}
class HeavyHolder{
    private Heavy heavy;
    public Heavy getHeavy(){
        if(heavy == null){
            heavy = new Heavy();
        }
        return heavy;
    }
}
class EvluateDemo{
    public static boolean evaluate(final int value){
        System.out.println("evaluate ... ");
        SleepUtils.sleep2Second();
        return value > 200;
    }
    public static void eagerEvaluator(boolean input1,boolean input2){
        System.out.println("eagerEvaluator called ... ");
        System.out.println("accept ? : "+(input1 && input2));
        return ;
    }
    public static void lazyEvluator(Supplier<Boolean> input1,Supplier<Boolean> input2){
        System.out.println("lazy called ... ");
        System.out.println("accept? " + (input1.get() && input2.get()));
    }
}
class Tickers{
    public static final List<String> symbols = Arrays.asList(
            "AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
            "AMZN", "CRAY", "CSCO", "DELL", "GOOG", "INTC", "INTU",
            "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");
}
class YahooFinance{
    public static BigDecimal getPrice(final String ticker){
        try {
            URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s="+ticker);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String data = br.lines().skip(1).findFirst().get();
            String[] dataItems = data.split(",");
            return new BigDecimal(dataItems[dataItems.length-1]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
public class TestLazy {

    private static boolean isPrime(int num){
        return num > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(num)).noneMatch(e -> num % e == 0);
    }
    private static int primeAfter(int number){
        if(isPrime(number)){
            return number;
        }else {
            return primeAfter(number+1);
        }
    }
    private static List<Integer> primers(int fromNumber,int count){
        return Stream.iterate(primeAfter(fromNumber-1), TestLazy::primeAfter)
                .limit(count).collect(Collectors.toList());
    }

    private static int factorialRec(final int number){
        return number == 1 ? 1 : number * factorialRec(number-1);
    }

    @Test
    public void testDemo1() {

        //EvluateDemo.eagerEvaluator(EvluateDemo.evaluate(1),EvluateDemo.evaluate(2));
        //EvluateDemo.lazyEvluator(()->EvluateDemo.evaluate(1),()->EvluateDemo.evaluate(2));
        //System.out.println(isPrime(10));
        //System.out.println(primeAfter(8));
        //primers(9,10).forEach(System.out::println);

        System.out.println(factorialRec(20000));

    }

    @Test
    public void testDemo2() throws IOException {
        //BigDecimal HANDRED = new BigDecimal("100");
        //String collect = Tickers.symbols.stream()
        //        .filter(symbol -> YahooFinance.getPrice(symbol).compareTo(HANDRED) > 0)
        //        .collect(Collectors.joining(","));
        //System.out.println("stocks over 100: "+collect);

        String urlPath = "http://ichart.finance.yahoo.com/table.csv?s=ibm";
        BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(urlPath).openStream()));
        reader.lines().forEach(System.out::println);

    }
}
