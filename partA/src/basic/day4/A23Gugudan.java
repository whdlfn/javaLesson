package basic.day4;

public class A23Gugudan {
    public static void main(String[] args) {
    
        // 구구단은 이중 for문사용
        for(int i =2; i<10; i++){
            for(int j =1; j<10; j++){
                System.out.println(String.format("%3d +%3d =%3d", i,j,(i*j)));
            }
        }
    }
}
