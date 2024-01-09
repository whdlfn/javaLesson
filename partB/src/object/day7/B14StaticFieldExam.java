package object.day7;


// 대표적인 자바 클래스 static 필드 확인
public class B14StaticFieldExam {
    public static void main(String[] args) {
        
        //Wrapper 클래스 : 기본 자료형을 클래스 타입 즉 객체로 다룰 수 있게 해줌
        //1. integer 
        System.out.println("Integer.MAX_VALUE"+Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE"+Integer.MIN_VALUE);
        System.out.println("Integer.SIZE"+Integer.SIZE);  //32비트
        System.out.println("Integer.BYTES"+Integer.BYTES);  //4바이트
        //long
        System.out.println("\nlong.MAX_VALUE"+Long.MAX_VALUE);
        System.out.println("long.MIN_VALUE"+Long.MIN_VALUE);
        System.out.println("long.SIZE"+Long.SIZE);  //32비트
        System.out.println("long.BYTES"+Long.BYTES);  //4바이트
        //2. Double
        System.out.println("\nDouble.MAX_VALUE"+Double.MAX_VALUE);
        System.out.println("Double.MIN_VALUE"+Double.MIN_VALUE);
        System.out.println("Double.SIZE"+Double.SIZE);  //64비트
        System.out.println("Double.BYTES"+Double.BYTES);  //8바이트
        
        //Character
        System.out.println("\nCharacter.MAX_VALUE"+Character.MAX_VALUE);
        System.out.println("Character.MIN_VALUE"+Character.MIN_VALUE);
        System.out.println("Character.SIZE"+Character.SIZE);  //16비트
        System.out.println("Character.BYTES"+Character.BYTES);  //2바이트

        System.out.println("Shape.MAX_WIDTH"+Shape.MAX_WIDTH);  //100
        System.out.println("Diamond.MAX_WIDTH"+Diamond.MAX_WIDTH);  //상속받음 (재정의 안 하면 그대로 씀)
        System.out.println("Triangle.MAX_WIDTH"+Triangle.MAX_WIDTH);  //상수 재정의

        /*
         * 위에 필드는 모두 public static final
         * public : 모두에게 공개
         * static : 객체 없이 사용할 수 있는 필드 또는 값. 정적인 메모리에 공유 영역에 모여있음
         * final 필드 : 값을 변경 못 함
         * (참고) final 메소드 : 오버라이딩 제한(못함)
         * 
         * public static int abc;
         * public final int yy;
         * 
         * 위의 2가지 경우보다는 의미상 조합이 public static final이 맞다
         * 영원히 고정되는 값에 대해 기호를 부여하는 '상수'
         * 그리고 상수는 모두 대문자로 약속됨
         */
    }
}
