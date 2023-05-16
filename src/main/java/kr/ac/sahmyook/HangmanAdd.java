package kr.ac.sahmyook;

import java.io.IOException;
import java.util.Scanner;

public class HangmanAdd {
    public void gameStart(int n) throws IOException {
        String[] hangman = {"머리", "몸통", "왼팔", "오른팔", "왼다리", "오른다리", "왼쪽 눈", "오른쪽 눈", "코", "입"};
        Scanner sc = new Scanner(System.in);
        RandomWords rdw = new RandomWords();
        String answer = (String) rdw.randomWord(n); // randomWord에서 정답 단어 추출
        char[] answerArr = answer.toCharArray(); //정답 단어의 각 알파벳 배열
        char[] blank = new char[answerArr.length]; //정답 단어길이만큼의 빈칸 배열
        for (int i = 0; i < answerArr.length; i++) {
            blank[i] = '_';
        }

        int count = 0;
        int fail = 0;
        do {

            if (answer.equals(String.valueOf(blank))) {
                System.out.println("축하드립니다. 정답을 맞추셨습니다!");
                break;
            }
            //빈칸(_) 출력
            System.out.println();
            System.out.println("빈 칸에 들어갈 알파벳을 예측해서 입력해주세요 : ");
            for (int i = 0; i < answerArr.length; i++) {
                System.out.print(blank[i] + " ");
            }
            //유저의 정답 입력받기(ua)
            String userAnswer = sc.nextLine();
            int uaType = userAnswer.length();
            if (uaType == 1) {
                boolean correct = false;

                for (int i = 0; i < answerArr.length; i++) {
                    if (answerArr[i] == userAnswer.charAt(0)) {
                        System.out.println("=================================");
                        System.out.println("정답 단어에 존재하는 알파벳입니다.");
                        blank[i] = userAnswer.charAt(0);
                        correct = true;
                    }
                }
                if (correct == false) {
                    fail++;
                    System.out.println("=================================");
                    System.out.println("정답 단어에 존재하지 않는 알파벳입니다." + hangman[fail - 1] + " 이(가) 생겼습니다. (기회 : " + (10 - fail) + "번)");
                }

            }
            else {
                if (answer.equals(userAnswer)) {
                    System.out.println("축하드립니다. 정답을 맞추셨습니다!");
                    break;
                } else {
                    fail++;
                    System.out.println("정답이 아닙니다.");
                    System.out.println(hangman[fail - 1] + "이(가) 생겼습니다.(기회 : " + (10 - fail) + "번)");
                }
            }

        }while (true) ;
    }
}
