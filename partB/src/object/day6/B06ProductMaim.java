package object.day6;

public class B06ProductMaim {
    public static void main(String[] args) {

        Product snack = new Product("꼬북칩", 1000, "농심", new String[3]);
        Product drink = new Product("사이다", 1500, "롯데", new String[3]);
        Product fruit = new Product("부사", 7000, "밭", new String[3]);
        Product iceream = new Product("투게더", 5000, "빙그레", new String[3]);

        System.out.println(snack.getData());
        System.out.println(drink.getData());
        System.out.println(fruit.getData());
        System.out.println(iceream.getData());

        // snack의 etc 필드 배열요소 0번에 "10개 묶음" 문자열을 저장하세요
        String[] temp = snack.getEtc();
        temp[0] = "10개 묶음";
        System.out.println(snack.getData());

        Product[] mycarts = new Product[5]; // Product객체 배열 Product타입으로 만들어진 겍체의 참조값 저장 배열
        mycarts[0] = drink;
        mycarts[1] = snack;
        mycarts[3] = iceream;
        // mycarts[2] =;
        mycarts[4] = fruit;

        
        System.out.println("~~~~~~~~mycarts~~~~~~~~~");
        // 배열이므로 반복문으로 출력할 수 있다. getDate메소드 사용
        for (int i = 0; i < mycarts.length; i++) {
            if (mycarts[i] != null)
                System.out.println(mycarts[i].getData()); // mycarts[i]가 널일 때 -> 메모리 할당이 안된상태
        }

        /*
         * object.day6.Product@71dac704 71dac704객체 참조값(식별값) -> 주소
         * object.day6.Product@123772c4 object.day6.Product 패키지 이름.클래스이름.
         * object.day6.Product@2d363fb3
         * object.day6.Product@7d6f77cc
         */
    }
}
