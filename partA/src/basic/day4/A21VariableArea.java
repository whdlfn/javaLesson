package basic.day4;

public class A21VariableArea {


    int number = 999;   // 1. 클래스 범위에서 사용되는 변수 
    static int number2 =999;
    public static void main(String[] args) {
        // 변수의 선언 위치 -> 변수 사용 범위 결정
        int a = 23;     //2. main 메소드 범위에서 사용되는 변수 


        for(int i=0; i<10; i++){    //3. 특정 블럭 안에서 사용되는 변수
            System.out.println("i = "+i);
        }

        while (a==23) {
            int count;
            System.out.println("a="+a);
            count=100;              //3. 특정 블럭 안에서 사용되는 변수 
            System.out.println("count = "+count);
            // 종료 조건이 없으면 무한 반복
            a= 24;
        }

        System.out.println("a="+a);
        // System.out.println("i= "+i);// 문법오류 - 이 지점에서 i는 알 수 없는 변수 ㅁ

        // main메소드가 static 메소드임. static은 static끼리만 사용할 수 있음
        // System.out.println(number);  //static이 아닌 클래스 선언 변수는 사용 못 함 
        System.out.println(number2);
    }
}
