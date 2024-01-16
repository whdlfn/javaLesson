package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.Myapp.JavaWord;

public class JavaWordApp_V1 {

    /*
     * JavaWordApp_V1
     */

    // private : 현재 클래스에서만 사용할 목적으로 접근 제한
    private List<JavaWord> words = new ArrayList<>();

    // 프로그램 실행을 시작하는 메소드
    private void start() {
        initialize(); // words 리스트 요소를 몇개만 저장해서 초기화
        // 단어 등록, 목록, 검색, 삭제 기능을 메뉴로 구현
        System.out.println("단어장 프로그램 시작합니다 ~~" + "~".repeat(30));
        while (true) {
            System.out.println("\t 메뉴 선택 >> ");
            System.out.println("\t 1. 단어 등록");
            System.out.println("\t 2. 단어 목록 조회");
            System.out.println("\t 3. 단어 검색");
            System.out.println("\t 4. 단어 삭제");
            System.out.println("\t 5. 프로그램 종료");
            System.out.print("선택 >> "); // 메소드에 입력 가능이 있으면 Scanner 관리가 불편
            int select = Integer.parseInt(System.console().readLine()); // 키보드 입력. parseInt : 문자열-> 정수로

            // System.console() : 시스템의 콘솔(표준입출력 장치) 객체를 리턴 : redLIne 입력 메소드 실행
            switch (select) {
                case 1:
                    addWord(); // 단어 등록 메소드 실행
                    break;

                case 2:
                    lisetWord(); // 단어 목록 조회 메소드
                    break;

                case 3:
                    seatchWord(); // 단어 조회 메소드
                    break;

                case 4:
                    removeWord(); // 단어 삭제 메소드
                    break;

                case 5:
                    addWord(); // main종료
                    System.out.println("프로그램 종료");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 섵택");
                    // break; defult는 없어도 됨
            }// switch
        } // while end
    }// start end

    private void initialize() {
        // words 리스트 요소를 몇개만 저장해서 초기화
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("private", "사적인", 1));
        words.add(new JavaWord("iterator", "반복하다", 3));
        words.add(new JavaWord("applicarion", "응용프로그램", 2));
    }

    private void lisetWord() {
        // list words에 저장된 요소(항목)등을 모두 출력하기 하,,ㅈㄴ예쁘게

        System.out.println(String.format("%-20s %-20s\t  %-20s", "ENGLISH", "KOREAN", "LEVEL"));

        for (JavaWord word : words) {
            System.out.println(
                    String.format("%-20s %-20s\t %-20s", word.getEnglish(), word.getKorean(), word.getLevel()));

        }

    }

    // 단어 삭제 : 단어장에 동일한 단어 2번이상 있는 경우
    //      삭제하기 전에 if문으로 사용자 확인을 함 
    private void removeWord() {
        System.out.println("\t:: 단어 삭제 합니다.::");
        System.out.print("삭제할 단어를 영문으로 검색하세요. _");
        String toRemove = System.console().readLine();
        int indexToRemove = -1; // 삭제할 단어의 인덱스 초기화 false 상태로 시작
    
        for (int i = 0; i < words.size(); i++) {
            JavaWord word = words.get(i);
            if (word.getEnglish().equals(toRemove)) {
                System.out.println("삭제할 단어 : " + word.getEnglish() + " = " + word.getKorean() + ". 레벨 : " + word.getLevel());
                System.out.print(toRemove + "를 삭제 하시겠습니까? (y/n)");
                String confirmation = System.console().readLine();
    
                if (confirmation.equalsIgnoreCase("y")) {
                    indexToRemove = i; // 만약 사용자가 삭제를 선택하면 indexToRemove 변수에 현재 단어의 인덱스를 저장
                    break; // 삭제할 단어를 찾았으므로 반복문 종료
                } else {
                    System.out.println("삭제가 취소되었습니다.");
                    return; // 삭제가 취소되면 메소드 종료
                }
            }
        }
    
        if (indexToRemove != -1) {  //인덱스가 들어가 있다면
            words.remove(indexToRemove); // 삭제할 단어의 인덱스를 사용하여 리스트에서 삭제
            System.out.println("단어가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 단어를 찾을 수 없습니다.");
        }
    }
    

    private void seatchWord() {
        System.out.println("\t:: 단어 검색 합니다.::");
        System.out.print("검색할 단어를 영문으로 검색하세요. _");
        String find = System.console().readLine();
        boolean found = false;
        for (JavaWord word : words) {
            if (word.getEnglish().equals(find)) { // 문자열 비교는 equals ==이거 쓰면 안됨
                System.out.println(
                        "검색결과 : " + word.getEnglish() + " = " + word.getKorean() + ". 레벨 : " + word.getLevel());
                return; // 1. 단어를 한개 찾으면 searchWord 메소드 종료
                // found = true; //2. 같은 단어가 2번 이상 저장될 때
            }
        }

        // if (!found) { //if문 조건검사 같은 단어가 2번이나 단어장에 있을 때
        System.out.println("찾는 단어가 없습니다");

        // }

    } // 리스트에 동일한 단어가 2번 저장되었다면 됨 ㅇㅇ 중복 되니까, (중복 저장 방법에 따라 위와 같은 방법들로 할 수 있다 )
    // 리스트에 없는 단어를 조회했다면
    // 리스트에 없는 단어를 조회한다면 ? 같은 단어를 1번만 저장하게 할 땐 위와 같이 할 수 있다

    private void addWord() {
        System.out.println("\t:: 단어 등록합니다.::");
        System.out.println("영어 단어 입력하세요. _");
        String english = System.console().readLine();
        System.out.println("한글 단어 입력하세요. _");
        String korean = System.console().readLine();
        System.out.println("단어 레벨 입력하세요.(1:초급,2:중급,3:고급) _");
        int level = Integer.parseInt(System.console().readLine());

        words.add(new JavaWord(english, korean, level));

    }

    public static void main(String[] args) {

        // 프로그램 실행한는 객체 생성하고(메소드로 기능을 분리할 때 main이 호출하는 static을 없애기 위함)
        // start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V1 app = new JavaWordApp_V1();
        app.start();
    }

}
