package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizMapTest {

    String path = "src/test/resources/result.txt";

    QuizMap quizMap = new QuizMap(path);

    @Test
    void isRightAnswer() {
        assertTrue(quizMap.isRightAnswer("BD452", 4));
        assertFalse(quizMap.isRightAnswer("AB123", 2));
    }

    @Test
    void getWinner() {
        assertEquals("GH1234", quizMap.getWinner());
    }
}