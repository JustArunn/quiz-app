package com.quiz.quizapp.DAO;

import com.quiz.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question, String> {
    public List<Question> getByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :noq", nativeQuery = true)
    List<Question> getRandomQuestionByCategory(String category, int noq);
}
