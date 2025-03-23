package com.quiz.quizapp.services;

import com.quiz.quizapp.DAO.QuestionDAO;
import com.quiz.quizapp.DAO.QuizDAO;
import com.quiz.quizapp.models.Question;
import com.quiz.quizapp.models.Quiz;
import com.quiz.quizapp.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String title, String category, int noq) {
        List<Question> questions = questionDAO.getRandomQuestionByCategory(category, noq);
        Quiz quiz = new Quiz(title, category, questions);
        quizDAO.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestionsForQuiz(String id) {
        Optional<Quiz> quiz = quizDAO.findById(id);
        List<Question> questionFromDb = quiz.get().getQuestions();
        return new ResponseEntity<>(questionFromDb, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(String id, List<Response> responses) {
        Quiz quiz = quizDAO.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int rightAns = 0;
        int index = 0;
        for(Response r : responses){
            if(r.getResponse().equals(questions.get(index).getCorrectAnswer())){
                rightAns++;
            }
            index++;
        }
        return new ResponseEntity<>(rightAns, HttpStatus.OK);
    }
}
