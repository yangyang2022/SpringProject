package com.yangyang.convertor;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToDateConvertor implements Converter<String,LocalDate> {
    @Override
    public LocalDate convert(String source) {
        System.out.println("convertor called ... ");
        return LocalDate.parse(source,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
