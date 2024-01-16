package collection.day10;

import java.util.ArrayList;
import java.util.List;

public class C01lisetExam {
    public static void main(String[] args) {
        
        List<String> strlist = new ArrayList<>();
        //List 인터페이스를 구현한 클래스가 ArrayList
        strlist.add("트와이스");
        strlist.add("아이브");
        strlist.add("레드벨벳");
        strlist.add("뉴진스");
        strlist.add("르세라핌");

        System.out.println("문자열 List strlist size : "+ strlist.size());    //크기 
        System.out.println("\n 데이터 추가");
        strlist.add("원더걸스");            //추가는 끝번으로 된다
        System.out.println("항목 추가 후 리스트 : "+ strlist);   //ArrayList클래스와  toString재정의 메소드 실행
        
        //2가지 방법으로 삭제
        System.out.println("\n 데이터 삭제");
        strlist.remove("원더걸스");
        System.out.println("항목 삭제 리스트 : "+ strlist);
        strlist.remove(0);   //메소드 인자 타입이 int와 String
        System.out.println("항목 삭제 리스트 : "+ strlist);
        
        //아래 2개 메소드 비교
        System.out.println("\n 데이터 변경");
        strlist.add(0,"!!!!!!!!!!");        //뒤에 있는 것이 밀리고 들어감(중간 삽입)
        System.out.println("항목 변경 후 리스트 : "+ strlist);
        strlist.set(0,"??????????");        //걍 수정
        System.out.println("항목 변경 후 리스트 : "+ strlist);
        
        
        System.out.println("\n특정 인덱스 위치의 요소값 가져오기");
        System.out.println("strlist.get(2) : "+strlist.get(2));  //하!🤩
        
        
        // addAll'
        List<String> subList = new ArrayList<>();
        subList.add("투바투");
        subList.add("세븐틴");
        subList.add("더보이즈");

        System.out.println("\n 데이터 변경");
        strlist.addAll(subList);
        System.out.println("addAll sublist 실행 후  : "+ strlist);
        strlist.add("르세라핌");   //중복값 허용
        System.out.println("이미 저장되어 있는 값도 추가 됨?  : "+ strlist);
        
        // contains
        System.out.println("\n\n리스트에서 항목 찾기");
        System.out.println("\t 리스트에 처음 `레드벨벳` 어디 있음? " + strlist.indexOf("레드벨벳"));
        System.out.println("\t 리스트에 마지막 `레드벨벳` 어디 있음? " + strlist.lastIndexOf("레드벨벳"));
        System.out.println("\t 리스트에 `뉴진스` 있음? " + strlist.contains("뉴진스"));
        System.out.println("\t 리스트에 `뉴진스` 어디 있음? " + strlist.indexOf("뉴진스"));

        // indexOF
        // lastIndexOf





        /*
         * list 구현 클래스 특징 : 배열처럼 인덱스가 있다. 인덱스가 있다는 건 -> 데이터에 순서가 있다는 것***
         *              배열에 없는 "삭제" 기능이 있다
         *                  그 외에 조회 관련 그능 등 조작과 조회를 다양하게 할 수 있음
         * 
         */

    }
}
