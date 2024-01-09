package object.day7;

//shape과 Triangle객체 생성하고 메소드를 테스트
public class B09ShapeMain {
    public static void main(String[] args) {
        Shape sh = new Shape("정사각형", 15, 15);
        System.out.println(sh.calculateArea());
        
        Triangle tr = new Triangle("직사각형", 15, 20, 90);
        
        System.out.println("재정의 메소드");
        System.out.println(sh.getHeight()+"의 넓이 : "+sh.calculateArea());
        
        System.out.println("부모 클래스가 정의한 메소드 확인");
        sh.print();
        tr.printAngle();
        
        //getWidth, getHeight 는 부모 클래스 Shape에서 정의함. 자식도 실행가능
        System.out.println("직사각형 높이 : "+ tr.getHeight());
        System.out.println("직사각형 너비 : "+ tr.getWidth());
        System.out.println("자식 클래스에서 정의한 메소드 ");
        System.out.println("직사각형 각도 : "+ tr.getAngle());


        //부모가 자식 객체의 메소드느 실행 못한다
        // sh.getAngle();

        // 상속에서의 변수 참조 타입 - 자식 클래스 타입, 부모 클래스 타입
        //1) 자식 객체를 부모 타입으로 참조 *****************************
        Shape temShape = new Triangle("세모", 30, 40, 90);

        System.out.println("재정의 메소드 실핼 확인~~~~~~~~~~~~~");
        System.out.println("부모타입 참조이나 객체의 실체는 Triangle이므로 ");
        System.out.println("\t 너비는 재정의 메소드로 실행됨");
        System.out.println(sh.getHeight()+"의 넓이 : "+temShape.calculateArea());

        System.out.println("~~~~~자식 클래스에서 정의한 메소드 실행확인~~~~~~~~~~~~~~~");
        System.out.println("Triangle 자식 객체를 부모 타입 Shape으로 참조할 때에는 아래 메소드는 오류");
        System.out.println("\t **getAngle은 부모 타입에는 없는 메소드 입니다");
        // System.out.println("세모 각도 : " +temShape.getAngle());    -- 오류 

        //2) 부모 객체를 자식 타입으로 참조할 수 없음 XXXXXXXXXXXX
        // 부모 객체를 자식 타입으로 참조하기 위해 강제 캐스팅함
        Triangle tempTriangle = (Triangle) new Shape("null", 0, 0);  
        // 강제 캐스팅은 했으나 Triangle에 필요한 인스턴스 필드가 안 만들어져서 오류
        

    }
}
