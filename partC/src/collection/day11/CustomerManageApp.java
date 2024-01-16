package collection.day11;

import java.util.ArrayList;
import java.util.List;



//1월 14일 저녁 9시
public class CustomerManageApp {
    private List<Customer> apps = new ArrayList<>();
    private void start() {
        initialize();
        // 메뉴 선택 : 등록, 검색2가지(이름/그룹), 삭제, 수정, 전체 출력
        while (true) {
            System.out.println("\t 메뉴 선택 >> ");
            System.out.println("\t 1. 고객 등록");
            System.out.println("\t 2. 고객정보 전체 조회");
            System.out.println("\t 3. 고객 삭제");   
            System.out.println("\t 4. 고객 검색");
            System.out.println("\t 5. 고객 정보 수정");
            System.out.println("\t 6. 프로그램 종료");
            System.out.print("선택 >> "); // 메소드에 입력 가능이 있으면 Scanner 관리가 불편
            int select = Integer.parseInt(System.console().readLine()); // 키보드 입력. parseInt : 문자열-> 정수로

            // System.console() : 시스템의 콘솔(표준입출력 장치) 객체를 리턴 : redLIne 입력 메소드 실행
            switch (select) {
                case 1:
                    addWord(); // 사용자 등록
                    break;

                case 2:
                    lisetWord(); // 
                    break;

                case 3:
                    removeWord(); // 사용자 삭제
                    break;

                case 4:
                    searchWordby(); 
                    break;

                case 5:
                    modify(); // 사용자 삭제
                    break;

                case 6:
                    addWord(); // main종료
                    System.out.println("프로그램 종료");
                    System.exit(0);
                    break;

                default:
                    System.out.println("잘못된 선택");
           }// switch
        } // while end
    }// start end


    // 1. 고객 등록
    private void addWord() {
        System.out.println("\t::고객 등록.::");
        System.out.println("고객 이름을 영어로 입력하세요. _");
        String name = System.console().readLine();
        System.out.println("전화번호를 입력하시오. _");
        String phone = System.console().readLine();
        System.out.println("그룹을 입력하시오. (1:일반, 2:vip, 3:기타) _");
        int group = Integer.parseInt(System.console().readLine());

        apps.add(new Customer(name, phone, group));
    }



    // 2. 고객 정보 전체 출력
    private void lisetWord() {
        System.out.println(String.format("%-20s %-20s\t  %-20s", "NAME", "PHONE", "GROUP"));

        printWordList(apps); // 출력할 리스트 apps 메소드에 전달
    }
    private void printWordList(List<Customer> list) {
        for (Customer word : list) {
            System.out.println(
                    String.format("%-20s %-20s\t %-20s", word.getName(), word.getPhone(), word.getGroup()));

        }
    }



