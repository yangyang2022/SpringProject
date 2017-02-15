package com.yangyang.Java8;

import org.junit.Test;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Persons{
    private String name;
    private int age;

    public Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int ageDifference(Persons person){
        return age - person.getAge();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d ",name,age);
    }
}

class Asset{
    public enum AssetType{BOND,STOCK}
    private final AssetType type;
    private final int value;

    public Asset(AssetType type, int value) {
        this.type = type;
        this.value = value;
    }

    public AssetType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }
}
@FunctionalInterface
interface UseInatance<T,X extends Throwable>{
    void accept(T instance) throws X;
}

class FileWriterDemo {

    private final FileWriter writer;

    private FileWriterDemo(String filePath) throws IOException {
        this.writer = new FileWriter(filePath);
    }
    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    private void close() throws IOException {
        System.out.println("fileWriter closing ... ");
        writer.close();
    }
    public static void use(String fileName,UseInatance<FileWriterDemo,IOException> block) throws IOException{
        FileWriterDemo writer = new FileWriterDemo(fileName);
        try {
            block.accept(writer);
        } finally {
            writer.close();
        }
    }
}

class LockDemo{
    Lock lock = new ReentrantLock();

    public static void runBlock(Lock lock,Runnable block){
        try {
            lock.lock();
            block.run();
        } finally {
            System.out.println("unlock ... ");
            lock.unlock();
        }
    }
}
public class Demo {

    private static void printPersons(List<Persons> personss){
        personss.forEach(System.out::println);
    }
    private static Consumer<Persons> printPersons = System.out::println;

    public static void useBufferedWriter(String fileName, UseInatance<BufferedReader,IOException> block){
        BufferedReader br = null;
        try {
             br = new BufferedReader(new FileReader(fileName));
             block.accept(br);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("bufferReader closing ... ");
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void useBufferReader2(String fileName,Consumer<BufferedReader> block){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            block.accept(br);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                System.out.println("consumer closing ... ");
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    public void testManagerResource() throws IOException {

        String filePath = "C:\\code\\temp.txt";

        //FileWriterDemo writer = new FileWriterDemo(filePath);
        //writer.writeStuff("hello fileWriter ... ");
        //writer.close();

        //try(FileWriterDemo writer = new FileWriterDemo(filePath)){
        //    writer.writeStuff("hello yangyang");
        //    System.out.println("resource done !!!");
        //}
        //FileWriterDemo.use(filePath,writer -> writer.writeStuff("hello lambda!!!"));

        useBufferedWriter(filePath,br -> System.out.println(br.readLine() + br.readLine()));

        useBufferReader2(filePath, br -> {
            try {
                System.out.println(br.readLine() + br.readLine() + br.readLine() +br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    @Test
    public void testDemo5() {
        List<String> paths = Arrays.asList(".");
        List<UseInatance> inatances = paths.stream()
                .map(path -> (UseInatance) instance -> new File(path).getCanonicalFile())
                .collect(Collectors.toList());


    }
    @Test
    public void testDemo4() {
        final List<Asset> assets = Arrays.asList(
                new Asset(Asset.AssetType.BOND, 1000),
                new Asset(Asset.AssetType.BOND, 2000),
                new Asset(Asset.AssetType.STOCK, 3000),
                new Asset(Asset.AssetType.STOCK, 4000)
        );
        int sum = assets.stream().mapToInt(Asset::getValue).sum();
        System.out.println("sum: "+sum);

    }
    @Test
    public void testDemo1() {
        String s = String.join(",", Arrays.asList("hello", "world", "ni", "hao", "a"));
        System.out.println(s);

        List<String> list = Arrays.asList("hello","world","ni","hao");
        list.stream().min(String::compareTo).ifPresent(System.out::print);
    }

    @Test
    public void testDemo2() throws IOException {
        List<Persons> persons = Arrays.asList(
                new Persons("Greg",35),
                new Persons("John",20),
                new Persons("Sara",21),
                new Persons("Jane",21)
        );

        //persons.stream().sorted(Persons::ageDifference).forEach(printPersons);

        //persons.stream().sorted(Comparator.comparing(Persons::getAge).thenComparing(Persons::getName))
        //        .collect(Collectors.toList()).forEach(printPersons);

        //Map<Character, Optional<Persons>> map = persons.stream().collect(groupingBy(p -> p.getName().charAt(0),
        //        reducing(BinaryOperator.maxBy(Comparator.comparing(Persons::getAge)))));
        //map.forEach((k,v)->{
        //    v.ifPresent(e-> System.out.println(e+ " -> "+v.get()));
        //});

        //Files.list(Paths.get(".")).forEach(System.out::println);
        //Files.newDirectoryStream(Paths.get("."),path -> path.toString().endsWith(".java"))
        //        .forEach(System.out::println);
        //
        //File[] files = new File(".").listFiles(File::isHidden);
        //System.out.println(files.length);

        //String filePath = "F:\\mavenproject\\SpringProject\\JavaDemo\\src";
        //System.out.println(new File(filePath).listFiles().length);
        //
        //List<File> files = Stream.of(new File(filePath).listFiles())
        //        .flatMap(file -> file.listFiles() != null ? Stream.of(file) : Stream.of(file.listFiles()))
        //        .collect(Collectors.toList());
        //System.out.println("size: "+files.size());

        //Path path = Paths.get(filePath);
        //
        //WatchService watchService = path.getFileSystem().newWatchService();
        //path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

    }

    private static String handlerStr(String s,Map<Integer,Integer> index,int number){
        List<Integer> indexs = new ArrayList<>();
        index.forEach((k,v)-> indexs.add((v-k)));
        String num = String.valueOf(number);
        String[] nums = new String[indexs.size()];
        int len = 0;
        for (int i = 0; i < indexs.size(); ++i) {
            nums[i] = num.substring(len,len+indexs.get(i));
            len += indexs.get(i);
        }
        String res = "";
        String[] ss = s.split("\\d+");
        for (int i = 0; i < nums.length; ++i) {
            res += (ss[i]+nums[i]);
        }
        return res;
    }

    private static String[] getNumbers(String s,int number){

        Map<Integer,Integer> indexs = new LinkedHashMap<>();
        Matcher matcher = Pattern.compile("(\\d+)").matcher(s);
        String temp = "";
        while (matcher.find()){
            indexs.put(matcher.start(),matcher.end());
            temp += matcher.group();
        }
        System.out.println("Number: "+temp);
        int temp1 = Integer.parseInt(temp);
        String[] res = new String[number];
        for (int i = 0; i < res.length; ++i) {
            res[i] = handlerStr(s,indexs,temp1+i+1);
        }
        return res;
    }
    @Test
    public void testDemo3() {
        String s = "ds7df6sd78g6f87g9";
        String[] ss = getNumbers(s,15);
        for(String s1:ss){
            System.out.println(s1);
        }
    }
}
