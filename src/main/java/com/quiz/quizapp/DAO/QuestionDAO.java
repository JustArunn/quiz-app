package com.quiz.quizapp.DAO;

import com.quiz.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, String> {
    public List<Question>getByCategory(String category);
}
