package com.quiz.quizapp.controllers;

import com.quiz.quizapp.models.Question;
import com.quiz.quizapp.services.QuizService;
import com.quiz.quizapp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String>createQuiz(@RequestParam String title, @RequestParam String category, @RequestParam int noq){
        return quizService.createQuiz(title,category, noq);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<Question>> getQuiz(@PathVariable String id){
        return quizService.getQuestionsForQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable String id, @RequestBody List<Response>responses){
        return quizService.submitQuiz(id, responses);
    }
}
