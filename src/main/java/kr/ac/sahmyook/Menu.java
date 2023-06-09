package kr.ac.sahmyook;

import java.util.Scanner;

public class Menu {
    public static void mainMenu(){

            System.out.println("행맨 게임에 오신것을 환영합니다.");
            System.out.println("난이도를 선택 해주세요");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. 난이도 상\n" +
                    "2. 난이도 중\n" +
                    "3. 난이도 하\n" +
                    "4. 게임 종료\n" +
                    "메뉴 선택 :  ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    difficultyHigh();
                    break;
                case 2:
                    difficultyMiddle();
                    break;
                case 3:
                    difficultyLow();
                    return;
                case 4:
                    System.out.println("정말로 종료 하시겠습니까? (예:y 아니오:n) :");
                    String exit = sc.next();
                    if (exit.equals("y")) {
                        System.exit(0);
                    } else mainMenu();
                    break;
                default:
                    if (no > 4 || no < 1) {
                        mainMenu();
                    }
             }

        }


    public static void difficultyHigh(){       //난이도 상

        RandomWords rdw = new RandomWords();
        String answer = rdw.randomWord(1);
        HangmanAdd hangman = new HangmanAdd();
        hangman.gameStart(answer);
        mainMenu();
    }
    public static void difficultyMiddle(){       //난이도 중

        RandomWords rdw = new RandomWords();
        String answer = rdw.randomWord(2);
        HangmanAdd hangman = new HangmanAdd();
        hangman.gameStart(answer);
        mainMenu();
    }
    public static void difficultyLow(){       //난이도 하

        RandomWords rdw = new RandomWords();
        String answer = rdw.randomWord(3);
        HangmanAdd hangman = new HangmanAdd();
        hangman.gameStart(answer);
        mainMenu();
    }
}
