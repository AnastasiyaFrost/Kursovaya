package pro.sky.kursovaya.interfaces;

import pro.sky.kursovaya.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

