package com.quiz.quizapp.services;

import com.quiz.quizapp.DAO.QuestionDAO;
import com.quiz.quizapp.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Optional<Question>> getQuestionById(String id) {
        return new ResponseEntity<>(questionDAO.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        if (question.getTitle().isEmpty() || question.getDescription().isEmpty() || question.getOption1().isEmpty() || question.getOption2().isEmpty() || question.getOption3().isEmpty() || question.getOption4().isEmpty()) {
            return new ResponseEntity<>("All fields are required", HttpStatus.BAD_REQUEST);
        }

        questionDAO.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<String> removeQuestion(String id) {
        questionDAO.deleteById(id);
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

    public ResponseEntity<List<Question>> getByCategory(String category) {
        return new ResponseEntity<>(questionDAO.getByCategory(category), HttpStatus.OK);
    }
}
