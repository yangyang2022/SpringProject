package com.yangyang.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameUtil {
    static String[] firstName = new String[]{"张","牛","刘","李","吕","付","福","王","汪",
        "赵","孔","谈","谭","弹","孙","沈","夏侯",
            "令狐","上官","欧阳","司马","诸葛","曹","关","干"
    };
    static String[] centerName = {"立","祝","共","都","高","录","额","人","达","与","莫","亮","与"};
    static String[] lastName = {
            "强","颖","备","亮","云","正","冲","兄弟","达","大","小","关","立","与","玉","刘",
            "秒","米","个","葛","准","尊","淳","庙","立","更","浩","耗","浩","豪","名正","之风","永锋"
    };
    static Random ran = new Random();

    public static List<String> getNames(int num){
        List<String> names = new ArrayList<>();
        while (num-- > 0 ) names.add(getName());
        return names;
    }
    private static String getName(){
        int r = ran.nextInt(5);
        if(r < 2){
            // 3
            return firstName[ran.nextInt(firstName.length)]+
                    centerName[ran.nextInt(centerName.length)]+
                    lastName[ran.nextInt(lastName.length)];
        }else{
            return firstName[ran.nextInt(firstName.length)]+
                    lastName[ran.nextInt(lastName.length)];
        }
    }
}
