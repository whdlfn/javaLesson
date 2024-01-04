package object.day5;

public class B03ScoreMain {
    public static void main(String[] args) {
        // 학생 4명의 성적을 저장
        // 1학년 2명(모모 다현) 2과목 2학년 2명(나연 쯔위) 4과목
        // 점수는 내 맴

        Score mo = new Score();
        Score da = new Score();
        Score na = new Score();
        Score zz = new Score();

        mo.setName("모모");
        da.setName("다현");
        na.setName("나연");
        zz.setName("쯔위");

        mo.setGrade(1);
        da.setGrade(1);
        na.setGrade(2);
        zz.setGrade(2);

        int[] motemp = { 89, 90, 78 };
        mo.setJumsues(motemp);
        int[] datemp = { 44, 96, 74 };
        da.setJumsues(datemp);
        int[] natemp = { 86, 23, 72, 78 };
        na.setJumsues(natemp);
        int[] zztemp = { 81, 66, 34, 99 };
        zz.setJumsues(zztemp);

        mo.printScore();
        da.printScore();
        na.printScore();
        zz.printScore();

    }
}
