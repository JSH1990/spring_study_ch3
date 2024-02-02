//package com.fastcampus.ch3;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.GenericGroovyApplicationContext;
//import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Arrays;
//
////@Component("engine")
//class Engine{} //<bean id="engine" class="com.fastcampus.ch3.Engine/>
//@Component class SuperEngine extends Engine{}
//@Component class TurboEngine extends Engine{}
//@Component class Door{}
//@Component
//class Car{
//    @Value("red") String color;
//    @Value("100") int oil;
//    //@Autowired //byType
////  @Qualifier("superEngine")
//    @Resource(name = "superEngine") //byName
//    Engine engine;  //byType - 타입으로 먼저검색, 여러개면 이름으로 검색 - superEngine, turboEngine
//    @Autowired Door[] doors;
//
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    public void setOil(int oil) {
//        this.oil = oil;
//    }
//
//    public void setEngine(Engine engine) {
//        this.engine = engine;
//    }
//
//    public void setDoors(Door[] doors) {
//        this.doors = doors;
//    }
//    @Override
//    public String toString() {
//        return "Car{" +
//                "color='" + color + '\'' +
//                ", oil=" + oil +
//                ", engine=" + engine +
//                ", doors=" + Arrays.toString(doors) +
//                '}';
//    }
//
//}
//
//
//public class SpringDiTest {
//    public static void main(String[] args) {
//
//        ApplicationContext ac = new GenericXmlApplicationContext("config1.xml");
////   Car car = (Car)ac.getBean("car"); //byName. 아래와 같은 문장
//        Car car = (Car)ac.getBean("car", Car.class);//byName
//        Car car2 = (Car)ac.getBean(Car.class);//byType
//
////     Engine engine = (Engine)ac.getBean("engine");  //byName
////     Engine engine = (Engine)ac.getBean(Engine.class);  //byType - 같은타입이 3개라서 에러
//        Engine engine = (Engine)ac.getBean("superEngine"); //byType
//        Door door = (Door)ac.getBean("door");
//
////     car.setColor("red");
////     car.setOil(100);
////     car.setEngine(engine);
////     car.setDoors(new Door[]{ac.getBean("door", Door.class), (Door)ac.getBean("door")});
//        System.out.println("car = " + car);
////     System.out.println("car2 = " + car2);//car, car2 객체 주소값이 같다. = 싱글톤이기때문 (서블렛처럼 하나만들어서 계속 여러가지일을 함)
//        System.out.println("engine = " + engine);
////     System.out.println("door = " + door);
//
//    }
//}
