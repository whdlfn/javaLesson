package basic.day2;

public class A10StringVariable {

    public static void main(String[] args) {
        // string 문자열 : 문자의 집합 ""
        String message = "Hello";
        System.out.println(message);
        System.out.println("메세지 '" + message + "'의 길이 : " + message.length());

        // String으로 선언된 변수는 객체이다. 그래서 여러가지 메소드를 갖고 필요한 기능들을 제공햊줌
        message = "아  4";
        System.out.println("메세지 '" + message + "'의 길이 : " + message.length());
        // char imo = '😊'; char은 2바이트 이모지는 4바이트 문자형으로 저장 안됨
        String imo = "💝"; // 이모지는 문자열로 저장
        System.out.println(imo);

        // 자바 String의 중요한 메소드 10가지씩 조사해서 테스트 해보기
        String abc = "abc";
        System.out.println("인덱스 추출 : " + abc.charAt(1));

        String name1 = "조이루";
        String name2 = "조이루";
        System.out.println("문자열 비교" + name1.equals(name2));

        String subject = "자바 프로그래밍";
        int index = subject.indexOf("프로그래밍");
        System.out.println("문자열이 시작되는 인덱스 조회 :" + index);

        String original = "Java Programming";
        System.out.println(original);
        System.out.println("대문자로 : " + original.toUpperCase());
        System.out.println("소문자로 : " + original.toLowerCase());
    }
}
