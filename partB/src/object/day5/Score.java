package object.day5;

import java.util.Arrays;

// 학생성적
public class Score {
    // 인스턴스 필드
    private String name;
    private int grade;
    private int[] jumsues; // 점수들이 저장된 배열
                           // 배열의 크기는 학년마다 다를 수 있음ㄴ

    // 인스턴스 메소드 : 인스턴스 필드를 사용하는 처리를 함
    // get

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public int[] getJumsues() {
        return jumsues;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setJumsues(int[] jumsues) {
        this.jumsues = jumsues;
    }

    // 점수의 합계를 리턴하는 sum 메소드

    public int sum() {
        int sum = 0;
        for (int i = 0; i < jumsues.length; i++) {
            sum += jumsues[i];
        }
        return sum;
    }

    // 점수의 평균을 double로 리턴 average() 메소드

    public double average() {
        return (double)sum() / jumsues.length;
    }

    // 모든 인스턴스 값을 확인하는 printScore 메소드
    public void printScore() {
        System.out.println("학생의 이름 : " + name + ", 학생의 학년 : " + grade + ", 학생의 점수 : " + Arrays.toString(jumsues)
                + ", 학생 점수의 합계는 : " + sum() + ", 점수의 평균 : " + average());
    }

}
