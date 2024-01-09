package object.day7;

import object.test.Square;

/*
 * 다향성이 어떻게 구현되는 것인지
 */

public class B12PolymorphisExam {
    public static void main(String[] args) {

        Shape[] sh = new Shape[5];

        sh[0] = new Diamond();
        sh[0].setShapeName("💎💎");

        sh[1] = new Triangle("세모", 120, 40, 45);

        sh[2] = new Square();
        sh[2].setShapeName("🆑🆑");

        sh[3] = new Diamond();
        sh[3].setShapeName("💠💠");

        sh[4] = new Square();
        sh[4].setShapeName("🆘🆘");

        // 여기까지 부모타입 배열에 자식 객체들을 생성해서 참조 시켜 놓음

        // 다형성 : 자료구조에 저장된 객체가 하나의 타입 Shape이지만 실행되는 draw동작은 모두 다름

        // instanceof
        // 객체가 어떤 클래스인지, 어떤 클래스를 상속받았는지 확인하는데 사용하는 연산자 이다.
        // 즉, 참조변수가 참조하고 있는 인스턴스의 실제 타입을 알아보기 위해 해당 연산자를 사용한다.

        for (int i = 0; i < sh.length; i++) {
            System.out.println(i + "번 도형");
            sh[i].draw();

        }

        // 부모타입으로 참조되는 객체들이 재정의된 draw() 메소드를 실행합니다
        // **다형성은 메소드를 한가지를 통일해서 실행하나 결과는 여러 형태로 보이는 것
        //          자식 클래스가 메소드 오버라이드를 할 수 있기 때문에 가능하다 

        System.out.println("자식 객체의 실제 타입을 검사하는 instancof~~~~~~~~~~~~");

        for (int i = 0; i < sh.length; i++) {
            System.out.println("도형 : "+sh[i].getShapeName());
            System.out.println("\tsh[i] instanceof Triangle :  " + (sh[i] instanceof Triangle));
            System.out.println("\tsh[i] instanceof Diamond : "+(sh[i] instanceof Diamond));
            System.out.println("\tsh[i] instanceof Square : "+(sh[i] instanceof Square));
        }

        System.out.println("~~~~~~~~~shape배열에 저장된 객체 중 삼각형 객페는 넓이를 구해서 출력~~~~~~~~~~~");
        // 4.번 인덱스 도형을 새로운 Triangle 객체로 참조해서 아래 코드 실행
        sh[4] = new Triangle("null",   33, 33, 34);

        for (int i=0; i<sh.length; i++){
            if(sh[i] instanceof Triangle) {  //trun
                //반드시 실체 객체가 triamgle일 때만 강제캐스팅함. 그렇지 않으면 오류
                Triangle tempTriangle = (Triangle) sh[i];
                System.out.println("i = " + i+"는 삼각형 넓이 : "+sh[i].calculateArea());
                tempTriangle.printAngle();
            }                                                  
        }
        System.out.println("~~~~~~~~삼각형 Triangle 객체는 넓이를 구해서 출력하기~~~~~~~~~~~");

        // for문 반복할 대 알아서 순서대로 1개씩 배열 요소를 가져오기. 인덱스 1값을 사용하지 않을 때 
        // i가 얼마인지 출력하고 싶으면 원래대로 쓰기
        for(Shape temp : sh) {
            if(temp instanceof Diamond){
                temp.draw();
            }
        }

        //upCasting 
        Shape sha= new Diamond();

        
        //Down Casting 
        Shape dia = (Diamond) sha;  //sh의 실체 객체가 다운 캐스팅 하려는 타입인지 검사 필수 (instanceof로 검사)
                                    //sh의 실제 객체가 아닌 것 Triangle등,, Diamond로 캐스팅하면 오류

        //자식 객체의 인스턴스 메소드 iAmDiamode는 반드시 다운캐스팅을 해야 실행 가능
        dia.iAmDiamode();
        dia.toString();
    }
}
