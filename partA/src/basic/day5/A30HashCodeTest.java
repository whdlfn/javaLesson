package basic.day5;

public class A30HashCodeTest {
    public static void main(String[] args) {
        int[] iArray = new int[10];
        String message = "Hello world";

        // hashcode 는 참조값(식별값)을 만들기 위해 해시함수로 생성된 결과
        System.out.println(iArray); // 배열의 식별값을 보여줌 (16진수)
        System.out.println("초기 hashcode값 " + iArray.hashCode()); // 해쉬코드 값을 가져옴 (10진수)
        System.out.println(Integer.toHexString((iArray.hashCode()))); // 10진수를 16진수로 변환

        iArray[3] = 99;
        System.out.println("배열 요소값을 변경한 후 hashcode : " + iArray.hashCode());
        System.out.println("결론 배열값이 변경되어도 메모리의 위치는 동일");

        System.out.println("\n String 변수 message의 해시코드 값 : " + message.hashCode());
        message = message + "good";
        System.out.println("message를 변경한 후 해시코드 값 : " + message.hashCode());
        System.out.println("결론 : 문자열 Stringd은 내용이이 변경되면 메모리의 위치가 바뀜");
    }
}

/*
 * 객체란 여러 종류의 데이터가 모여 있는 데이터 덩어리 (기본형은 데이터 저장의 최소단위)ㄴ
 * 객체는 참조형 변수를 사용. (변수가 주소를 저장한다.)
 * 객체를 메모리에 저장함 -> 초기에 저장한 데이터를 바꿀 수 있다(배열) -> 가변객체
 *                      -> 초기에 저장한 데이터를 바꿀 수 없다(String) ->불변객체
 */
