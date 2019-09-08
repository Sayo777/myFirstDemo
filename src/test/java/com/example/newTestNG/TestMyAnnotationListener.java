package com.example.newTestNG;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.example.newTestNG.MyAnnotationListener.class)
public class TestMyAnnotationListener {
    @MyAnnotation(id = 1,name="Sayo")
    @Test
    public void testtest(){
        System.out.println("这是我的test");
    }
}
