package com.fastcampus.ch3.diCopy1;

import java.io.FileReader;
import java.util.Properties;

/**
 * packageName :  com.fastcampus.ch3.diCopy1
 * fileName : Main1
 * author :  82108
 * date : 2023-03-12
 * description :
 */
class Car {}
class SportsCar extends Car {}
class Truck extends Car {}
class Engine {}

public class Main1 {
    public static void main(String[] args) throws Exception{
//        Car car = getCar();
        Car car = (Car) getObject("car");
        Engine engine = (Engine) getObject("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

    static Car getCar() throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));

        return (Car) clazz.newInstance();
    }

    static Object getObject(String key) throws Exception {
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty(key));

        return clazz.newInstance();
    }

}