    // 3. 고객 정보 삭제
    private void removeWord() {
        System.out.println("\t:: 고객 정보를 삭제 합니다.::");
        System.out.print("삭제할 이름을 영문으로 검색하세요. _");
        String toRemove = System.console().readLine();
        int indexToRemove = -1; // 삭제할 단어의 인덱스 초기화 false 상태로 시작

        for (int i = 0; i < apps.size(); i++) {
            Customer app = apps.get(i);
            if (app.getName().equals(toRemove)) {
                System.out.println(
                        "사용자 : " + app.getName() + ", 전화번호 :  " + app.getPhone() + ", 그룹 : " + app.getGroup());
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
            apps.remove(indexToRemove); // 삭제할 단어의 인덱스를 사용하여 리스트에서 삭제
            System.out.println("단어가 삭제되었습니다.");
        } else {
            System.out.println("삭제할 단어를 찾을 수 없습니다.");
        }
    }

    // 4. 고객 검색
    private void searchWordby() {
        System.out.println("\t::고객을 검색합니다.(이름 검색 : 1, 그룹 검색 : 2 ):::");
        List<Customer> list = null; // 조회되는 결과를 리턴받아 참조할 변수
        switch (System.console().readLine()) { // 키보드 입력을 받아 변수에 저장하지 않고 직접 switcth에 작성
            case "1":
                System.out.println("검색할 이름을 입력하세요. _");
                String name  = System.console().readLine();
                list = searchAllWord(name);
                break;
            case "2":
                System.out.println("검색할 그룹을 입력하세요. _");
                int group  = Integer.parseInt(System.console().readLine());
                list = searchAllWord(group);
            default:
                System.out.println("1,2 만 입력하시오");
                break;
        }
        System.out.println("\t::검색 결과 입니다::");
        if (list.size() == 0)
            System.out.println("찾는 계정이 없습니다");
        else
            printWordList(list);
    }

    // 이름으로 검색
    private List<Customer> searchAllWord(String name) {
        List<Customer> list = new ArrayList<>(); // 검색결과를 담을 빈 리스트
        for (Customer app : apps) {
            if (app.getName().equals(name)) {
                list.add(app); // 일치하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }

    // 그룹으로 검색
    private List<Customer> searchAllWord(int group){
        List<Customer> list = new ArrayList<>(); // 검색결과를 지정할 리스트
        for (Customer app : apps) {
            if (app.getGroup()==group) {
                list.add(app); // 일치하는 단어를 만날 때마다 저장
            }
        }
        return list;
    }


    // 고객 정보 수정 
    private void modify() {
        System.out.println("\t:: 사용자 정보 수정합니다.::");
        System.out.print("수정할 사용자 이름을 입력하세요. _");
        String toModify = System.console().readLine();
    
        int indexToModify = findCustomerIndex(toModify);
    
        if (indexToModify != -1) {
            Customer customer = apps.get(indexToModify);
            System.out.println("수정 전 정보 : " + customer);
            System.out.println("수정할 정보를 선택하세요:");
            System.out.println("1. 전화번호 수정");
            System.out.println("2. 사용자 그룹 수정");
            System.out.print("선택 (엔터를 입력하면 취소됩니다.) >> ");
            String input = System.console().readLine();
    
            if (!input.isEmpty()) {   //비어져있지 않다면
                int modifyOption = Integer.parseInt(input);
    
                switch (modifyOption) {
                    case 1:
                        System.out.print("새로운 전화번호를 입력하세요. _");
                        String newPhone = System.console().readLine();
                        customer.modify(newPhone, customer.getGroup());
                        System.out.println("전화번호가 수정되었습니다.");
                        break;
                    case 2:
                        System.out.print("새로운 사용자 그룹을 입력하세요. (1:일반, 2:vip, 3:기타) _");
                        int newGroup = Integer.parseInt(System.console().readLine());
                        customer.modify(customer.getPhone(), newGroup);
                        System.out.println("사용자 그룹이 수정되었습니다.");
                        break;
                    default:
                        System.out.println("올바른 선택이 아닙니다. 수정이 취소됩니다.");
                        break;
                }
            } else {
                System.out.println("수정이 취소되었습니다.");
            }
        } else {
            System.out.println("수정할 사용자를 찾을 수 없습니다.");
        }
    }

    private int findCustomerIndex(String name) {
    for (int i = 0; i < apps.size(); i++) {
        Customer customer = apps.get(i);
        if (customer.getName().equals(name)) {
            return i; // 사용자를 찾으면 인덱스 반환
        }
    }
    return -1; // 사용자를 찾지 못하면 -1 반환
}


    private void initialize() {
        apps.add(new Customer("momo", "010-1234-5678", 1));
        apps.add(new Customer("dahy", "010-9876-5432", 2));
        apps.add(new Customer("nana", "010-0000-0000", 3));
        apps.add(new Customer("gang", "010-1111-2222", 1));
    }


    
    
    






    








    



    





    //main
    public static void main(String[] args) {
        CustomerManageApp app = new CustomerManageApp();
        app.start();
    }
    
}
