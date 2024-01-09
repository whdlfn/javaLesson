package object.day8_Interface;

/*
 * 인터페이스는 규칙이다 -> 상속과는 다른 개념
 * 핵심은 추상 메소드를 "규칙으로만" 정의하는 것이다 
 * 		인터페이스는 직접 객체를 생성하지 않습니다
 * 		클래스가 인터페이스를 가져다가 규칙을 적용하도록 한다 -> 인터페이스 구현클래스 
 */


//인터페이스 형식 알아보는 연습 
public interface InterfaceA {
	//생성자는 없습니다. -> 직접 객체를 생성하지 않습니다. 
	//필드는 상수만 가능합니다. public static final 생략함. 규칙을 정의할 떄 필요한 상수값 선언
	int SIZE = 100;
	
	
//인터페이스 구성 - 아래 4개만 포함될 수 있다. 아래 요소들은 모두 public
	//  *1)추상메소드(public abstract 생략함.) 
	//   2)인스턴스(default)메소드 
	// 	 3)static메소드 
	//   4)상수
	
	//1)추상 메소드
	void methodA();
	int methodB(int num);
	
    //2) default 키워드는 default 한정자 의미가 아니고 인스턴스 메소드 의미
	default void methodC(String message) {
		System.out.println("메시지 수신 : " + message);
	}
	
	//3)
	static void medthodD() {
		System.out.println("나는 static 메소드입니다.");
	}
	
}
