package com.lvwanjie.myapplication.javaTest.utils;

import android.text.TextUtils;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class AmountUtils {




    public static void main(String args[]){
//        long a = 103208504534l;
//        System.out.println(getSegmentAmount(a));
//        System.out.println(NumberFormat.getInstance().format(a));
        testFloat(null);
    }


    public static void testFloat(String s){

        BigDecimal bigDecimal = new BigDecimal(s);
        int value = new BigDecimal(s).intValue();
        System.out.println(value);

    }

    public static String getSegmentAmount(long amount){
        String amountStr = "";
        while (amount > 0){
            long remainder = amount % 1000;
            amount = amount / 1000;
            String remainderStr = "";
            if(amount > 0){
                remainderStr = thousandNumFillZero(remainder);
            }else {
                remainderStr = remainder + "";
            }
            if("".equals(amountStr)){
                amountStr = remainderStr;
            }else {
                amountStr = remainderStr + ","+amountStr;
            }
        }
        return amountStr;
    }

    public static String thousandNumFillZero(long num){
        if(num / 100 >0){
            return num + "";
        }
        if(num / 10 > 0){
            return "0"+num;
        }
        return "00"+num;
    }
}
