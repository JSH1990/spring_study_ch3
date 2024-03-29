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
        Properties p = new Properties(); //(String, String)
        p.load(new FileReader("config.txt"));

        map = new HashMap(p); //객체들을 담을 map을 생성(String, Object)

        //반복문으로 클래스 이름을 얻어서 객체를 얻어 객체를 생성해서 다시 map에 저장
        for (Object key : map.keySet()){ //for문을 통해 파일의 키들을 이용해 객체생성후 저장소에 보관
            Class clazz = Class.forName((String)map.get(key));
            map.put(key, clazz.newInstance()); //클래스 이름 가져와서 map에 저장
        }
    }

    Object getBean(String key) {
        return map.get(key);
    } //key에 해당되는 객체를 가져온다.
}
public class Main2 {
    public static void main(String[] args) throws Exception {
        AppContext ac = new AppContext(); //객체저장소 ac생성
        Car car = (Car) ac.getBean("car"); //ac.getBean(키는 car) 호출해 저장소에 보관, getBean은 객체를 가져온다.
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }
/*
@component class car{}
패키지 내에 @Component붙은 클래서 찾아서 객체생성해서 map에 저장
config.txt보다 편하다.
 */


}
