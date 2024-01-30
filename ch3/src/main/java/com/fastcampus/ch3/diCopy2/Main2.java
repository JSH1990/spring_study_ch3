package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.util.Map;
import java.util.Properties;


class Car{}
class SportsCar extends Car{}
class Truck extends Car{}
class Engine{}
class door extends Engine{}

class AppContext{
    Map map; //객체저장소

    AppContext(){
        map = new hashmap();
        map.put("car", new SportsCar());
        map.put("engine", new Engine());
    }

    Object getBean(String key) {
        return map.get(key);
    }
}
public class Main2 {

    /*static Object getObject(String key) throws Exception{
        //config.txt를 읽어서 Properties에 저장
        Properties p = new Properties(); //config.txt 파일불러오기위해 p객체생성
        p.load(new FileReader("config.txt"));

        //클래스 객체(설계도)를 얻어서
        Class clazz = Class.forName(p.getProperty(key)); //getObject(객체의 키)를 가지고 clazz 객체생성
        return clazz.newInstance();//객체를 생성해서 반환
    }*/

    static Object getBean(String key) throws Exception{
        //config.txt를 읽어서 Properties에 저장
        Properties p = new Properties(); //config.txt 파일불러오기위해 p객체생성
        p.load(new FileReader("config.txt"));

        //클래스 객체(설계도)를 얻어서
        Class clazz = Class.forName(p.getProperty(key)); //getObject(객체의 키)를 가지고 clazz 객체생성
        return clazz.newInstance();//객체를 생성해서 반환
    }

    //    public static void main(String[] args) throws Exception {
//        Car car = (Car) getObject("car"); //car 객체 만듦.
//        Engine engine = (Engine) getObject("engine");
//        System.out.println("car = " + car);
//        System.out.println("engine = " + engine);

//    }
    public static void main(String[] args) throws Exception {
        Car car = (Car) getBean("car"); //car 객체 만듦.
        Engine engine = (Engine) getBean("engine");
        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }


    static Car getCar() throws Exception{
        Properties p = new Properties();
        p.load(new FileReader("config.txt"));

        Class clazz = Class.forName(p.getProperty("car"));
        return (Car)clazz.newInstance();
    }
}
