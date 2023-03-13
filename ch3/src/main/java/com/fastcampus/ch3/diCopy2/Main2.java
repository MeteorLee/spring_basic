package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * packageName :  com.fastcampus.ch3.diCopy1
 * fileName : Main1
 * author :  82108
 * date : 2023-03-12
 * description :
 */
class Car {
}

class SportsCar extends Car {
}

class Truck extends Car {
}

class Engine {
}

class AppContext {
    Map map; // 객체 저장소

    AppContext() {

        try {
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));

            // properties에 저장된 내용을 map에 저장
            map = new HashMap(p);

            for (Object key : p.keySet()) {

                Class clazz = Class.forName((String) map.get(key));
                map.put(key, clazz.newInstance());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    Object getBean(String key) {
        return map.get(key);
    }
}

public class Main2 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
        Car car = (Car) ac.getBean("car");
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

}
