package basic.day2;

public class A11StringMethod {
    
    public static void main(String[] args) {

        // 메소드는 메소드 이름 뒤에 괄호가 있음
        // 그리고 괄호안의 값들은 (?) 메소드 처리에 필요한 입력 데이터이다 -> "메소드의 인자"
        // 메소드가 처리한 결과는 출력 데이터 -> "메소드의 리턴(반환) 값"

        //메소드 인자의개수와 형식에 따라 분류
        String message = "Hello World";
        //1. 메소드 괄호안에 아무것도 없는 것  :length, isEmpthy, toUppercase, toLowerCase
        System.out.println("message.length() : " +message.length() );
        System.out.println("message.toUpperCase() : " + message.toUpperCase());
        System.out.println("message.isEmpty() : " + message.isEmpty());

        // 2. 메소드 괄호안에 정수 1개를 쓰는 것 : chatAt, split
        // 문자열은 0부터. 현재 message에서 마지막 인덱스는 length - 1임 
        System.out.println("message.charAt(4) : "+ message.charAt(4));

        // 3. 메소드 괄호안에 문자열 1개를 쓰는 것 : concat, equals, startsWith, endsWith, indexOf
        System.out.println("message.concat(\"이루\") : " + message.concat("이루"));

        // 대소문자 구분하면서 Hello로 시작하는지 구분하는 메소드
        System.out.println("message.startsWith : "+message.startsWith("hello"));
        System.out.println("message.startsWith : "+ message.startsWith("Hello"));
        System.out.println("message.endsWith : "+message.endsWith("d"));
        //문자열안에서 원하는 단어의 위피를 찾기 -> 시작위치 index 값을 리턴, 단어가 없으면 -1 리턴
        System.out.println("message.indexOf : "+message.indexOf("World"));

        //4. 메소드 괄호안에 정수 2개를 쓰는 : substring (문자열 부분 추출 시작인덱스, 마지막인덱스 값을 인자로 주기)
        System.out.println(message.substring(0, 2)); //He
        // 추출할 때 마지막 인덱스는 포함 안 함. 결국 추출하는 문자개수는 endIndx - beginIndex 공식이 성립

        message = "hello";
        System.out.println(""+message.equals("Hello"));
        System.out.println(""+message.equals("hello"));

        // 5. 메소드 괄호안에 문자 또는 문자열 2개를 쓰는 것 : replace(문자열 바꾸기)
        System.out.println(message.replace("ll", "2222"));

        //메소드의 리턴타입에 따라 결과를 저장할 변수를 일치하는 형식으로 선언하기
        //문자열 리턴값으로 또 메소드 살행할 수 있음
        // ex) String temp = message.toUpperCase().substring(0, 2));

        // ***리턴값 형식을 기분으로 정리하기***
        // boolean : isEmpty(), startsWith(), endsWith(), equals()
        // String : toUpperCase(), toLowerCase(), concat(), replace(), substring()
        // int : length(), indexOF
        // char : charAt(), 
    }
}
