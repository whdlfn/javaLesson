package collection.day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C05MapExam {
    public static void main(String[] args) {

        // Map는 인터페이스다
        /*
         * Map <k,v> : key값으로value 를 가져오기. key, value 는 모든 타입 Object
         * : key는 중복된 값을 가질 수 없다. key와 value 모두 순서가 없다
         * map에 입력한 순서대로 접근해야 한다면 LinkeHashMap
         * 또는 정렬(key기준) 된 방식으로 접근해야 한다면 TreeMap - key의 정렬
         * Map의 구성요소 key Value 중에서 key는 set의 성질을 가지고 있다
         */
        Map<String, String> map = new TreeMap<>(); // LinkedHashMap<>(); //HashMap<>();
        map.put("tw", "트와이스");
        map.put("nu", "뉴진스");
        map.put("as", "에스파");
        map.put("gr", "소녀시대");
        map.put("tw", "원더걸스"); // key가 중복 됐다면 value가 바뀜 -> value수정
        map.put("js", "뉴진스");
        System.out.println("map 의 크기 = " + map.size());
        System.out.println("map 에 저장된 문자열 = " + map);

        System.out.println("\nmap의 get메소드 테스트");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("찾을 값에 대한 key를 입력 >> ");
            String key = sc.nextLine();
            if (key.equals("end")) { // end 입력하면 while종료
                break;
            }
            System.out.println("당신이 원하는 key의 값 = " + map.get(key));
        }

        System.out.println("== Iterator 반복자를 이용한 set 의 값 가져오기 ==");
        System.out.println("\t map.keySet() ? " + map.keySet()); // 맵의 key만 가져와서 set생성
        Iterator<String> mapIterator = map.keySet().iterator(); // 키 값으로 반복자를 생성
        int cnt = 0;
        while (mapIterator.hasNext()) {
            String temp = mapIterator.next(); // 반복자가 가져온 값은 key
            System.out.println(String.format("count=%d , key= %s , value=%s",
                    cnt++,
                    temp, // key
                    map.get(temp))); // value
        }

        System.out.println("for 반복자로 출력하기 ");
        for (String key : map.keySet()) // map의 key 값들로 반복자 실행하기
            System.out.println(String.format("count=%d , key= %s , value=%s",
                    cnt++,
                    key, // key
                    map.get(key))); // value



        System.out.println("map.value() ? "+map.values());
        // 조회
        System.out.println("map.containsKey((\"tt\")) ? "+map.containsKey("tt"));
        System.out.println("map.containsKey((\"js\")) ? "+map.containsKey("js"));
        System.out.println("map.containsKey((\"에스파\")) ? "+map.containsKey("에스파"));
        System.out.println("map.containsKey((\"잇지\")) ? "+map.containsKey("잇지"));
    }




    
}
