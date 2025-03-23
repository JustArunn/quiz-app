package com.quiz.quizapp.controllers;

import com.quiz.quizapp.models.Question;
import com.quiz.quizapp.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class QuestionController {

    @Autowired
    QuestionsService questionsService;

    @GetMapping("questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionsService.getAllQuestions();
    }

    @GetMapping("question/{id}")
    public ResponseEntity<Optional<Question>> getQuestionById(@PathVariable String id){
        return questionsService.getQuestionById(id);
    }

    @GetMapping("question/category/{category}")
    public ResponseEntity<List<Question>> getByCategory(@PathVariable String category){
        return questionsService.getByCategory(category);
    }

    @PostMapping("question/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionsService.addQuestion(question);
    }

    @PostMapping("question/remove")
    public ResponseEntity<String> removeQuestion(@RequestBody Question question){
        System.out.println("id..........." + question.getId());
        return questionsService.removeQuestion(question.getId());
    }
}
