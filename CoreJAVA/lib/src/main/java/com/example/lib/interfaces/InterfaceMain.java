package com.example.lib.interfaces;

public class InterfaceMain {
    public static void main(String[] args) {

        TestClass testClass = new TestClass();
        testClass.method3();
        testClass.method4();

        // Another example of same mehod of two interface
        // One one = new One();
        // one.display();
    }
}

class One implements InterOne , InterTwo {

    @Override
    public void display() {
        System.out.println("display()");
    }
}

interface InterOne {
    void display();
}

interface InterTwo {
    void display();
}


// Here we are achieved multiple inheritance concept in java using interfaces
class TestClass implements TextInterface,SecondInterface {

    @Override
    public void method4() {
        System.out.println("Method4()");
    }

    @Override
    public void method3() {
        TextInterface.super.method3();
    }

    @Override
    public void display() {
        System.out.println("display from second interface");
    }
}

interface TextInterface {

    int age = 10;
    String name = "Interface";

    private void method1() {
        System.out.println("Method1()");
        method2();
    }

    static void method2() {
        System.out.println("Method2()");
    }

    default void method3() {
        method1();
        System.out.println("Method3()");
    }

    void method4();
}

interface SecondInterface {

    void display();
    void method4();
}
