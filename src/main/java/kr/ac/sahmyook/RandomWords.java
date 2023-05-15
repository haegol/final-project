package kr.ac.sahmyook;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class RandomWords {
    public Object randomWord(int no){
    String rdword = null;
    ArrayList<String> arr1 = new ArrayList<String>(Arrays.asList("apple", "alien", "acter", "beach", "black", "brain", "camel", "chair", "clock"));
    ArrayList<String> arr2 = new ArrayList<String>(Arrays.asList("bear", "desk", "face", "game", "home", "king", "lady", "word", "skin"));
    ArrayList<String> arr3 = new ArrayList<String>(Arrays.asList("cat", "dog", "got", "cap", "pen","cup","hug", "zip", "tea"));


    switch(no) {
        case 3:
            Collections.shuffle(arr1);
            rdword = arr1.get(0);
            break;
        case 4:
            Collections.shuffle(arr2);
            rdword = arr2.get(0);
            break;
        case 5:
            Collections.shuffle(arr3);
            rdword = arr3.get(0);
            break;
        default:
            break;
        }
        return rdword;
    }
}
