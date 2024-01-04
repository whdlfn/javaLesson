package object.day5;

import java.util.Arrays;

public class B01MyClassMain {
    public static void main(String[] args) {
        // 정의된 클래스 MyClass1으로 객체를 만듭니다 - new연산 사용

        MyClass1 my1 = new MyClass1();
        // 객체란 데이터 덩어리다 new연산으로 Myclass1객체를 저장할 메모리 확보
        // MyClass1(); -> 생성자 메소드. 무조건 클래스 이름과 같다
        // 메모리에 저장공간을 확보하면서 동시에 실행

        System.out.println(my1.field1); // String
        System.out.println(my1.field2); // int
        System.out.println(my1.field3); // double 배열

        my1.field1 = "hi 모모";
        my1.field2 = 999;
        my1.field3 = new double[4];

        System.out.println();
        System.out.println(my1.field1); // String
        System.out.println(my1.field2); // int
        System.out.println(my1.field3); // double 배열
        System.out.println("배열의 요소 크기 : " + my1.field3.length);
        System.out.println("배열의 요소 값 : " + Arrays.toString(my1.field3));

        // new로 만든 객체 -> 가변객체

        MyClass2 my3 = new MyClass2();
    }
}
