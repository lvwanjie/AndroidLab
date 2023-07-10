package com.lvwanjie.myapplication.javaTest.wb;

public class Timu {
    private String name;
    private String A;
    private String B;
    private String C;
    private String D;
    private String answer;


    public Timu() {
    }

    public Timu(String name, String a, String b, String c, String d, String answer) {
        this.name = name;
        A = a;
        B = b;
        C = c;
        D = d;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
