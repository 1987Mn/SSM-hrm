package com.lzw.hrmsys.util.convers;

import com.lzw.hrmsys.util.exception.BaseException;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConver implements Converter<String, Date>{
    private String pattern;

    public StringToDateConver(String pattern){
        this.pattern = pattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(s);
            return parse;
        } catch (ParseException e) {
            throw new BaseException("数据类型转换出错");
        }
    }

}

