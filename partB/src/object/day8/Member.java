package object.day8;

public class Member {
    private String name;
    private int age;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }

    // 강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 분양받을 수 있습니다. 그 이외는 20세이상
    // Member 클래스 : isAdopt 메소드에서 실행 => intanceof
    // 다형성 예시 : 메소드 인자가 부모 타입일 때, 실제 객체는 여러 자식 객체가 될 수 있다
    // ㄴ 실행할 떄 결정
    public boolean isAdopt (Animal animals) {
        if (animals instanceof Puppy && age >15) {
            return true;
        } 
        else if (animals instanceof Puppy && age >18) {
            return true;
        }
        else if (animals instanceof Cat && age >13) {
            return true;
        }
        else if (age >=20){
            return true;
        } 
        else return false;
    }}
