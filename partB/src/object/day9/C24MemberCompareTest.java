package object.day9;

import java.util.Arrays;

public class C24MemberCompareTest {
    // menber 객체를 비교하고 배열 정렬도 할 수 있다
    public static void main(String[] args) {
        Member momo = new Member("momo", 23);
        Member nana = new Member("nana", 20);

        System.out.println("모모 나연 비교 (나이)");
        System.out.println("\t" + momo.compareTo(nana) + "양수이면 모모가 나연보다 나이가 많다");

        Member dahy = new Member("dahyeon", 32);
        Member sana = new Member("sana", 23);

        Member[] members = new Member[4];
        members[0] = momo;
        members[1] = nana;
        members[2] = dahy;
        members[3] = sana;

        System.out.println("초기 menbers 배열 : " + Arrays.toString(members));
        Arrays.sort(members); // 배열요소 멤버 객체가 compareTo 메소드가 있어서 정렬 가능
        System.out.println("수정 후 menbers 배열 : " + Arrays.toString(members));
    }
}
