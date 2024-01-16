package collection.day10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class C02MemebrList {
    public static void main(String[] args) {
        

        List<Member> list = new ArrayList<>();

        list.add(new Member("momo", 23));
        list.add(new Member("nana", 20));
        list.add(new Member("dahy", 22));
        list.add(new Member("sana", 33));
        list.add(new Member("momo", 23));

        //컴파일러는 객체의 hashcode 같으면 equals 검사. 둘 다 통과하면 동일 객체로 판다 
        // remove나 IndexOf할 때 사용

        System.out.println("현재 리스트 내용 : "+list+", 크기 : "+list.size());
        list.remove(new Member("momo", 23));  //객체를 새로 만들어서 그럼 new할 때마다 다른 객체를 만드는거임
        // 사용하려면 hashcode, equals 재정의를 해줘야 한다
        
        System.out.println("현재 리스트 내용 : "+list+", 크기 : "+list.size());
        
        System.out.println("특정 멤버 조회 : "+list.indexOf(new Member("momo", 23)));  //검색 안 되면 -1 
        // 사용하려면 hashcode, equals 재정의를 해줘야 한다

        // new Member("momo", 23)  에서 인스턴스 필드값이 같다고 동일한 값이 객체가 아님
        //remove, IndexOf등의 메소드는 동일한 객체를 찾아서 삭제, 조회 
        //(예외) String은 문자열 리터럴이 같으면 조소가 같다 - 불변객체 
        // 일바적으로 만들어진 클래스는 hashcode로 메모리의 참조위치를 알아냄 
        //                  인스턴스 필드 내용이 같으면 hashcode를 똑같이 만들도록 재정의한다

       
        //static객체가 아님(클래스 메소드가 아니다). 인스턴스 메소드 
        list.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.getAge() - o2.getAge();       //나이 오름차순
            }
        });

        System.out.println("정렬 후 : "+ list);




        // List의 static메소드
        //      테스트용 리스트 만들 떄 사용. 불변객체임
        List<String> names = List.of("momo","nana");
        System.out.println("names : "+names);

        // names.add("GHJH");


    }
}
