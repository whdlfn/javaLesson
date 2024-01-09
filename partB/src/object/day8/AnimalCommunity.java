package object.day8;

public class AnimalCommunity {

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~~~~~~여기는 유기동물 보호소 입니다~~~~~~~~~~~~");
		Animal[] animals = new Animal[10];
		animals[0] = new Puppy("푸근이", "브라운");
		animals[1] = new Cat("노랑");
		animals[2] = new Rabbit();
		animals[2].setColor("화이트");
		animals[3] = new Puppy("리트리버", "누렁이");

		// 퀴즈 : 아라ㅐ 개게를 배열 요소에 대입함 수정이 필요한 코드는
		animals[7] = new Animal() {
			static final String TYPE = "새";

			@Override
			public void sound() {
				System.out.println("안녕");
			}

			@Override
			public String toString() {
				return TYPE + "[color=" + color + ", name=" + name + "]";
			}

		};

		animals[7].setName("앵무");
		animals[7].setColor("초록");

		System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] != null) // 배열요소에 참조되는 객체가 있는지(참조값이 있는지)
				animals[i].sound(); // null일 때 메소드 실행하면 오류
		}

		// 모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크 - 동물보호소 규정(비지니스 로직)
		// 강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 분양받을 수 있습니다. 그 이외는 20세이상
		// Member 클래스 : isAdopt 메소드에서 실행 => intanceof

		String name = "모모";
		int age = 17;
		Member member = new Member(age, name); // Member클래스 인스턴스 필드는 age, name2개

		StringBuilder sb = new StringBuilder(name); // String 문자열은 연결결과 다음 문자열이 나오면 객체 새로만들어 저장
		// String은 불변객체(문자열 변경 못 함),
		// StringBuildersms 는 가변 객체(문자열 변경 가능. 문자열 추가연산결과를 동일 객체에 저장) => 문자열 연결연산에 사용
		sb.append(" 회원님 \n"); // Message += "회원님 \n"
		boolean result;
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] == null)
				// break 첫번째로 null을 만나면 나옴
				continue; // 다음 코드를 실행하지 않고 반복문 처음으로 돌아감
			result = member.isAdopt(animals[i]); // 인자를 animal 타입으로 전달받는 메소드(다향성 예시)
			sb.append(animals[i].toString()); // message += animals[i].toStinrg()
			if (result) {
				sb.append("분양 가능합니다. \n");
			} else {
				sb.append("분양 자격이 안됩니다.\n");
			}
			String temp = member.isAdopt(animals[i]) ? "분양 가능\n" : "불가능";
			sb.append(temp);
		}
		System.out.println();
		System.out.println(sb.toString()); // StringBuilder 타입 객체는 println의 인자로 쓸 때 toString명시적 실해

	}// main end

}
