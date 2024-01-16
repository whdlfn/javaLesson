package object.day9;

import java.util.Arrays;
import java.util.Comparator;

public class C21AttaySortTest {
    public static void main(String[] args) {

        int[] numbers = { 56, 24, 46, 87, 96 };
        System.out.println("초기 numbers =" + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("정렬 후 numbers =" + Arrays.toString(numbers));
        System.out.println("정렬 후 numbers =" + Arrays.toString(numbers));

        String[] names = { "momo", "nayeon", "dsahyeon", "Zewi", "Beo" };
        System.out.println("초기 numbers =" + Arrays.toString(names));
        Arrays.sort(names);
        System.out.println("정렬 후 numbers =" + Arrays.toString(names));
        
        // Arrays.sort(배열변수) : 기본현 배열, String배열의 오름파순 정렬 가능
        // 내림차순 정렬, 다른 참조타입에 대한 정렬은 메소드 두번째 인자로 기준 공식을 줘야함 -> 인터페이스로 전달

        // 순차정렬 알고리즘 : 가장 단순한 알고리즘
        // 비교(누가 더 작니)와 교환
        
        // 내림차순 정렬 - Comparator <> 제너릭타입에 기본형을 사용 못 함
        // 기본형은 Wrapper클래스 사용
        Integer[] numbers2 = { 56, 24, 46, 87, 96 };
        Arrays.sort(numbers2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // 내림차순을 위한 식
                return o2 - o1;
                // 대입문 도는 수식에서 Integer 타입과 int 타입 사이의 캐스팅은 자동
            }
        });
        
        Arrays.sort(numbers2,(o1,o2)->{return o2-o1;});  //람다식으로 작성

        System.out.println("number2 내림차순 정렬 후 : " + Arrays.toString(numbers2));

    }
}
