package org.example;

import java.util.Arrays;

public class Anagram {
    public Boolean compareWord(String firstWord, String secondWord){

        char[] firstWordCompare = firstWord.toLowerCase().toCharArray();
        char[] secondWordCompare = secondWord.toLowerCase().toCharArray();

        if(Arrays.equals(firstWordCompare, secondWordCompare)) return false;

        Arrays.sort(firstWordCompare);
        Arrays.sort(secondWordCompare);

        return Arrays.equals(firstWordCompare, secondWordCompare);
    }

}
