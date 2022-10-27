package pro.sky.kursovaya.controllers;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovaya.Question;
import pro.sky.kursovaya.services.ExaminerServiceImpl;

import java.util.Collection;

@RestController
public class ExamController {
    private ExaminerServiceImpl examinerServiceImpl;

    public ExamController(ExaminerServiceImpl examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    public Collection<Question> getQuestions(@RequestParam int amount) {}
}
