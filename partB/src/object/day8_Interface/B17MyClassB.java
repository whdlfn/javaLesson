package object.day8_Interface;

public class B17MyClassB {
    public static void main(String[] args) {
        MyClassB myb = new MyClassB();

    // 다중 구ㅕㅎㄴ 클래스인 MyClassB는 두 가지 업 캐스팅 가능
    InterfaceA ifa = new MyClassB();
    InterfaceX ifx = new MyClassB();

    myb.methodA();
    ifa.methodA(); //methodA는 interface의 추상 메소드
    // ifx.methodA(); //더른 인터페이스 참조타잊ㅂ으로는 메소드 실행 못함

    ifx.methodX();
    // ifa.methodX(); 오류

    InterfaceX ix =(InterfaceX) ifa;
    ix.methodX();
    }
}
