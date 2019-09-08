package com.example.newTestNG;


import org.testng.*;

public class MyAnnotationListener implements IInvokedMethodListener, ITestListener {
    private int id;
    private String name;
    private boolean testSuccess = true;

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart " + result);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess " + result);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestResult " + result);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped " + result);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage" + result);


    }

    public void onStart(ITestContext context) {
        System.out.println("onStart");
        for (ITestNGMethod m1 : context.getAllTestMethods()) {
            if (m1.getConstructorOrMethod().getMethod().isAnnotationPresent(MyAnnotation.class)) {
                name = m1.getConstructorOrMethod().getMethod().getAnnotation(MyAnnotation.class).name();
                id = m1.getConstructorOrMethod().getMethod().getAnnotation(MyAnnotation.class).id();

            }
        }

    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish");


    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("beforeInvocation");
        if (method.isTestMethod() && annotationPresent(method, MyAnnotation.class)) {
            System.out.println("beforeAnnotation...");
            System.out.println("Name: " + name + " Id: " + id);
            System.out.println(testResult.toString());
        }

    }

    private boolean annotationPresent(IInvokedMethod method, Class<MyAnnotation> clazz) {

        return method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz) ? true : false;
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        System.out.println("afterInvocation");
        if (method.isTestMethod()) {
            if (method.getClass().isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("invoked afterAnnotation");
            }
            if (!testSuccess) {
                testResult.setStatus(ITestResult.FAILURE);
            }
        }
    }
}
