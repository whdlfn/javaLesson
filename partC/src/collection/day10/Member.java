package collection.day10;


/*
 * 아래 Member클래스는 생성될 때 초기화하면 변경 못함 - setter없어서
 * hsahcode, equals 재정의
 * 이러한 객체를 VO 하고 함. value Object
 */
public class Member {
    private String name;
    private int age;

    public Member(String name, int age) {
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }

    // 중요 : 객체의 동일성(같은 객체)검사를 위해서 hashcode, equals 메소드 재정의하여 사용
    //      -> 해시코드 값이 같고 인스턴스 필드의 내용이 같으면 동일한 객체다
    @Override
    public int hashCode() {   //인스턴스 필드값으로 해시코드 생성하기 : name.hashcode()와 age 정수값으로 계산
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {   //대상이 되는 obj와 현재 this객체의 인스턴스 필드값이 모두 같은지 검사
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }
   
}
