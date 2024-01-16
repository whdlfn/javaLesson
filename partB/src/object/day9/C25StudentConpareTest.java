package object.day9;

import java.util.Arrays;
import java.util.Comparator;

//Arrays.sort 메소드에 두번째 인자로 Comparator 인터페이스 타입 객체를 전달하면
//     비교 기준과 정렬 방법을 실행시점에서 결정
public class C25StudentConpareTest {
    public static void main(String[] args) {

        Student[] students = new Student[4];
        students[0] = new Student("장모모", 23);
        students[1] = new Student("박나연", 20);
        students[2] = new Student("김다현", 32);
        students[3] = new Student("걍사나", 24);

        System.out.println("초기 Student 배열 : " + Arrays.toString(students));
        // Arrays.sort(students); // 오류 : Student 객체를 Comparble 이 아님




       //재사용이 필요 없다면 변수를 선언하지 않고 바로 인자로 전달
        Arrays.sort(students,  new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) { // o1과 o2객체 비교
                return o1.getAge() - o2.getAge(); 
                //o1(왼쪽) , o2(오른쪽) 이며 오름/내림 상관없이 교환을 안해도 되는 경우를 음수값으로 리턴하면 됨
                //sort 메소드 정렬 알고리즘은 비교결과 음수가 리턴되면 교환하지않고 
                //                                  양수 리턴하면 교환함
            }
        });
        System.out.println("나이 오름차순 정렬 후 Student : " + Arrays.toString(students));








        // ageDeceding
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) { // o1과 o2객체 비교
                return o2.getAge() - o1.getAge();
            }           //내림차순 o1 > o2 이 되어야 함
                        // o2-o1< 0 이면 교환하지 않음
        });
        System.out.println("나이 내림차순 Student 배열 : " + Arrays.toString(students));






        //위의 람다식은 Comparator 구현 클래스 정의 : 추상 메소드는 1개 compare
        //          메소드의 인자는 Student 타입 o1, o2
        //          메소드 실행과 리턴은 {} 몸통에 작성
        // nemaAscending
        Arrays.sort(students, (o1,o2) -> {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("이름 오름차순Student 배열 : " + Arrays.toString(students));






        // nemaDecending
        Arrays.sort(students, (o1,o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        System.out.println("이름 내림차순 Student 배열 : " + Arrays.toString(students));



    }
}



    


    
