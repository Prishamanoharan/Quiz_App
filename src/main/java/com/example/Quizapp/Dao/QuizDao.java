package com.example.Quizapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Quizapp.model.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {
	

}
