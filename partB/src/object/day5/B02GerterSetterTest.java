package object.day5;

public class B02GerterSetterTest {

    public static void main(String[] args) {
    MyClass2 momo = new MyClass2();
    System.out.println("MyClass의 field1 값(초기): "+ momo.getField1()); //출력할 때 get
    momo.setField1("나는 모모"); //넣을 때 set 
    System.out.println("MyClass의 field1 값(변경 후): "+momo.getField1());
    
    System.out.println("\nMyClass의 field2 값(초기): "+ momo.getField2());
    momo.setField2(999);
    System.out.println("MyClass의 field2 값(변경 후): "+momo.getField2());
    
    
    System.out.println("\nMyClass의 field3 값(초기): "+ momo.getField3());
    double[] temp  ={23.2,4.0};
    momo.setField3(temp);
    System.out.println("MyClass의 field3 값(변경 후): "+momo.getField3());


    // setField3을 변수로 전달 했을 때 
    temp[2] =3.12345; //변경된 값이 momo 객체에도 반영되는지
    momo.printDate();
    
    }
    
    
}
