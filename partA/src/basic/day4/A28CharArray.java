package basic.day4;

// 문자열은 문자의 집합 따라서 문자열 구성하는 문자 하나씩 가져와 배열에 저장
public class A28CharArray {
    public static void main(String[] args) {
        String message = "Hello 이루";

        // 문자열의 길이 만큼 배열의 크기 정함
        char[] messageArray = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            System.out.println(temp);
            messageArray[i] = temp;
        }
        // char배열의 특징 배열이름으로 println하면 문자열처럼 출력됨ㄷ
        System.out.println(messageArray);

        // 고대암호 : 모모가 나연이한테 비밀메세지를 보내서 암호문을 만듦
        // 두사람이 알고 있는 비밀 키 값 key =7 을 정함 -> 암호문은
        int key = 7;
        for (int i = 0; i < message.length(); i++) {
            messageArray[i] += key;
        }
        System.out.println("모모가 나연이한테 보낸비밀 메세지 :");
        System.out.println(messageArray);

        System.out.println("암호 풀기");
        for (int i = 0; i < message.length(); i++) {
            messageArray[i] -= key;
        }
        System.out.println(messageArray);
    }
}
