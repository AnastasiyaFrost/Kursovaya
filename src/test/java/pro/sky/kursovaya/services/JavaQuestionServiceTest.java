package pro.sky.kursovaya.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.kursovaya.Question;
import pro.sky.kursovaya.exceptions.IncorrectQuestionException;
import pro.sky.kursovaya.exceptions.QuestionIsNotFoundException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class JavaQuestionServiceTest {
    private final JavaQuestionService out = new JavaQuestionService();
    @BeforeEach
    public void beforeEach() {
out.getAll().clear();
    }

    @Test
    void addPositiveTest() {
        Question result = out.add(new Question("test","test"));
        Assertions.assertEquals(new Question("test","test"), result);
    }
    @ParameterizedTest
    @MethodSource("addNegativeParams")
    void addNegativeTest(Question question, Class<Throwable> expectedExceptionType) {
        Assertions.assertThrows(expectedExceptionType,
                () -> out.add(question));
    }
    public static Stream<Arguments> addNegativeParams() {
        return Stream.of(
                Arguments.of(new Question("","test"), IncorrectQuestionException.class),
                Arguments.of(new Question("  ","test"), IncorrectQuestionException.class),
                Arguments.of(new Question("test",""), IncorrectQuestionException.class),
                Arguments.of(new Question("test","   "), IncorrectQuestionException.class)
        );
    }

    @Test
    void removePositiveTest() {
        Question q1 = new Question("test", "test");
        Question q2 = new Question("test2", "test2");
        out.add(q1);
        out.add(q2);
        Question result = out.remove(q1);
        Assertions.assertNotNull(out);
        Assertions.assertEquals(q1, result);
        Assertions.assertFalse(out.toString().contains(q1.toString()));
    }

    @ParameterizedTest
    @MethodSource("removeNegativeParams")
    void removeNegativeTest(Question question, Class<Throwable> expectedExceptionType) {
        Assertions.assertThrows(expectedExceptionType,
                () -> out.remove(question));
    }
    public static Stream<Arguments> removeNegativeParams() {
        return Stream.of(
                Arguments.of(new Question("","test"), IncorrectQuestionException.class),
                Arguments.of(new Question("test",""), IncorrectQuestionException.class),
                Arguments.of(new Question("test3","test3"), QuestionIsNotFoundException.class)
        );
    }

    @Test
    void getAll() {
        Assertions.assertTrue(out.getAll().isEmpty());
        Question q1 = new Question("test", "test");
        Question q2 = new Question("test2", "test2");
        out.add(q1);
        out.add(q2);
        Set<Question> expected = new HashSet<>(Set.of(new Question("test", "test"),
                new Question("test2", "test2")));
        Assertions.assertEquals(expected, out.getAll());
    }

    @Test
    void getRandomQuestionPositiveTest() {
        Question q1 = new Question("testik", "testik");
        out.add(q1);
        Question result = out.getRandomQuestion();
        Assertions.assertEquals(q1, result);
    }
    @Test
    void getRandomNegativeTest() {
        Assertions.assertThrows(QuestionIsNotFoundException.class,
                out::getRandomQuestion);
    }
}