                                                                                                                                                                                                                                                                                    package object.day7;

import java.util.Scanner;

/*
 * 자바 클래스의 생성자로 매소드 오버로딩 알아보기
 *      String 클래스
 */
public class B07ConstructorExam {
    public static void main(String[] args) {
        //문자열 리터럴을 message변수로 참조
        String message = "hello";           
        String temp = "hello";
        //문자열 객체 생성하기
        // 1) 메소드 오버로딩 : 메소드 이름이 같고 리턴타입과 인자의 개수 형식이 다른 정의
        String str1 = new String();     //생성자 인자가 없음
        String str2 = new String("hello");      //생성자 인작 문자열 리터럴
        String str3 = new String(new char[] {'h','e','l','l','o'});     //셍성자 인자가 문자 배열

        //new연산으로 생선된 객체
        System.out.println(str1);       //길이가 0인 문자열
        System.out.println(str2);       //hello
        System.out.println(str3);       //hello
        
        //2) 문자열 리터럴 특징 : 문자열 내용이 같으면 또 메모리에 새로 저장하지 않음
                // messgae가 참조하는 "hello" 가 동일한 리터럴을 temp가 참조할 대
                //hello를 또 저장해서 temp 참조하는 것이 아니라 이미 저장되어 있는 hello를 참조
 
        System.out.println(message==temp);      //참조값 비교문 trun  //메세지와 temp는 기억장소가 동일하다 
        System.out.println(message==str2);      //falseㅡ - 단 new연산으로 만든것은 언제나 메모리를 새로 할당받음

        //문자열 내용을 비교하는 것 
        System.out.println(message.equals(temp));       //trun
        System.out.println(message.equals(str2));       //trun

        //다른 클래스 생성자
        Scanner sc = new Scanner(System.in);        //INpit클래스로 만들어진 객체 system.in 생성자 인자로 하여 객체를 생성
                        //키보드 입력을 원초적인 벙식으로 처리하기 때문에 키보드 입력값을 다양하게 처리할 수 있는 Scanner
        
        int num = sc.nextInt();  //입력값 정수로 변환
        double pi =sc.nextDouble();
        String name = sc.nextLine();


        temp = sc.nextLine();
        num = Integer.parseInt(temp);       //문자열을 int로 변환해줌
        
        
        temp = sc.nextLine();
        pi = Double.parseDouble(temp);       //문자열을 int로 변환해줌
        temp = sc.nextLine();

        name = sc.nextLine();       //문자열을 int로 변환해줌
    }
}
