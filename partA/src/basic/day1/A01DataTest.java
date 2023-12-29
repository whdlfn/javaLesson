package basic.day1;

//데이터 연습 
public class A01DataTest {
	
	public static void main(String[] args) {
		
		//(1)데이터 저장
		int age = 19;					//나이
		double weight = 57.891234567890f;			//몸무게
		boolean isAdult;			//성인 여부
		char grade = 'C';				//등급
		
		//(2) 데이터 값 변경 - 대입문 또는 연산자 활용
		
		//예, 다이어트 한달 후에 1.3kg 감량된 몸무게 
		weight = weight - 1.3;
		// weight -= 1.3;			//weight = weight - 1.3 수식을 줄여서 쓰는 형식
		
		//예, 7년동안 직장생활을 열심히 하면 나이가 몇살이 되나요?
		age = age + 7;
		// age += 7;
		
		isAdult = age >=20;			//실행(연산)순서 :  >= 를 실행한 후에 =(대입) 실행
		
		grade='B';
		
	}
	

}
