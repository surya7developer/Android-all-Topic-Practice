package com.example.lib.abstraction;

public class AbstractMain {
    public static void main(String[] args) {
        Car car = new Car();
        Scooter scooter = new Scooter();

        car.start();
        scooter.start();
    }
}


abstract class Vehicle {

    String aaa;

    abstract void start();
}

class Car extends Vehicle {

    @Override
    void start() {
        System.out.println("This is Car start");
    }
}

class Scooter extends Vehicle {

    @Override
    void start() {
        System.out.println("This is Scooter start");
    }
}