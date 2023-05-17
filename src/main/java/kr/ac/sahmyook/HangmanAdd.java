package kr.ac.sahmyook;

import java.util.Scanner;

public class HangmanAdd {
    public void gameStart(int n) {
        String[] hangman = {"머리", "몸통", "왼팔", "오른팔", "왼다리", "오른다리", "왼쪽 눈", "오른쪽 눈", "코", "입"};
        Scanner sc = new Scanner(System.in);
        RandomWords rdw = new RandomWords();                                              //RandomWord 선언 (정답용 랜덤 영단어 클래스)
        Score score = new Score();                                                        //Score 선언 (점수계산 클래스)
        String answer = (String) rdw.randomWord(n);                                       //정답 단어 추출
        char[] answerArr = answer.toCharArray();                                          //정답 단어의 각 알파벳 배열
        char[] blank = new char[answerArr.length];                                        //정답 단어 길이만큼의 빈칸 배열
        for (int i = 0; i < answerArr.length; i++) {
            blank[i] = '_';
        }

        int fail = 0;    //틀린횟수

        do {
            /* 정답단어와 완성된 단어가 일치할 때 (game clear) */
            if (answer.equals(String.valueOf(blank))) {
                System.out.println("축하드립니다. 정답을 맞추셨습니다!");
                System.out.println("=================================");
                Score.count(fail);                                                        //점수계산
                System.out.println("GAME CLEAR");
                break;
            }

            /* 글자 수 만큼 (_) 출력 */
            System.out.println();
            System.out.println("빈 칸에 들어갈 알파벳을 예측해서 입력해주세요 : ");
            for (int i = 0; i < answerArr.length; i++) {
                System.out.print(blank[i] + " ");
            }
            /* 유저의 답변 입력받기 */
            String userAnswer = sc.nextLine();
            int uaType = userAnswer.length();
            //유저가 알파벳을 입력했을 떄
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
                    if((10-fail) == 0){
                        System.out.println("행맨이 완성되었습니다. GAME OVER");
                        break;
                    }
                }

            }
            //유저가 단어를 입력했을 때
            else {
                if (answer.equals(userAnswer)) {
                    System.out.println("축하드립니다. 정답을 맞추셨습니다!");
                    System.out.println("=================================");
                    Score.count(fail);
                    System.out.println("GAME CLEAR");
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
