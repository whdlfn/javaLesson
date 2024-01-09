package object.BeAble;

public class Human implements Thinkable, Cookable, Runnable {

    @Override
    public int calculate(int a, int b) {
        int result = 0;
        if (a >= 999999 && b >= 9999999) {
            System.out.println("사람이 못함");
            result = 9898989;
        } else {
            System.out.println("암산으로 할 수 있는 덧셈");
            result = a + b;
        }
        return result;
    }

    @Override
    public void think() {
        System.out.println("사람은 창의적으로 생각할 수 있습니다\n단 데이터가 너무 많으면 포기 함");
    }

    @Override
    public String beAble() {
        return "생각하고 요리하고 달리기도 함";
    }

    @Override
    public void cook(String material) {
        System.out.println(material + "를 사용해서 여러가지 요리를 함");
    }

    @Override
    public String run(int speed) {
        return "사람은 "+speed+"km/h로 달립니다\n최대속도 10km/h...";
    }

}
