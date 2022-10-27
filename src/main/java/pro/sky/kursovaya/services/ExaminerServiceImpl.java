package pro.sky.kursovaya.services;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya.interfaces.ExaminerService;
import pro.sky.kursovaya.Question;
import pro.sky.kursovaya.interfaces.QuestionService;

import java.util.Collection;
import java.util.Random;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
