package com.uisuite.utils.excelreaders;

import com.creditdatamw.zerocell.converter.Converter;

public class StringToBooleanConverter implements Converter<Boolean> {
    public Boolean convert(String s, String s1, int i){
        return s.equalsIgnoreCase("yes")?Boolean.TRUE:Boolean.FALSE;
    }
}
