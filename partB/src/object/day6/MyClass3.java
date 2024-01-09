package object.day6;

public class MyClass3 {

    // 인스턴스 필드 : 클래스 내부에서 사용가능한 전역변수 
    private String field1;
    private int field2;
    private double[] field3;

    // get
    public String getField1() {
        return this.field1;
        // this는 현재 자신 객체를 나타내는 변수 -> get에서는 생력하고 쓸 수 있음
    }
    public int getField2() {
        return this.field2;
    }
    public double[] getField3() {
        return this.field3;
    }

    // set
    public void setField1(String field1) { //인자로 쓰은 매개변수 : setfield1 메소드의 지역변수
        this.field1 = field1;       //현재객체의 field1 값에 인자 field1 대입하게  (의미상 동일하게)
    }
    public void setField2(int field2) {
        this.field2 = field2;
    }
    public void setField3(double[] field3) {
        this.field3 = field3;
    }



}
