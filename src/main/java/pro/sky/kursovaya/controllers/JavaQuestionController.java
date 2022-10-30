package pro.sky.kursovaya.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.kursovaya.Question;
import pro.sky.kursovaya.services.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/java")
public class JavaQuestionController {
    private JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer){
        return this.javaQuestionService.add(question, answer);
    }
@GetMapping
    public Collection<Question> getQuestions(){
        return this.javaQuestionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam Question question){
        return this.javaQuestionService.remove(question);
    }
}
