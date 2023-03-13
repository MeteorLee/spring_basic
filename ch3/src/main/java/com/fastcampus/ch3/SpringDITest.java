/*
package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

*/
/**
 * packageName :  com.fastcampus.ch3
 * fileName : SpringDITest
 * author :  82108
 * date : 2023-03-13
 * description :
 *//*


//@Component("engine")
class Engine{}
@Component class SuperEngine extends Engine{}
@Component class TurboEngine extends Engine{}


@Component
class Door {
}

@Component
class Car {
    @Value("red")
    String color;
    @Value("100")
    int oil;
//    @Autowired // byType
//    @Qualifier("superEngine")
    @Resource(name = "superEngine") // byName
    Engine engine;
    @Autowired
    Door[] doors;

    public Car() {
    }

    public Car(String color, int oil, Engine engine, Door[] doors) {
        this.color = color;
        this.oil = oil;
        this.engine = engine;
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }
}

public class SpringDITest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");

        Car car = (Car) ac.getBean("car");
////        Car car2 = ac.getBean(Car.class);
//
//        Engine engine = (Engine) ac.getBean("superEngine"); // byName
////        Engine engine = (Engine) ac.getBean(Engine.class); // byType - 같은 타입이 많아서 에러
//        Door door = (Door) ac.getBean("door");

//        car.setColor("red");
//        car.setOil(100);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{(Door) ac.getBean("door"), (Door) ac.getBean("door")});


        System.out.println("car = " + car);

    }
}
*/
