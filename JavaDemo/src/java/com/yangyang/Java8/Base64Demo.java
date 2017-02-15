package com.yangyang.Java8;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Demo {
    @Test
    public void testDemo() {
        String str = "base64 final in java8 ";

        String encoder = Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println("encode: "+encoder);

        String decoder = new String(Base64.getDecoder().decode(encoder),StandardCharsets.UTF_8);
        System.out.println("decoder: "+decoder);


    }
}
