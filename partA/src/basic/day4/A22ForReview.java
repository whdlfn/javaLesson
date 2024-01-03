package basic.day4;

//근데 이제 for문을 곁들인
public class A22ForReview {

    public static void main(String[] args) {
        

        // 1부터 정수 n까지 더하기
        // 곱하기
        // 시작값 정수 m부터 마지막값 n까지 더하기
        // 시작값 정수 m부터 마지막값 n까지 곱하기

        // 2의n승 구하기 (2진수에서는 많이 사용됨)
       
        int n;
        int m;
        int sum =0;
        int result =1 ;     //곱셈 결과 저장 변수

        
        n=5;
        for(int i = 1; i<=n; i++){
            sum += i;
        }
        System.out.println(String.format("문제 1) 1부터 %d까지의 합계 : %d", n,sum));
        
        // 곱하기       int 타입은 정수 -2147482648 ~ 2147482647
        n=5;
        long longResult =1;
        for(int i = 1; i<=n; i++){
            longResult *= i;
        }
        System.out.println(String.format("문제 2) 1부터 %d까지의 곱 : %d", n,result));

        // 시작값 정수 m 부터 마지막값 n까지 더하기
        m=5; n=8;
        sum =0;
        for(int i = m; i<=n; i++){
            
        }
        // 시작갑 정수 m부터 마지막값 n까지 곱하기
        m=5; n=8;
        longResult =1;
        for(int i = m; i<=n; i++){
            
        }
// 2의 n승 구하기
        n=4;
        longResult =1;
        for(int i = 1; i<=n; i++){
            longResult*=2;
        }

    }
}
