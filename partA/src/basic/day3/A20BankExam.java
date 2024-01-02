package basic.day3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A20BankExam {
    public static void main(String[] args) {
        
        int menu =0;
        int money =0; //입금액, 출금액
        int balance = 0; //잔액
        boolean run = true;
        Scanner sc = new Scanner(System.in);

        DecimalFormat df = new DecimalFormat("#,###");
        
        while (run) {
            System.out.println("-----------------------------------------");
			System.out.println("1:예금 |  2:출금 |  3.잔액  |  4.종료");
            System.out.println("-----------------------------------------");
			System.out.println("메뉴 선택 >>>> ");
            menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        System.out.println("예금액 >>> ");
                        balance = sc.nextInt();
                        System.out.println("고객님의 잔액은 "+ df.format(balance)+"원 입니다.");
                        break;
                    case 2:
                        System.out.println("출금액 >>> ");
                        money = sc.nextInt();
                        balance -= money;
                        if(balance<money) {
                            System.out.println("잔액이 부족합니다");
                            break;
                        } 
                        System.out.println("고객님의 잔액은 "+ df.format(balance)+"원 입니다.");
                        break;
                    case 3:
                        System.out.println("고객님의 잔액은 "+ df.format(balance)+"원 입니다.");
                        break;
                    case 4:
                    System.out.println("프로그램을 종료하겠습니다");
                        run = false;
                        break;
                
                    default:
                        System.out.println("잘못 입력하셨습니다");
                        break;
                } //switch 끝
        } //while 끝
    }
}
