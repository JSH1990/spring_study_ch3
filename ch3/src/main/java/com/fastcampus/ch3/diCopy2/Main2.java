package com.fastcampus.ch3.diCopy2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


class Car{}
class SportsCar extends Car{}
class Truck extends Car{}
class Engine{}
class door extends Engine{}

class AppContext{
    Map map; //객체저장소

    AppContext() throws Exception { //객체저장소 클래스
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        map = new HashMap(p); //객체들을 담을 map을 생성

        for (Object key : map.keySet()){ //for문을 통해 파일의 키들을 이용해 객체생성후 저장소에 보관
            Class clazz = Class.forName((String)map.get(key));
            map.put(key, clazz.newInstance());
        }
    }

    Object getBean(String key) {
        return map.get(key);
    }
}
public class Main2 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext(); //객체저장소 ac생성
        Car car = (Car) ac.getBean("car"); //ac.getBean(키는 car) 호출해 저장소에 보관
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }



}
