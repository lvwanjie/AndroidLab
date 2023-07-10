package com.lvwanjie.myapplication.javaTest.wb;

public class KaoSheng {
    private String name;
    private int age;
    private String id;
    private int result;


    public KaoSheng() {
    }

    public KaoSheng(String name, int age, String id , int result,String question) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.result =  result;

    }

    public KaoSheng(String name, int agea, String addid, int result) {
        this.name=name;
        this.age=agea;
        this.id=addid;
        this.result=result;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }


    public double getresult() {
        return result;
    }

    public void setresult(int result) {
        this.result = result;
    }



    @Override
    public String toString() {
        return "KaoSheng{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id='" + id + '\'' +
                ", result=" + result +
                '}';
    }
}