package basic.day5;

import java.lang.reflect.Array;
import java.util.Arrays;

// 데이터의 참조값과 관련된 테스트
public class A25ArrayVarTest {
    public static void main(String[] args) {
        
        // iArray, cArray, dArray 은 모든 배열의 참조값을 저장하는 변수
        int[] iArray = { 1, 2, 3, 4, 5 };
        double[] dArray = new double[5];
        char[] cArray = new char[5];
        cArray[0] = 'j';
        cArray[1] = 'a';
        cArray[2] = 'v';    
        cArray[3] = 'a';
        cArray[4] = '!';
      
        System.out.print("1.  ");
        System.out.println(iArray);  //배열의 시작 주소
        System.out.print("2.  ");
        System.out.println(dArray); //배열의 시작 주소
        System.out.print("3.  ");
        System.out.println(cArray); //char의 배열은 문자열로 변환돼서 출력
        
        
        int[] temp;
        temp = iArray;
        System.out.print("4.  ");
        System.out.println(temp);
        // 4번은 iArray 배열의 참조값(주소,식별값)을 전달받았으므로 temp 가 가리키는 것은 iArray와 동일한 배열


        // 참조값을 전달하면 이렇게 된다
        System.out.println("\n참조값을 전달받은 temp배열");
        temp[3] = 999;
        System.out.println(temp[3]);
        System.out.println("temp 배열의 값 : "+Arrays.toString((temp)));
        System.out.println("\n6. 어라?? iArray도 똑같네");
        System.out.println(iArray[3]);
        System.out.println("temp 배열의 값 : "+Arrays.toString((iArray)));
        
        // 다른 인덱스으ㅢ 값
        iArray[1] =2333;
        System.out.println("\n7. temp와 iArray는 하나의 배열을 가리킨다");
        System.out.println("temp 배열의 값 : " +Arrays.toString(temp));


    }
}
