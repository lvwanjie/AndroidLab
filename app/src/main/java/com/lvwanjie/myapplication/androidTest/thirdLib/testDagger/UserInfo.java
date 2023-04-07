package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserInfo {

    private String userName;
    private String age;
    private int id;

    @Inject
    public UserInfo(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
