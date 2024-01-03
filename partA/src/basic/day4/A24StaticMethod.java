package basic.day4;

public class A24StaticMethod {

    // 프로그램을 실행시키는 main이 static이므로 여기서 같이 사용할 수 있는 
    //            다른 static 메소드 연습
    // 메소드는 소문자로 시작한다 
    // 메소드를 만드는 목적 -> 처리 기능을 main에서 따로 분리(구조화)
    //                      재사용하기 위함 
    //                      메소드는 클래스의 구성요소이다 
    public static void main(String[] args) {
        argumentTest();     //메소드 호출. 이름과 형식이 맞는 메소드 찾아서 실행
        argumentTest(999);
        argumentTest(100, 34);  //100과 34는 실매개변수
        // 메소드가 실행될 때 실매개변수값이 형식매개변수로 전달, 저장됩니다
        int a=100, b=29;
        // argumentTest(a, b);     //실매개변수

        int result = resultIntTest();   //리턴값이 있는 메소드는 변수에 넣을 수 있음
        System.out.println(result);

        boolean bo = resultBooleanTest();
        System.out.println(bo);

        char ch = resultChar();
        System.out.println(resultChar());

        String str = resultStringTest();
        System.out.println(str);

        int ad = add(2, 4, 6);
        System.out.println(ad);
        System.out.println(add(3.4, 2.6, 1.0));
    }


    // 1~4 인자로 선언된 ()안의 변수는 메소드의 지역변수
        // 인자가 없는 메소드
    public static void argumentTest(){
        System.out.println("인자가 없는 메소드");
    }
        // 인자가 1개 있는
    public static void argumentTest(int i){     //인자로 사용된 i는 이 메소드에서만 사용
        System.out.println("인자가 1개 정수 : "+i);
    }
        // 인자가 2개 있는
    public static void argumentTest(int i, int j){      //i,j는 형식 매개변수 
        System.out.println("인자가 2개 있는");
        System.out.println(i+j);
    }

    // -----------------------------------------------------------
        // 리턴값이 정수인 : 리턴은 메소드 실행한 결과값입니다 
    public static int resultIntTest(){
        return 99;
    }
        // 리턴값이 boolean
    public static boolean resultBooleanTest(){
        return false;
    }
        // 리턴값이 String
    public static String resultStringTest(){
        return "hi";
    }
        // 리턴값이 char
    public static char resultChar(){
        return 'a';
    }


    // ------------------------------------
    // 인자와 리턴값이 모두 있는
    public static int add(int a, int b, int c){
        return a+b+c;
    }

    public static double add (double a, double b, double c) {
        return a+b+c;
    }

    
}
