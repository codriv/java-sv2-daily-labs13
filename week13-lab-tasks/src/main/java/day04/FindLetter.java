package day04;

import java.util.HashMap;
import java.util.Map;

public class FindLetter {

    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> findLetters(String word) {
        Map<Character, Integer> vowels = new HashMap<>();
        for (Character letter: word.toCharArray()) {
            if (VOWELS.contains(letter.toString().toLowerCase())) {
                vowels.put(letter, numOfLetters(word, letter));
            }
        }
        return vowels;
    }

    private int numOfLetters(String word, Character karakter) {
        int numOfVowels = 0;
        for (Character letter: word.toCharArray()) {
            if (karakter == letter) {
                numOfVowels++;
            }
        }
        return numOfVowels;
    }
}
