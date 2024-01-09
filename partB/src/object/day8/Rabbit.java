package object.day8;

public class Rabbit extends Animal{
    public static final String TYPE ="토끼";
	
	public Rabbit() {
	}
	
    //생성자 정의가 없으면 - 기본 생성자 그리고 자동으로 부모 생성자 super() 호출
    // 복습 : 자식 객체가 생성될 때, 먼저 부모객체를 생성(생성자 호출)하고 자식 인스턴스 요소가 추가됨
    // 이 때 부모 생성자는 super() 이 기본
	
	@Override
	public void sound() {
		System.out.println(this.color +" 토끼는 쾈하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}

	// toStinrg을 재정의하지 않으면 부모 toString의 실행되고 부모의 type 상수값 출력
	//static 필드, 메소드는 객체의 특징이 해당되지 않는다
}


