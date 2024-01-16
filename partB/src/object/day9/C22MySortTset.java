package object.day9;

import java.util.Arrays;

// 순차정렬 알고리즘 구현
public class C22MySortTset {
    public static void main(String[] args) {
        int[] numbers = { 67, 34, 65, 89, 54 };

        System.out.println("오름차순 정렬");
        System.out.println("정렬 초기 numbers : " + Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) { //오름차순이 아닐 경우 
                    int temp;  //하나만 옮길거니까 배열 아니여도 됨
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
                
                System.out.println(
                    String.format("중간 상태 : i =%d, j=%d 배열 : %s", i,j,Arrays.toString(numbers))
                    );
                }
            }
            System.out.println("정렬 후 numbers : " + Arrays.toString(numbers));
            
        System.out.println("\n정렬 초기 numbers : " + Arrays.toString(numbers));
        System.out.println("내림차순 정렬");
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) { //오름차순이 아닐 경우 
                    int temp;  //하나만 옮길거니까 배열 아니여도 됨
                    temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }

                System.out.println(
                    String.format("중간 상태 : i =%d, j=%d 배열 : %s", i,j,Arrays.toString(numbers))
                );
            }
        }



        System.out.println("정렬 후 numbers : " + Arrays.toString(numbers));
    }
}
