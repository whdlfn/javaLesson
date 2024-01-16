package object.day9;

/*
 *  인터페이스 예시 - 비교 가능한 객체 만들기
 *                객체 비교 방법 1) Comparable 인터페이스 구현
 * Comparable<Menber> 는 <>안에 타입을 표시함 -> 레너릭타입
 *              레너릭타입은 클래스 또는 인터페이스의 메소드에게 데이터타입을 매개변수로 전달하기 위한 방식
 *              이 때 타입은 실행 시점에서 결정됨. 기본형은 Wrapper 클래스로 사용
 *              Comparable 인터페이스가 실행하는 메소드에 Member타입을 전달
 * Comparable 비교할 수 있는
 */
public class Member implements Comparable<Member> {
    private String id;
    private int age;

    public Member(String id, int age) {
        this.id = id;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    

    @Override
    public String toString() {
        return "Member [id=" + id + ", age=" + age + "]\n";
    }


    // Comparable인터페이스의 추상메소드 CompareTO를 구현
    @Override
    public int compareTo(Member o) { // 메소드의 인자 타입Member는 <> 제너릭 타입과 같게 만들어짐
        // 현재 객체 this를 인자로 전달되는 Member객체와 비교하도록 함
        // 비교기준은 요구사항에 따라 개발자가 정함
        // 만약에 나이로 한다면
        // return this.age - o.age;  //나이 오름차순
        // return o.age - this.age; //나이 내림차순

        // 이름으로 한다면
        // return this.id.compareTo(o.id);   //이름 오름차순
        return o.id.compareTo(this.id);     //이름 내림차순
    }
}
