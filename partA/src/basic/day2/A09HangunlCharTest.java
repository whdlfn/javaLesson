package basic.day2;

public class A09HangunlCharTest {
    public static void main(String[] args) {

        // 문자 '나' 부터 '냇' 까지 while문으로 출력
        // 모두 몇개의 문자가 있는지 개수 구하기 int codeNa, codeNet

        char start = '나';
        char end = '낟';
        int codeNa = start; // 나의 코드값
        int codeNet = end; // 낟의 코드값

        System.out.println(codeNa);

        while (start <= end) {
            System.out.print(start++);
        }

        System.out.println("\nstart =????" + start); // 냿의 문자 다음 값
        System.out.println("\n '나 ~ '낟' 까지 문자의 개수 = " + (codeNet - codeNa + 1));

    }
}
