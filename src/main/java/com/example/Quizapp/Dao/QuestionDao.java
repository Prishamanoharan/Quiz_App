package com.example.Quizapp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Quizapp.model.Questions;

@Repository
public interface QuestionDao extends JpaRepository<Questions,Integer> {

	
	List<Questions> findByCategoryIgnoreCase(String category);


	@Query(value = "SELECT * FROM questions WHERE category = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	List<Questions> findRandomQuestionByCategoryNum(@Param("category") String category, @Param("numQ") int numQ);

	
}
