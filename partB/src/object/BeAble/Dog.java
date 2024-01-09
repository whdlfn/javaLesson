package object.BeAble;

public class Dog implements Runnable{
    @Override
    public String beAble() {
        return "달리기";
    }
    @Override
    public String run(int speed) {
        return "강아띠는 "+speed+"km/h로 달립니다\n최대속도 55km/h...";
    }
}
