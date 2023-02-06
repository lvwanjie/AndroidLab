package com.lvwanjie.myapplication.javaTest.testPattern;

import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatCheckUtils {

    private static final String specialCharPattern= "[\\u00A0\\s\"`~!@#$%^&*()+=|{}':;,\\[\\].<>/?！￥…—【】‘；：”“。，、？_\\\\（）「」]";
    private static final String dataPattern1 = "^((19[0-9]\\d)|(2((0[0-9][0-9])|(1[0][0]))))年((0?[1-9])|(1[0-2]))月((0?[1-9])|([1-2][0-9])|30|31)日$";
    private static final String dataPattern2 = "^((19[0-9]\\d)|(2((0[0-9][0-9])|(1[0][0])))).((0?[1-9])|(1[0-2])).((0?[1-9])|([1-2][0-9])|30|31)$";

    //替换特殊字符
    public static String specialCharRemove(String content){
        Pattern pattern = Pattern.compile(specialCharPattern);
        Matcher matcher = pattern.matcher(content);
        String replaceStr = matcher.replaceAll("");
        return replaceStr;
    }

    //身份证有效期格式校验
    public static boolean idValidityPeriodCheck(String content){
        if(content != null){
            String[] dates = content.split("-",-1);
            if(dates.length == 2){
                boolean startCheck = Pattern.matches(dataPattern2,dates[0]);
                boolean endCheck = Pattern.matches(dataPattern2,dates[1]) || "长期".equals(dates[1]);
//                    || TextUtils.equals(dates[1],"长期");
                return startCheck && endCheck;
            }
        }
        return false;
    }

    public static void main(String args[]){
        String idPeriod1 = "2022.1.1-长期-";
        boolean b =  idValidityPeriodCheck(idPeriod1);
        System.out.println(b);
    }
}
