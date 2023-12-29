package basic.day2;

public class A06PrefixPostfixTest {
	
	public static void main(String[] args) {
		
		int start =100;
		
		//증가 또는 감소연산자 (증감연산)는 다른 명령문과 같이 쓰일때 위치가 중요합니다.
		// start++ 또는 ++start는 start =start +1; 연산을 합니다
		// 너무 ㅁ낳이 사용되는 +1도는 -1 더 간단하게 증감연산 ++. -- 사용합니다
		// 전치(pre) 또는 후치(post) 차이점은 다른 명령어랑 같이 사용될 때 증감되는 시점이 다름
		// 아래 예제는 println 과 증가 ++중에 누가 먼저 실행될 것인가하는 차이
		System.out.println("== postfix 확인 (출력 후에 -1)==");
		System.out.println(start--);		//출력 후에 +1
		System.out.println(start--);		//출력 후에 +1
		System.out.println(start--);		//출력 후에 +1
		System.out.println(start--);		//출력 후에 +1

		start = 100;
		System.out.println("== prefix 확인 (-1 후에 출력) ==");
		System.out.println(--start);		// +1 후에 출력
		System.out.println(--start);		// +1 후에 출력
		System.out.println(--start);		// +1 후에 출력
		System.out.println(--start);		// +1 후에 출력
	}

}
