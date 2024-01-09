package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class B04CharMainMy {
    public static void main(String[] args) {
        
        CartMy iru_cart = new CartMy();     //String =, String[] int[] 필드는 null

        String[] products = {"새우깡", "사이다", "요거트"};
        int[] prices = {3000,15000,7500};

        iru_cart.setUserid("iru");
        iru_cart.setProducNames(products);
        iru_cart.setPrices(prices);
       
        Scanner sc = new Scanner(System.in);

        System.out.println(iru_cart.getUserid()+"님의 장바구니 입니다");
        System.out.println(String.format("%s\t %s\t %s", "번호","상품명","가격"));
        
        for(int i =0; i<iru_cart.getProducNames().length; i++){
            System.out.println(String.format("%d\t %s\t %s2", i ,products[i],products[i]));
        }
        System.out.println("구매할 상품 번호를 선택하시오. 선택 종료는 -1입니다");

        int sel =0;
        int[] select = new int[5];  //상품 선택 개수는 최대 5개
        int k =0;  //select 배열 인덱스
        while (sel != -1 ) {
            System.out.print("상품번호 입력 >>");
            sel= sc.nextInt();
            // sel의 선택법위는 porductNames 인덱스 범위값만
            if(sel<-1 || sel > products.length-1){
                System.out.println("없는 상품입니다");
                continue;
            }
            select[k++] = sel; //대입 후 증가
        }

        if(k==select.length){
            System.out.println("장바구니를 가득 채움");
        }
        System.out.println("선택하신 상품은 "+ Arrays.toString(select));
        // System.out.println(iru_cart.getUserid()+"님이 선택하신 상품 합계 : "+ iru_cart.total_Money(select));

        // iru_cart.setTotal_Money(200000); setter 메소드가 여기서는 필요없음
                                            //total 메소드가 대신 값을 계산해서 저장할 것임


        iru_cart.total_Money(select);
        System.out.println(iru_cart.getUserid()+"님이 선택하신 상품 합계 : "+iru_cart.getTotal_Money());

        // 필요에 따라서는 기존의 setter 메소드는 사용하지 않고
        //  추가적인 비지니스로직으로 구현하는 메소드를 만듦 -> total_Money() 메소드

    }
}
