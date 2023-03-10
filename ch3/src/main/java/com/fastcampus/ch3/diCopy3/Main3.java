package com.fastcampus.ch3.diCopy3;

import com.google.common.reflect.ClassPath;
import org.springframework.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * packageName :  com.fastcampus.ch3.diCopy1
 * fileName : Main1
 * author :  82108
 * date : 2023-03-12
 * description :
 */
@Component
class Car {}
@Component
class SportsCar extends Car {}
@Component
class Truck extends Car {}
@Component
class Engine {}

class AppContext {
    Map map; // 객체 저장소

    AppContext() {

        try {

            map = new HashMap();
            doComponentScan();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void doComponentScan() {
        // 패키지 내의 클래스 목록을 가져옴
        // 반복문으로 클래스를 하나씩 읽어와서 @Component가 붙어있는지 확인
        // @Component가 붙어있으면 객체를 생성해서 map에 저장

        try {
            ClassLoader classLoader = AppContext.class.getClassLoader();
            ClassPath classPath = ClassPath.from(classLoader);

            Set<ClassPath.ClassInfo> set = classPath.getTopLevelClasses("com.fastcampus.ch3.diCopy3");

            for (ClassPath.ClassInfo classInfo : set) {
                Class clazz = classInfo.load();
                Component component = (Component) clazz.getAnnotation(Component.class);
                if (component != null) {
                    String id = StringUtils.uncapitalize(classInfo.getSimpleName());
                    map.put(id, clazz.newInstance());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    Object getBean(String key) { // byName
        return map.get(key);
    }

    Object getBean(Class clazz) { // byType
        for (Object obj : map.values()) {
            if (clazz.isInstance(obj)) {
                return obj;
            }
        }
        return null;
    }
}

public class Main3 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext();
//        Car car = (Car) ac.getBean("car");
        Car car = (Car) ac.getBean(Car.class);
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }

}
