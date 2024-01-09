package object.day7;

/*
 * 자바의 기본 패키지는 java.lang이다
 * 지금 테스트할 math 클래스는 java.lang에 속하여 import가 필요없으나
 * Scanner 클래스와 같이 java.util등 다른 패키지에 속항 클래스는 임포트를 해야 한ㄷ다
 *      임포트를 통해서 이 프로그램에서 사용할 클래스를 메모리에 올ㄹ니다
 * 
 * 이 예제는 math클래스의 메소드를 통해 메소드 오버로딩을 확인함
 */
public class B08MathTest {
    public static void main(String[] args) {
    System.out.println("1.최대값 max, 최소값 min 구하기");
    System.out.println("Math.max(56,12) ="+ Math.max(56,12)); //인자와 리턴타입이 정수
    System.out.println("Math.max(56.34,99.123)="+ Math.max(56.34,99.123)); //인자와 리턴타입이 실수
    int min = Math.min(45, 56);
    //double dmin = Math.min(45, 56);   //자동 캐스팅
    double dmin = Math.min(56.78, 111.44);
    //int imin = (int)Math.min(56.78, 111.44);      //강제 캐스팅
        
    System.out.println("min = "+min);
    System.out.println("dmin = "+dmin);

    System.out.println("위의 메소드 이용해서 3개의 정수 34, 56,,12 의 최대값과 최소값을 구하기");
    System.out.println("3개의 정수 최대값 : "+Math.max(Math.max(34,56), 12));
    System.out.println("3개의 정수 최소값 : "+Math.min(Math.min(34,56), 12));


    //Math클래스에는 기본 수학 공식을 해경하는 메소드
    //복습 : static 메소드는 클래스의 객체를 생성하지 않고 바로 클래스 이름으로 실행되는 메소드다
    }
}
