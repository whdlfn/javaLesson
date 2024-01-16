package collection.day10;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;   //map 안에서 구성요소로 정의된 Entry내부 클래스 


// Map

public class C06TodayMeunVote {
    public static void main(String[] args) {
        String menu = "치킨 , 스파게티, 곱창, 불고기, 삼겹살";
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("치킨", 0);
        map.put("스파게티", 0);
        map.put("곱창", 0);
        map.put("불고기", 0);
        map.put("삼겹살", 0);

        System.out.println("오늘의 메뉴 추천 ");
        System.out.println("메뉴 : " + menu);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("영문 메뉴 이름을 입력 >>>");
            String key = sc.nextLine();
            if (key.equals("end")) break;

            if(map.containsKey(key)){  //containsKey 맵에 주어진 키가 있는지 검사 
                // 입력한 key의 value를 가져와서 +1 연산을 한 결과로 다시 value에 저장
                int value = map.get(key);
                // value++;
                // map.put(key, value);
                map.put(key, ++value);
            }
            else {
                // 없는 메뉴
                System.out.println("선정된 메뉴 중에서 선택하시오 ");

            }

        }
        System.out.println("투표 종료");
        System.out.println(map);
        System.out.println(Collections.max(map.keySet()));         //key중의 최대값
        System.out.println(Collections.max(map.values()));          //value중의 최대값
        // value 최대값의key는 무엇     //key와 value를 한쌍으로 만든 타입이 Entry 

        Comparator<Entry<String,Integer>> comparator = new java.util.Comparator<Entry<String,Integer>>() {
            public int compare(Entry<String,Integer> o1, Entry<String,Integer> o2) {
                return o1.getValue() -o2.getValue();
                
            };
        };

        Entry<String,Integer> maxEntry = Collections.max(map.entrySet(),comparator);
        System.out.println("최다 득표 결과 ");
        System.out.println("\t 메뉴 이름 :  "+maxEntry.getKey());
        System.out.println("\t 투표수 :  "+maxEntry.getValue());

        sc.close();
    }
}
