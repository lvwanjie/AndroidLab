package com.lvwanjie.myapplication.javaTest.testPattern;

import android.os.Build;
import android.os.PatternMatcher;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    public static void main(String args[]){

//      testDataFormat();
        testSPattern();
//        TestDPattern();

    }

    public static void testDataFormat(){
        String pattern = "";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy月MM-dd");
        String dataStr = simpleDateFormat.format(new Date());
        simpleDateFormat.setLenient(false);
        dataStr += "ff";
        System.out.println(dataStr);
        try {
            dataStr = "2023月02-011";
            Date date = simpleDateFormat.parse(dataStr);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("error");
        }
    }


    public static void TestDPattern(){
        String s = "2023年02月30日";
        String pattern = "^((19[0-9]\\d)|(2((0[0-9][0-9])|(1[0][0]))))年((0?[1-9])|(1[0-2]))月((0?[1-9])|([1-2][0-9])|30|31)日$";
        boolean m = Pattern.matches(pattern, s);
        System.out.println(m);
    }

    public static void testSPattern(){
//        String pattern = ""

        String ss = "[\\[a \\]]";
        Pattern.compile(ss);
        String pattern= "[\\u00A0\\s\"`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…—【】‘；：”“。，、？_\\\\（）「」]";
        System.out.println(pattern);
        String s = "12\"\"@[\\\\\"「{;4,8和\'";
//        boolean m = Pattern.matches(pattern,s);
//        s.replaceAll(pattern,"");

        Pattern   p   =   Pattern.compile(pattern);
        Matcher m   =   p.matcher(s);
        System.out.println(s);
        System.out.println(m.replaceAll(""));

    }
}
