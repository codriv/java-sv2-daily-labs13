package day04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FindLetterTest {

    @Test
    void findLetters() {
        FindLetter findLetter = new FindLetter();
        System.out.println(findLetter.findLetters("fgejutzu"));
        Map<Character, Integer> testMap = new HashMap<>();
        testMap.put('e', 1);
        testMap.put('u', 2);
        assertEquals(testMap, findLetter.findLetters("fgejutzu"));
    }
}