package kr.ac.sahmyook;

public class HangmanScore {
    public static void count(int count) {


        if (count >= 10) {
            System.out.println("0점 입니다.");
        } else if (count >= 8) {
            System.out.println("60점 입니다.");
        } else if (count >= 6) {
            System.out.println("70점 입니다.");
        } else if (count >= 4) {
            System.out.println("80점 입니다.");
        } else if (count >= 2) {
            System.out.println("90점 입니다.");
        } else {
            System.out.println("100점 입니다!!!");
        }
    }
}
