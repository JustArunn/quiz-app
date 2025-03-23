package com.quiz.quizapp.DAO;

import com.quiz.quizapp.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface QuizDAO extends JpaRepository<Quiz, String> {
}
