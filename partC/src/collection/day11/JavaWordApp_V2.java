package collection.day11;

import java.util.ArrayList;
import java.util.List;

import collection.Myapp.JavaWord;

public class JavaWordApp_V2 {

    /*
     * JavaWordApp_V2 : 메소드 만드는 연습
     * 검색 메소드, print 메소드 리팩토링(refactoring)
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
                    searchWordby(); // 단어 조회 메소드
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

    // 추가 메소드
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

    private void lisetWord() {
        // list words에 저장된 요소(항목)등을 모두 출력하기 하,,ㅈㄴ예쁘게

        System.out.println(String.format("%-20s %-20s\t  %-20s", "ENGLISH", "KOREAN", "LEVEL"));

        printWordList(words); // 출력할 리스트 words 메소드에 전달
    }

    // 출력 메소드 : 출력할 여러개의 JavaWord 객체를 전달받아(인자) 이쁘게 출력
    private void printWordList(List<JavaWord> list) {
        for (JavaWord word : list) {
            System.out.println(
                    String.format("%-20s %-20s\t %-20s", word.getEnglish(), word.getKorean(), word.getLevel()));

        }
    }



    // searchWord 메소드 업그레이드
    private void searchWordby() {
        System.out.println("\t::단어 검색합니다.(단어 조회는 1, 레벨 조회는 2 ):::");
        String find = null;
        List<JavaWord> list = null; // 조회되는 결과를 리턴받아 참조할 변수
        switch (System.console().readLine()) { // 키보드 입력을 받아 변수에 저장하지 않고 직접 switcth에 작성
            case "1":
                System.out.println("검색한 단어를 영문으로 입력하세요. _");
                int level  = Integer.parseInt(System.console().readLine());
                list = searchAllWord(level);
                break;
            case "2":
                System.out.println("검색할 레벨을 입력하세요. _");
            default:
                System.out.println("1,2 만 입력하시오");
                break;
        }
        System.out.println("\t::검색 결과 입니다::");
        if (list.size() == 0)
            System.out.println("찾는 단어가 단어장에 없습니다");
        else
            printWordList(list);
    }
    // 새로운 검색 메소드
    // 1. 단어 검색: 첫 번째로 일치하는 결과만 리턴
    // 메소드의 인자를 입력 데이터로 하여 메소드의 코드가 실행되고 결과는 출력으로 리턴
    private JavaWord searchFiWord(String english) {
        for (JavaWord word : words) {
            if (word.getEnglish().equals(english)) {
                return word; // 인자로 전달된 english 와 같은 word 리턴
            }
        }
        return null; // 찾는 english단어 없으면 for문이 리스트 모두 반복하고 종료.nullㄹ턴
    }

    // 2. 단어 검색 : 검색하는 단어와 일치하는 결과 모두 리턴(단어가 2번이상 중복 저장일 떄)
    private List<JavaWord> searchAllWord(String english) {
        List<JavaWord> list = new ArrayList<>(); // 검색결과를 지정할 리스티
        for (JavaWord word : words) {
            if (word.getEnglish().equals(english)) {
                list.add(word); // 일치하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    private List<JavaWord> searchAllWord(int level){
        List<JavaWord> list = new ArrayList<>(); // 검색결과를 지정할 리스티
        for (JavaWord word : words) {
            if (word.getLevel()==level) {
                list.add(word); // 일치하는 단어를 만날 때마다 저장
            }
        }
        return list;
    
    }

    // 단어 삭제 : 단어장에 동일한 단어 2번이상 있는 경우
    // 삭제하기 전에 if문으로 사용자 확인을 함
    private void removeWord() {
        System.out.println("\t:: 단어 삭제 합니다.::");
        System.out.print("삭제할 단어를 영문으로 검색하세요. _");
        String toRemove = System.console().readLine();
        int indexToRemove = -1; // 삭제할 단어의 인덱스 초기화 false 상태로 시작

        for (int i = 0; i < words.size(); i++) {
            JavaWord word = words.get(i);
            if (word.getEnglish().equals(toRemove)) {     
                System.out.println(
                        "삭제할 단어 : " + word.getEnglish() + " = " + word.getKorean() + ". 레벨 : " + word.getLevel());
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
        if (indexToRemove != -1) { // 인덱스가 들어가 있다면
            words.remove(indexToRemove); // 삭제할 단어의 인덱스를 사용하여 리스트에서 삭제
            System.out.println("단어가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 단어를 찾을 수 없습니다.");
        }
    }

    // private void removeWord() {
    //     System.out.println("\t:: 단어 삭제 합니다.::");
    //     System.out.print("삭제할 단어를 영문으로 검색하세요. _");
    //     String find = System.console().readLine();
    //     boolean isFind= false;
    //     for(int i =0; i<words.size();i++){
    //         if(words.get(i).getEnglish().equals(find))
    //     }


    
    

    private void initialize() {
        // words 리스트 요소를 몇개만 저장해서 초기화
        words.add(new JavaWord("public", "공용의", 1));
        words.add(new JavaWord("public", "공용의", 2));
        words.add(new JavaWord("public", "공용의", 3));
        words.add(new JavaWord("private", "사적인", 1));
        words.add(new JavaWord("iterator", "반복하다", 3));
        words.add(new JavaWord("applicarion", "응용프로그램", 2));
    }

    private void seatchWord() {
        System.out.println("\t:: 단어 검색 합니다.::");
        System.out.print("검색할 단어를 영문으로 검색하세요. _");
        String find = System.console().readLine();
        // 2. 단어 여러개 리턴
        List<JavaWord> result = searchAllWord(find);
        if (result.size() == 0)
            System.out.println("찾는 단어가 없음");
        else
            System.out.println("result : " + result);

        // // 1. 단어 1개 리턴
        // JavaWord word = searchFiWord(find);
        // if(word!=null)
        // System.out.println(
        // "검색결과 : " + word.getEnglish() + " = " + word.getKorean() + ". 레벨 : " +
        // word.getLevel());
        // else
        // System.out.println("찾는 단어가 없습니다");

        // */

        // if (!found) { //if문 조건검사 같은 단어가 2번이나 단어장에 있을 때

    }

    // 리스트에 동일한 단어가 2번 저장되었다면 됨 ㅇㅇ 중복 되니까, (중복 저장 방법에 따라 위와 같은 방법들로 할 수 있다 )
    // 리스트에 없는 단어를 조회했다면
    // 리스트에 없는 단어를 조회한다면 ? 같은 단어를 1번만 저장하게 할 땐 위와 같이 할 수 있다

    public static void main(String[] args) {

        // 프로그램 실행한는 객체 생성하고(메소드로 기능을 분리할 때 main이 호출하는 static을 없애기 위함)
        // start 메소드 프로그램 실행 내용을 코딩
        JavaWordApp_V2 app = new JavaWordApp_V2();
        app.start();
    }

}
