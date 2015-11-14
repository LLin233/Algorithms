package Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2015/11/14.
 */
public class App {

    public static String revertString(String s){

        //String -> O(n*n) time complexity
        //StringBuilder -> O(n)
        int lengthOfText = s.length(); //O(1)
        StringBuilder revertString = new StringBuilder();
        for (int index = lengthOfText -1; index >= 0; index--) { //O(n)
            revertString.append(s.charAt(index));
        }
        return revertString.toString();
    }

    public static List<String> getSuffix(String s){
        int lengthOfText = s.length();
        List<String> suffixList = new ArrayList<>();
        for (int index = 0; index < lengthOfText; index++) {
            suffixList.add(s.substring(index, lengthOfText)); //O(1), what if we use substring under StringBuilder, this operation will have O(n) time complexity
        }
        return suffixList;
    }

    public static void main(String[] args) {
        System.out.println(revertString("Hello World!"));
        System.out.println(getSuffix("Hello"));
    }
}
