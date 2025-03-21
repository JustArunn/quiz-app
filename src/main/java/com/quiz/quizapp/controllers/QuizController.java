package com.quiz.quizapp.controllers;

import com.quiz.quizapp.models.Question;
import com.quiz.quizapp.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class QuizController {

    @Autowired
    QuestionsService questionsService;

    @GetMapping("questions")
    public List<Question> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @GetMapping("question/{id}")
    public Optional<Question> getQuestionById(@PathVariable String id){
        return questionsService.getQuestionById(id);
    }

    @GetMapping("question/category/{category}")
    public List<Question> getByCategory(@PathVariable String category){
        return questionsService.getByCategory(category);
    }

    @PostMapping("question/add")
    public String addQuestion(@RequestBody Question question) {
        return questionsService.addQuestion(question);
    }

    @PostMapping("question/remove")
    public String removeQuestion(@RequestBody Question question){
        System.out.println("id..........." + question.getId());
        return questionsService.removeQuestion(question.getId());
    }
}
