package com.lvwanjie.myapplication.javaTest.wb;

import static com.lvwanjie.myapplication.javaTest.wb.TiKU.timus1;
import static com.lvwanjie.myapplication.javaTest.wb.TiKU.timus2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class TestUserLoginFrame {
    static List<KaoSheng> KaoShengs=new ArrayList<>();
    static {
        KaoSheng KaoSheng1=new KaoSheng("张三",19,"2022001",70);
        KaoShengs.add(KaoSheng1);
    }
    public static void main(String[] args) throws IOException {
        System.out.println("<<<<<<<<<<>>>>>>>>>>");
        System.out.println("计算机专业考试系统");
        Scanner input=new Scanner(System.in);
        System.out.println("____________________");
        System.out.println("请输入你选择的操作项：");
        System.out.println("1、登陆教师端");
        System.out.println("2、登陆学生端");
        int n=input.nextInt();
        while(true){
            switch (n){
                case 1:
                    System.out.println("____________________");
                    System.out.println("请操作：");
                    System.out.println("1、考生管理");
                    System.out.println("2、阅卷管理");
                    System.out.println("3、考试题库管理");
                    System.out.println("4、安全退出");
                    int m=input.nextInt();
                    while(m<=3){
                    switch (m){
                        case 1:
                            addKaoSheng();
                            break;
                        case 2:
                            System.out.println("阅卷完成");
                            break;
                        case 3:
                            addTiku1();
                            break;

                    }
                        System.out.println("____________________");
                        System.out.println("请操作：");
                        System.out.println("1、考生管理");
                        System.out.println("2、阅卷管理");
                        System.out.println("3、考试题库管理");
                        System.out.println("4、安全退出");
                        m=input.nextInt();
                    }
                    break;

                case 2:
                    System.out.println("____________________");
                    System.out.println("请操作：");
                    System.out.println("1、开始考试");
                    System.out.println("2、查询分数");
                    System.out.println("3、安全退出");
                    int x=input.nextInt();
                    while(x<=2) {

                        switch (x) {
                            case 1:
                                addTiku();
                                System.out.println("考试结束");
                                break;
                            case 2:
                                queryKaoSheng();
                        }
                        System.out.println("____________________");
                        System.out.println("请操作：");
                        System.out.println("1、开始考试");
                        System.out.println("2、查询分数");
                        System.out.println("3、安全退出");
                        x=input.nextInt();
                    }

            }
            System.out.println("____________________");
            System.out.println("请输入你选择的操作项：");
            System.out.println("1、登陆教师端");
            System.out.println("2、登陆学生端");;
            n=input.nextInt();
        }

    }
    private static void queryKaoSheng() {
        for(KaoSheng KaoSheng:KaoShengs){
            System.out.println("考试姓名："+KaoSheng.getName()+" 考生年龄："+KaoSheng.getAge()+" 考生学号："+KaoSheng.getid()+" 考生成绩："+KaoSheng.getresult());
        }

    }

    private static void addKaoSheng() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("添加考生信息");
        System.out.println("请输入考生姓名：");
        String name=input.next();
        System.out.println("请输入考生年龄：");
        int agea=input.nextInt();
        System.out.println("请输入考生学号：");
        String addid=input.next();
        System.out.println("请输入考生成绩：");
        int result=input.nextInt();

        KaoSheng KaoSheng2=new KaoSheng(name,agea,addid,result);
        boolean f=KaoShengs.add(KaoSheng2);
        System.out.println("添加考生："+f);
    }
    private static void addTiku1() throws IOException {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入题干：");
        String name=input.next();
        System.out.println("请输入A选项");
        String A=input.next();
        System.out.println("请输入B选项");
        String B=input.next();
        System.out.println("请输入C选项");
        String C=input.next();
        System.out.println("请输入D选项");
        String D=input.next();
        System.out.println("请输入正确答案选项");
        String answer=input.next();


        Timu timu3=new Timu(name,A,B,C,D,answer);
        boolean f=timus2.add(timu3);
        System.out.println("添加考生："+ true);
    }
    private static void addTiku() throws IOException {
        int x,y;


        for (Timu timu : timus1) {              //第一题
            System.out.println(timu.getName());
            System.out.println(timu.getA());
            System.out.println(timu.getB());
            System.out.println(timu.getC());
            System.out.println(timu.getD());
        }
        System.out.println("请输入答案：");
        Scanner input = new Scanner(System.in);


        char a = input.next().charAt(0);           //读取
        if (a == 'A'){
            System.out.println("答案正确!");
            x=10;
        }else{
            System.out.println("回答错误!");
            x=0;
        }


        for (Timu timu : timus2) {                //第二题
            System.out.println(timu.getName());
            System.out.println(timu.getA());
            System.out.println(timu.getB());
            System.out.println(timu.getC());
            System.out.println(timu.getD());
            System.out.println("请输入答案：");
            Scanner input2 = new Scanner(System.in);

            char b = input2.next().charAt(0);  //读取输入的字符
            if ( timu.getAnswer().equals(b)) {
                System.out.println("答案正确!");
            }else{
                System.out.println("回答错误!");
            }
        }

    };
}

