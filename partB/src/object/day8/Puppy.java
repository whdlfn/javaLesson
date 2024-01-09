package object.day8;

public class Puppy extends Animal {
	public static final String TYPE ="강아지";
	
	public Puppy() {
	}
	
	//본인이 받은 걸 부모한테 전달
	public Puppy(String name, String color) {
		super(name,color);     //부모 클래스 생선자 호출. 인자를 전달하고 있습니다
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 강아지는 멍멍 🐶🐶하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}


	// toStinrg을 재정의하지 않으면 부모 toString의 실행되고 부모의 type 상수값 출력
	//static 필드, 메소드는 객체의 특징이 해당되지 않는다
}
