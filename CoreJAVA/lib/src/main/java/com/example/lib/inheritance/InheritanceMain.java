package com.example.lib.inheritance;

public class InheritanceMain {

    public static int age = 30;

    public static void main(String[] args) {

        Two two = new Two();
        two.display();
        two.getName();
        System.out.println("age = " + age);
    }
}


class ABC {

    static void method2(){
        System.out.println("ABC method2");
    }
}

class XYZ extends ABC {

    static void method2(){
        System.out.println("XYZ method2");
    }

}

class One {

    public static int age = 10;
    String name = "One";
    public String getName() {
        System.out.println("getName One");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void display(){
        System.out.println("Display one");
    }
}

class Two extends One {

    public static int age = 20;
    String name = "Two";
    public String getName() {
        System.out.println("getName Two");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    void display(){
        super.display();
        System.out.println("Display Two");

    }
}