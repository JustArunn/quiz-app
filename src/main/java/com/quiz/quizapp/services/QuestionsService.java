package com.quiz.quizapp.services;

import com.quiz.quizapp.DAO.QuestionDAO;
import com.quiz.quizapp.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionsService {

    @Autowired
    QuestionDAO questionDAO;

    public List<Question> getAllQuestions() {
        return questionDAO.findAll();
    }

    public Optional<Question> getQuestionById(String id){
        return questionDAO.findById(id);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "success";
    }

    public String removeQuestion(String id) {
        questionDAO.deleteById(id);
        return "deleted";
    }

    public List<Question> getByCategory(String category){
        return questionDAO.getByCategory(category);
    }
}
