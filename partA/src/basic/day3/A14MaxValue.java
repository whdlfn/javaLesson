package basic.day3;

public class A14MaxValue {
    public static void main(String[] args) {
        
        int n1 = 20, n2 = 14, n3 =50;
        int max;

        // 1. 조건식이 참/거짓 각각 실행 명령어가 다름
        if (n1>n2) {
            max = n1;
        } else{
            max = n2;
        }
        // 2. 조건식이 참일 대만 실행한다
        if (max<n3) {
            max = n3;
        }
        System.out.println(max);

        System.out.println("삼항 연산자로 구현");
        n1 = 27; n2 = 9; n3 = 54;
        max =0 ;
        max = (n1>n2 ? n1 : n2);
        max = (max < n3 ? n3 : max);
        System.out.println(max);
    }
}
