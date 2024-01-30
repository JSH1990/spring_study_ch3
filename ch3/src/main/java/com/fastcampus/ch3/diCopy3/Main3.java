package com.fastcampus.ch3.diCopy2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


class AppContext{
    Map map; //객체저장소

    AppContext() throws Exception {
        map = new HashMap();
        doComponentScan();
        }

    private void doComponentScan(){

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
