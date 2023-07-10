package com.lvwanjie.myapplication.javaTest.wb;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TiKU {

    public static List<Timu> timus1=new ArrayList<Timu>();
    static {
        Timu timu=new Timu("1. Java语言的扩展名是什么( )。","A. java","B. doc","C. txt","D. xls","A");

        timus1.add(timu);
    }

    public static List<Timu> timus2=new ArrayList<Timu>();
    static {
        Timu timu=new Timu("2．设int a=-2，则表达式a>>>3的值为（ ）。","A. 0","B. 3","C. 8","D. -1","C");

        timus2.add(timu);
    }

}

