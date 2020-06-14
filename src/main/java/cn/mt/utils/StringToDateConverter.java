package cn.mt.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname StringToDateConversion
 * @Created by loumt
 * @email looty_loumt@hotmail.com
 * @Description TODO
 * @Date 2020/6/12 15:28
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String s) {
        if(s == null){
            throw new RuntimeException("请传入数据!");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(s);
        }catch (Exception e){
            throw new RuntimeException("时间转换出现错误!");
        }

    }
}
