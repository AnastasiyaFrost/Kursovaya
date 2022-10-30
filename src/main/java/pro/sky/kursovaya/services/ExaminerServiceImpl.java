package pro.sky.kursovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.tags.form.SelectTag;
import pro.sky.kursovaya.interfaces.ExaminerService;
import pro.sky.kursovaya.Question;
import pro.sky.kursovaya.interfaces.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private QuestionService questionService;
    private JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(QuestionService questionService, JavaQuestionService javaQuestionService) {
        this.questionService = questionService;
        this.javaQuestionService=javaQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questionsSet = new HashSet<>();
        while (questionsSet.size()!=amount){
            questionsSet.add(this.javaQuestionService.getRandomQuestion());
        }
        return questionsSet;
    }
}
