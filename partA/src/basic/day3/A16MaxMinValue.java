package basic.day3;

public class A16MaxMinValue {
    
    public static void main(String[] args) {
        int n1 = 23, n2 = 77, n3 =88;
        int min;
        int max;

        // 1. 조건식이 참/거짓 각각 실행 명령어가 다름
        if (n1<n2) {
            min = n1;
            max = n2;
        } else{
            min = n2;
            max = n1;
        }
        // 2. 조건식이 참일 대만 실행한다
        // 참 또는 거짓일 때 실행하는 명령문이 1개면 {} 생략가능 
        if (min>n3) {
            min = n3;
        }

        if (max<n3) {
            max = n3;
        }

        System.out.println(min);
        System.out.println(max);
        
    }
}
