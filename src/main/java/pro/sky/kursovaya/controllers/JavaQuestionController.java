package pro.sky.kursovaya.controllers;

import org.springframework.web.bind.annotation.*;
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
    public Question addQuestion(@RequestBody Question question){
        return this.javaQuestionService.add(question);
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

