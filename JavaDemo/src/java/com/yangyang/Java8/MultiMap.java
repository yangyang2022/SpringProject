package com.yangyang.Java8;

import java.util.*;

public class MultiMap {

    private static void getSize(Map<String,Set<String>> multiMap ){
        int keySize = multiMap.keySet().size();
        int valueSize = multiMap.values().stream().mapToInt(Set::size).sum();
        System.out.println("keySize: "+keySize+" ,valueSize: "+valueSize);
    }
    public static void main(String[] args) {

        Map<String,Set<String>> multiMap = new HashMap<>();

        //multiMap.put(str,i)
        //multiMap.computeIfAbsent(str,e->new HashSet<>()).add(str);

        //multiMap.remove(str,i)
        //multiMap.computeIfPresent(k,(k1,set)->set.remove(v) && set.isEmpty()?null:set);

        //contains(str,i)
        //multiMap.getOrDefault(str,Collections.emptySet()).contains(i)

        String str = "hello";
        Arrays.asList("shen","yang","ni","hao").forEach(e->
                multiMap.computeIfAbsent(str,i->new HashSet<>()).add(e));

        getSize(multiMap);
        System.out.println(multiMap);

        multiMap.computeIfPresent(str,(k1,set)->set.remove("shen") && set.isEmpty()? null:set);
        getSize(multiMap);
        System.out.println(multiMap);

        boolean contains = multiMap.getOrDefault("hello", Collections.emptySet()).contains("yang");
        System.out.println("contains: "+contains);

    }
}
