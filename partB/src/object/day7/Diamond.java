package object.day7;

public class Diamond extends Shape {
    

    //생성자 정의가 영시적으로 없으면 기본생성자를 싱행한다
    // 자식 클래스는 부모클래스 기본생성자를 먼저 실행


    //자식이지만 부모가 private해서 안됨
    // public void setshapeName(String shapNmae){
    //     this.shapeName = shapNmae;
    // }

    //부모가 protected

    public void setEct(String etc){
        this.etc =etc;
    }

    public void setRound(int round){
        this.round=round;
    }

    @Override
    public void draw() {
        System.out.println("다이아몬드 "+ this.getShapeName()+"을 그린다");
    }

    //자식 클래스가 정의한 인스턴스 메소드 - 다이아몬드 타입으로 선언한 참조변수만 실행할 수 있음
    public void iAmDiamode(){
        System.out.println("다이아");
    }

    //object클래스의 toStirng메소드를 오버라이드
    //              object.day7.Diamond@46f5f779 가 기본인 것을 다른 문자열로 바꿈
    @Override
    public String toString() {
        return "Diamond []";
    }

    // 접근 한정자
    /* 
 * 접근 한정자
 * public           : 모두에게 공개
 * private          : 모두에게 숨기기
 * protected        : 같은패키지 클래스와 다른 패키지인 경우는 자식에게만 공개
 *                      ㄴ Shape의 etc 는 자식인 Triangle, Diamond 에게는 공개 / 같은 패키지 B10DiamondTest 에게도 공개
 *                      ㄴ 그 외의 경우는 비공개. 다른 패키지이지만 자식 클래스라면 공개
 * 아무것도 안씀     : 거의 사용하지 않습니다. 같은 패키지 클래스에게만 공개
 *                       ㄴ object.day7 패키지 클래스에게는 모두 공개 / 그 외에는 숨기기
 * 
 */


}
