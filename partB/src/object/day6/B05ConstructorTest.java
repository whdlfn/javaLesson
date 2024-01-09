package object.day6;

import java.util.Arrays;

public class B05ConstructorTest {
    public static void main(String[] args) {
        
        MyClass4 my = new MyClass4();
        
        System.out.println("기본생성자 실행");
        System.out.println("\tfield2 : "+my.getField2());
        
        System.out.println("인자 1개 커스텀 생성자 실행");
        MyClass4 my1 = new MyClass4(999);
        System.out.println("\tmy1 : "+my1.getField2());
        
        MyClass4 my2 = new MyClass4("Hello");
        System.out.println("\tmy2 : "+ my2.getField1());
        
        System.out.println("인자 2개 커스텀 생성자 실행");
        MyClass4 my3 = new MyClass4("java",222);
        System.out.println("\tmy3 : "+ my3.getField1());
        System.out.println("\tmy3 : "+ my3.getField1());
        
        System.out.println("인자 3개 커스텀 생성자 실행");
        MyClass4 my4 = new MyClass4("good",234,new double[3]);
        System.out.println("\tmy4 : "+ my4.getField1());
        System.out.println("\tmy4 : "+ my4.getField2());
        System.out.println("\tmy4 : "+ my4.getField3()); 
        System.out.println("\tmy4 : "+ Arrays.toString(my.getField3())); 
        

        // 기본생성자와 setter가 업슨 myClass객체 만들기
        MyClass5 my5 = new MyClass5("ddff", 44, new double[3]);
        // MyClass5 my6 = new MyClass5(); //오류 기본 생성자가 없는 클래스
        System.out.println("MyClass5 객체 확인");
        System.out.println("\tmy5 : "+ my5.getField1());
        System.out.println("\tmy5 : "+ my5.getField2());
        System.out.println("\tmy5 : "+ my5.getField3()); 

        MyClass3 test = new MyClass3();
        test.setField1("안녕");
        test.setField2(999);
        test.setField3(new double[] {12.3,24.2});
        // 기본생성잔ㄴ set 메소드로 직접 값을 초기화하는 것이 조금 불편함
        //          -> 초기화를 위해서는 커스텀 생성자가 좋다
        // **결론 MyClass3과 같이 생성자 메소드가 직접 정의된 것이 없으면 기본 생성자만 쓸 수 있다
        //                                  ㄴ 기본생성자가 숨어있는 것
        // MyClass5와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면 기본생성자는 생략하고 사용 못함
        //          사용하고 싶으면 직접 정의해야 한다 -> // public MyClass5() {}


        // 기본생성자 쓸거면 MyClass3
        // 커스텀 생성자 쓸거면 MyClass5

        

    }
}
