package object.day5;

import java.util.Arrays;

// 메인이 없는 클래스 -단순히 데이터를 저장하거나 
//          다른 클래스에서 호출하는 메소드를 정의하는 용도
public class MyClass2 {

    // 인스턴스 필드 - 객체를 생성해서 사용
    // private  키워드 : 현재 클래스 외에 다른 클래스 사용 못 함
    private String field1;
    private int field2;
    private double[] field3;  //참조값

    // static 필드 - 클래스 이름으로 사용
    private static int field5;
    private static final int FIELD4 =999;

    //private 필드값을 가져오는 메소드 :gerter
    public String getField1() {
        return field1;
    }

    public int getField2 () {
        return field2;
    }

    // 모든 인스턴스 필드 값을 출력해주는 메소드 
    public void printDate(){
        System.out.println("field1 = "+ field1 + ",field2 = "+field2 +
        ",field2 = "+ field3+ Arrays.toString(field3));
    }

    public double[] getField3() {
        return field3;  //배열의 참조값을 리턴 
        // 객체가 의도하지 않아도 쉽게 field 배열값이 변경됨
        
    }

    // private 변수(필드)를 다른 클래스에서 값을 읽고 또는 저장하기 -> gerter, setter
    // 필드값을 저장하는 메소드
    public void setField1(String f1){
        field1 = f1;
    }

    public void setField2 (int f2) {
        field2 = f2;
    }

    public void setField3 (double[] f3){
        field3 = new double[f3.length];
        for(int i =0; i<f3.length; i++){
            field3[i] =f3[i];
        }
    }
}
