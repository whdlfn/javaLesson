package object.day8;

//추상클래스 테스트
public class B15abstractTest {
    public static void main(String[] args) {
        
        // Animal an = new Animal(); 
        //new 개체생성 못함
        // 이유 : 추상클래스

        //Anoymous(익명) inner(내부클래스) type : 클래스 이름이 없는 내부 클래스 형식
        Animal animal = new Animal() {   //강요된 추상메소드를 재정의 하면서 내부 클래스를 정리(일회용)
            @Override
            public void sound() {
                System.out.println("익명으로 만들어진 동물클래스 : 소리는모름");
            }
        };


        animal.sound();
        System.out.println("animal toString"+animal);

        Puppy puppy = new Puppy("강아띠","검정");
        puppy.sound();
        System.out.println("puppy toString"+puppy);
        
        Rabbit rabbit = new Rabbit("토끼","흰");
        rabbit.sound();
        System.out.println("rabbit toString"+rabbit);
        
        
        Cat cat = new Cat("괭이","노랑");
        cat.sound();
        System.out.println("cat toString"+cat);

    }
}
