package pro.sky.kursovaya.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.kursovaya.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceImpl;

    private Set<Question> testedSet = new HashSet<>(Set.of(new Question("test1", "test1"),
            new Question("test2", "test2"),
            new Question("test3", "test3")));

    @BeforeEach
    public void beforeEach() {
        when(javaQuestionService.getAll()).thenReturn(testedSet);
    }

    @Test
    void getQuestionsPositive() {
        int amount = 3;
        Set<Question> result = examinerServiceImpl.getQuestions(amount);
        Assertions.assertEquals(result, Set.of(new Question("test1", "test1"),
                new Question("test2", "test2"),
                new Question("test3", "test3")));
    }
}