package object.day7;


public class B10DiamodeTest {
    public static void main(String[] args) {
        
        // 다이아몬드 클래스에 extends Shape외에는 코드가 없다, 그러나 아래 메소드도 실행가능하다
        Diamond di = new Diamond();
        System.out.println("다이아몬드 너비 : "+di.getWidth());
        System.out.println("다이아몬드 높이 : "+di.getHeight());
        System.out.println("다이아몬드 넓이 : "+di.calculateArea());
        di.print();
        // 여기까지 확인하면 상속받은 필드값 정장하는 setter 생성가능한지 확인하기


        //접근 한정자 확인
        

        di.round =3;
        di. etc ="테스트";   
        System.out.println("변경된 내용 확인 : "+ di.round);
        System.out.println("변경된 내용 확인 : "+ di.etc);
        

    }
}
