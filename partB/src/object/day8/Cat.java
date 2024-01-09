package object.day8;

public class Cat extends Animal {
    public static final String TYPE ="고양이 ";
	
	public Cat() {
	}
	
	//본인이 받은 걸 부모한테 전달
	public Cat(String color) {
		super();     //생략가능 super() 는 자식 클래스 새성자에서 기본 호출됩니다
        this.color =color;
	}
	
	
	@Override
	public void sound() {
		System.out.println(this.color +" 고양이는 야옹하고 짖습니다. ");

	}

	@Override
	public String toString() {
		return TYPE+"[color=" + color + ", name=" + name + "]";
	}

	// toStinrg을 재정의하지 않으면 부모 toString의 실행되고 부모의 type 상수값 출력
	//static 필드, 메소드는 객체의 특징이 해당되지 않는다
}
