package basic.day4;

public class A25MySampleMethod {
    // 구굴드라이브
    public static void main(String[] args) {

        // A22 1~5을 각각 메소드로 정의
        // 1. sumToN 2. multiplyToN 3.sumToN 4. multiplyMToN 5.multiplyNof
        // ~~출력하는 메소드, 리턴은 void

        // 1. 1부터 정수 n까지 더하기
        int a = sumToN(4);
        System.out.println("문제 1번 : " + a);

        // 2. 1부터 정수 n까지 곱하기
        long lo = multiplyToN(3);
        System.out.println("문제 2번 : " + lo);

        // 3. 시작값 정수 m부터 마지막값 n까지 더하기
        a = sumToN(5, 8);
        System.out.println("문제 3번 : " + a);

        // 4. 시작값 정수 m부터 마지막값 n까지 곱하기
        lo = multiplyMToN(1, 3);
        System.out.println("문제 4번 : " + lo);

        // 5. 2의n승 구하기
        lo = multiplyNof(10);
        System.out.println("문제 5번 : " + lo);

        // 6. 구구단 '출력'하는 메소드 리턴은 void printGuGudan
        printGuGudan();

        int result = addMtoN(2,5);
    }

    private static int addMtoN(int i, int j) {
        int sum =0;
        for(int k =i; k<=j; j++){
            sum +=k;
        }
        return 0;
    }

    // 1. 1부터 정수 n까지 더하기
    public static int sumToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // 2. 1부터 정수 n까지 곱하기
    public static long multiplyToN(int n) {
        long longResult = 1;
        for (int i = 1; i <= n; i++) {
            longResult *= i;
        }
        return longResult;
    }

    // 3. 시작값 정수 m부터 마지막값 n까지 더하기
    public static int sumToN(int m, int n) {
        int sum = 0;
        for (int i = m; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    // 4. 시작값 정수 m부터 마지막값 n까지 곱하기
    public static long multiplyMToN(int m, int n) {
        long longResult = 1;
        for (int i = m; i <= n; i++) {
            longResult *= i;
        }
        return longResult;
    }

    // 5. 2의n승 구하기
    public static long multiplyNof(int n) {
        long longResult = 1;
        for (int i = 1; i <= n; i++) {
            longResult *= 2;
        }
        return longResult;
    }

    public static void printGuGudan() {
        for(int i =2; i<10; i++){
            System.out.println(i+"단");
            for(int j =1; j<10; j++){
                System.out.println(String.format("%3d +%3d =%3d", i,j,(i*j)));
            }
        }
    }
}
