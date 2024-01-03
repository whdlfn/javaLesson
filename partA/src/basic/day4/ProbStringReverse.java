package basic.day4;

public class ProbStringReverse {
    public static void main(String[] args) {

        String message = "Hello world"; 
        char[] messageArray = new char[message.length()];

        int cidx = message.length()-1; //10
        for(int i = 0; i<message.length(); i++){
            char temp = message.charAt(i);  //i가 0일 때 배열 10
            messageArray[cidx]=temp;  //cidx = 10
            cidx--;
        }
        System.out.println("뒤집기 결과 : ");
        System.out.println(messageArray);
        


    }
}
