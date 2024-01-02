package basic.day3;

public class A15MinValue {
    
    public static void main(String[] args) {
        int n1 = 20, n2 = 14, n3 =50;
        int min;

        // 1. 조건식이 참/거짓 각각 실행 명령어가 다름
        if (n1<n2) {
            min = n1;
        } else{
            min = n2;
        }
        // 2. 조건식이 참일 대만 실행한다
        if (min>n3) {
            min = n3;
        }
        System.out.println(min);

        System.out.println("삼항 연산자로 구현");
        n1 = 27; n2 = 9; n3 = 54;
        min =0 ;
        min = (n1<n2 ? n1 : n2);
        min = (min > n3 ? n3 : min);
        System.out.println(min);
    }
}
