package object.day7;

/*  클래스의 상속   - 자바에서 제공하는 클래스들의 상속관계를 이해하기 위함. 직접 만드는 것은 몇가지 기능정도
		ㄴ 자세하게(구체화된) 클래스를 만든다면 .. 삼각형,정사각형,직사각형,사다리꼴...
		ㄴ 구체화할 때 Shape 클래스를 상속받는다. 부모 클래스 Shape은 모든 도형들의 공통적인 필드와 메소드를 정의 
		ㄴ 상속받는 자식 클래스는 부모 클래스의 생성자를 호출해서 부모의 필드값을 초기화합니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 사용할수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 필드값을 가져올수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 재정의(오버라이딩) 할수 있습니다.

	↓ Shape 클래스는 추상적인 상태. 모든 도형을 대표하는 클래스로 정의하였습니다.
 */
public class Shape {

	static final int MAX_WIDTH = 100; // 상수
	//도형의 너비가 MAX_WIDTH 를 넘으면 도화지가 작아서 못 그림.. 등 기준을 정하는 예시
	//상수는 상속의 의미가 없다

	// 인스턴스 필드
	private String shapeName; // 도형 이름
	private int width; // 도형의 크기 중 너비
	private int height; // 도형의 크기 중 높이
	protected String etc;
	int round; //접근 한정자가 없는경우 

	public Shape() {
		//아래 커스텀 생성자 있을 때는 기본 생섣ㅇ자 사용하고 싶으면 직접 정의
		System.out.println("새로운 도형이 만들어 졌습니다. 초기화 필요");
	}

	// 인스턴스 필드값 초기화하는 생성자
	public Shape(String shapeName, int width, int height) {
		this.shapeName = shapeName;
		this.width = width;
		this.height = height;
	}

	// 필드값을 리턴하는 getXXX 메소드
	public String getShapeName() {
		return shapeName;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// setXXX 메소드 없음.('초기값을 바꿀수 없다'는 요구조건을 예시로 합니다. )

	// 도형의 면적(넓이) 계산하는 메소드 (계산식은 너비 *높이)
	public int calculateArea() {
		return width * height;
	}

	//자식 클래스들이 draw를 재정의해서 다른 메세지가 출력되게 만들예정

	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

	public void draw() {
		System.out.println("어떤 도형인지 아직 모름");
	}

	// final 메소드 - 재정의 할수 없는 메소드로 만들어야 할때 사용합니다.
	public final void print() {
		System.out.println("final 메소드 테스트-" + shapeName + "의 너비:" + width + ",높이:"
				+ height + ",면적:" + calculateArea());
	}
	

	//day8 : Object 클래스의 toString 메소드를 오버라이드
	@Override
	public String toString() {
		return "Shape [도형이름=" + shapeName + ", 너비=" + width + ", 높이=" + height + "면적 : " +calculateArea() + "]";
	}

	
}
