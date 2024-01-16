package collection.day10;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class C04setExam {
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("트와이스");
        set.add("아이브");
        set.add("잇지");
        set.add("뉴진스");
        set.add("트와이스"); // 중복 안됨
        set.add("소녀시대");
        System.out.println("~~~~~~~~~~~~~~~~~HashSet~~~~~~~~~~~~~~~~~~~");
        System.out.println("set : " + set);
        System.out.println("set size : " + set.size());

         System.out.println("\tset 데이터 요소 하나씩 접근");
        for (String temp : set) {
            System.out.println("\t set 요소 " + temp);
        }
        // set 인덱스 없음
        // for(int i = 0; i<set.size(); i++)와 같은 방식은 불가

        Set<String> set2 = new LinkedHashSet<>();
        // 본래의 set은 순서가 없으므로 무작위로 접근
        // linked는 다음 입력 데이터의 참조값을 저장하여 입력 순서대로 접근하도록 함
        // LinkedHashSet은 중복을 허용하지 않는 Set의 특성을 가지며, 동시에 입력된 순서를 기억합니다.
        set2.add("트와이스");
        set2.add("아이브");
        set2.add("잇지");
        set2.add("뉴진스");
        set2.add("트와이스"); // 중복 안됨
        set2.add("소녀시대");
        System.out.println("~~~~~~~~~~~~~~~~~LinkedHashSet~~~~~~~~~~~~~~~~~~~");
        System.out.println("set2 : " + set2);
        System.out.println("set size2 : " + set2.size());

       

        Set<String> set3 = new TreeSet<>();
        // 이진트리 알고리즘을 이용하여 데이터를 정렬된 방식으로 접근
        set3.add("트와이스");
        set3.add("아이브");
        set3.add("잇지");
        set3.add("뉴진스");
        set3.add("트와이스"); // 중복 안됨
        set3.add("소녀시대");
        System.out.println("~~~~~~~~~~~~~~~~~TreeSet~~~~~~~~~~~~~~~~~~~");
        System.out.println("set3 : " + set3);
        System.out.println("set size3 : " + set3.size());

    }
}

/*
 * Set : 집합
 * 순서가 없음 -> 인덱스가 없다
 * 중복값이 없다
 * 
 * Map의 구성요소 key Value 중에서 key는 set의 성질을 가지고 있다
 */
