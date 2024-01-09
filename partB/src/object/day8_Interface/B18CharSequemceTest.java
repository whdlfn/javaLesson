package object.day8_Interface;

//자바에서 만든 인터페이스
public class B18CharSequemceTest {
    public static void main(String[] args) {
        CharSequence csstr = new String("hello");
        CharSequence cssb = new String("자바");

        String temp = "자바 hello hi java";
        System.out.println("charsqunce타입을 인자로 하는 메소드 확인");
        System.out.println("constains : temp 객체에 csstr문자열이 포함되어 있는가 ");
        System.out.println(temp.contains(csstr));
        System.out.println(temp.contains(cssb));
        System.out.println(temp.contains("Hello")); //대소문자 구분

        System.out.println("메소드 인자가 인터페이스 타입일 땐");
        System.out.println("여러가지 구현 클래스가 인자로 전달될 수 있다");

    }
}
