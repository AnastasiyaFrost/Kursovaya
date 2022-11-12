package pro.sky.kursovaya.services;

import org.springframework.stereotype.Service;
import pro.sky.kursovaya.Question;
import pro.sky.kursovaya.exceptions.IncorrectQuestionException;
import pro.sky.kursovaya.exceptions.QuestionIsNotFoundException;
import pro.sky.kursovaya.interfaces.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    static Set<Question> questions = new HashSet<>(Set.of(
            new Question("Легендарное призвание варягов произошло в:", "862"),
            new Question("Объединению Новгорода и Киева в 882 г. поспособствовал:",
                    "Князь Олег"),
            new Question("Укажите даты правления князя Святослава Игоревича",
                    "957-972 гг."),
            new Question("Какой русский князь был убит в Золотой Орде в 1318 г.?",
                    "Михаил Тверской"),
            new Question("В каком году завершилось собирание русских земель вокруг Москвы?",
                    "1520 г."),
            new Question("Термин «Семибоярщина» относится к периоду:",
                    "1610-м гг."),
            new Question("«Смутное время» завершилось:",
                    "Земским собором в феврале 1613 г. и избранием Михаила Романова царем"),
            new Question("Единоличное правление Петра Великого началось в:",
                    "1696 г."),
            new Question("Эпоха «Дворцовых переворотов» охватывает события:",
                    "1725-1762 гг."),
            new Question("Когда была подписана «Жалованная грамота дворянству» Екатериной Великой?",
                    "1785 г."),
            new Question("Укажите годы правления Александра I Благословенного:",
                    "1801-1825 гг."),
            new Question("Укажите даты Большой Кавказской войны:", "1817-1864 гг."),
            new Question("Эпохой «Великих реформ» называют период:",
                    "1860-х – 1870-х гг."),
            new Question("А. В. Колчак был расстрелян красными:", "1 февраля 1920 г."),
            new Question("НЭП включала в себя денежную реформу. Укажите ее даты:",
                    "1922-1924 гг."),
            new Question("В какой период состоялась I-я пятилетка?", "1928-1932 гг."),
            new Question("В каком году был создана организация Варшавского договора?",
                    "1955 г.")
    ));

public boolean checkInput(Question question) {
    return !question.getQuestion().isBlank() && !question.getQuestion().isEmpty()
            && !question.getAnswer().isBlank() && !question.getAnswer().isEmpty();
}

    @Override
    public Question add(Question question) {
        if(!checkInput(question)) {throw new IncorrectQuestionException();}
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!checkInput(question)) {throw new IncorrectQuestionException();}
        if (!questions.contains(question)){throw new QuestionIsNotFoundException();}
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
    if(questions.isEmpty()){throw new QuestionIsNotFoundException();}
        return questions.stream().skip(new Random().nextInt(questions.size())).findFirst().orElse(null);
    }
}
