package day02;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {

    Path testPath = Path.of("src/test/resources/result.txt");

    Quiz quiz = new Quiz(testPath);

    @Test
    void isRightAnswer() {
        assertTrue(quiz.isRightAnswer("BD452", 4));
        assertFalse(quiz.isRightAnswer("AB123", 2));
    }

    @Test
    void winner() {
        assertEquals("GH1234", quiz.winner());
    }
}