package collection.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C03MemberListPrint {
    public static void main(String[] args) {
        List<Member> list = new ArrayList<>();

        list.add(new Member("momo", 23));
        list.add(new Member("nana", 20));
        list.add(new Member("dahy", 22));
        list.add(new Member("sana", 33));
        list.add(new Member("momo", 26));

        // toString 재정의된 출력이 아닌 직접 출력
        System.out.println(String.format("%15s\t %15s", "name", "age"));
        for (int i = 0; i < list.size(); i++) {
            Member temp = list.get(i);
            System.out.println(String.format("%15s\t %15d", temp.getName(), temp.getAge()));
            // temp에 저장하지 않고 출력 할 때
            System.out.println(String.format("%15s\t %15d", list.get(i).getName(), list.get(i).getAge()));

        }

        // 컬렉션에서는 반복자로 데이터에 접근. 인덱스가 얻ㅄ는 자료구조에서 주로 사용
        // Iterator
        System.out.println("~~~~~~~~~반복자를 이용한 출력~~~~~~~~~~~~");
        java.util.Iterator<Member> iterator = list.iterator(); // list로 선언된 자료구조에 접근할 반복자 선ㅇ언
        int count = 0;
        while (iterator.hasNext()) { // 반복자가 접근할 다음 데이터가 있으면 참
            Member temp = iterator.next(); // 반복자가 다음 데이터를 가져옴
            System.out.println("\t count = " + count++ + ", 요소 = " + temp);
            
        }
        
        // iterator 로 동작하는 for
        System.out.println("~~~~~~~~~iterator로 for 출력~~~~~~~~~~~~");
        count = 0;
        for (Member temp : list) {
            System.out.println("\t count = " + count++ + ", 요소 = " + temp);

        }
    }
}
