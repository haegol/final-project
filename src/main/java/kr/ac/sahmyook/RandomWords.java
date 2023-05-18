package kr.ac.sahmyook;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class RandomWords {
    public String randomWord(int no){
    String rdword = null;
    ArrayList<String> arr1 = new ArrayList<>(Arrays.asList("grape", "alien", "acter", "beach", "black", "brain", "camel", "chair", "clock"));
    ArrayList<String> arr2 = new ArrayList<>(Arrays.asList("bear", "desk", "face", "game", "home", "king", "lady", "word", "skin"));
    ArrayList<String> arr3 = new ArrayList<>(Arrays.asList("cat", "dog", "got", "cap", "pen","cup","hug", "zip", "tea"));

    switch(no) {
        case 1:
            Collections.shuffle(arr1);
            rdword = arr1.get(0);
            break;
        case 2:
            Collections.shuffle(arr2);
            rdword = arr2.get(0);
            break;
        case 3:
            Collections.shuffle(arr3);
            rdword = arr3.get(0);
            break;
        default:
            break;
        }
        return rdword;
    }
}
