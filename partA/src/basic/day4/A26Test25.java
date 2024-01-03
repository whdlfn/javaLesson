package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    public static void main(String[] args) {

        // A25클래스에서 만든 메소드를 사용할 수 있다 
        int result = A25MySampleMethod.sumToN(10,13);
        System.out.println(result);

        // 메소드가 private로 정의되면 사용할 수 없음

        // 자바 또는 다른 프로그램언어로 코딩할 때
        // 1. 자바에서 제공하는 클래스, 메소드 잘 활용하기
        // 2. 필요에 따라 개발자가 직접 잘 만들어 쓰기

        Scanner sc = new Scanner(System.in);
        System.err.println("시작값 >>");
        int start = sc.nextInt();
        System.out.println("마지막값 >>");
        int end = sc.nextInt();

        System.out.println(start +"~"+end+"까지의 곱하기 결과 : "+A25MySampleMethod.multiplyMToN(start, end));

    }
}
