package com.example.newTestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG {
    @BeforeMethod
    public void beforemethod() {
        System.out.println("this is beforemethod");
    }

    @DataProvider
    public Object[][] logindata() {
        return new Object[][]{{"a"}, {"b"}};
    }

    @Test(dataProvider = "logindata")
    public void test1(String info) {
        System.out.println(info);
    }

    @DataProvider(name = "logoutdata")
    public Object[][] logoutinfo() {
        return new Object[][]{{"1"}, {"2"}, {"3"}};
    }

    @Test(dataProvider = "logoutdata")
    public void test2(String info) {
        System.out.println(info);
    }

    @AfterMethod
    public void aftermethod() {
        System.out.println("this is aftermethod\n");
    }
}
