package object.day8;

import object.day7.Diamond;
import object.day7.Shape;
import object.day7.Triangle;
import object.test.Square;

//모든 자바 클래스의 부모는 Object타입 

public class B14ObjectTest {
    public static void main(String[] args) {

        //object타입으로 업캐스팅
        Object ob1 = new String("Hello java");
        Object ob2 = new Diamond();
        Object ob3 = 3;   //3은 int정수 - Integer 객체로 변경 -> Object로 참조
        // 기본형 타입 Wrapper 클래스로 객체로 변경 돼서 Object로 업캐스팅
                    // Byte, Cgaracter, shsort, Integer, Long, Float, DOuble
                    //다른 자료구조 List, Mao, Set 등은 객체(클래스) 타입만 다룸

        //Object 클래스의 메소드 - 모든 자바클래스가 상속받고 있다
                    //getClass,toString, hashcodem equals 그 외는 스레드 관련 메소드
                    //String 클래스 wquals는 object메소드 재정의(오버라이드)
        System.out.println("getClass는 클래스의 타입 정보를 리턴");
        System.out.println("\t ob1.getClass : "+ob1.getClass().getName());  //getName는 클래스 타입정보 중 클래스이름 리턴
        System.out.println("\t ob2.getClass : "+ob2.getClass().getName());
        System.out.println("\t ob3.getClass :"+ob3.getClass().getName());

        System.out.println("hashcode는 객체의 참조값(식별값)을 리턴");
        System.out.println("\t ob1 hashcode : "+ob1.hashCode() + ","+ Integer.toHexString(ob1.hashCode()));
        System.out.println("\t ob2 hashcode : "+ob2.hashCode() + ","+ Integer.toHexString(ob2.hashCode()));
        System.out.println("\t ob3 hashcode : "+ob3.hashCode() + ","+ Integer.toHexString(ob3.hashCode()));

        System.out.println("toString 확인 - 참조변수를 출력할 때 문자열 표현값 리턴");
        System.out.println("\t ob1.toString :" + ob1.toString());  //String 은 toString재정의
        System.out.println("\t ob2.toString :" +ob2.toString());  //Object는 toString의 기본값 출력
        System.out.println("\t ob3.toString :" +ob3.toString());  //Integer는 toString 재정의
         System.out.println("\t ob1.toString :" + ob1);  //toString 메소드는 생력하고 쓸 수 있다
         System.out.println("\t ob1.toString :" + ob2);
         System.out.println("\t ob1.toString :" + ob3);




         System.out.println("우리가 만든 클래스의 toString재정의 확인");
         Shape sh2 = new Shape("아직모름,",25,30);
         Shape diamode = new Diamond();
         Shape square = new Square();
         Triangle triangle = new Triangle("삼각형", 44, 23, 43);

         System.out.println("\t sh2 = " + sh2);
         System.out.println("\t diamode = " + diamode);   //자식 클래스 Diamond이 정의한 toString
         System.out.println("\t square = " + square);   //부모 Shape이 정의한 toString
         System.out.println("\t triangle = " + triangle);   ////부모 Shape이 정의한 toString


    }
}
