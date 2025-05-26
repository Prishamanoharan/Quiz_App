package com.example.Quizapp.model;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "quiz")
public class Quiz {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	private String title;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	    name = "quiz_questions",
	    joinColumns = @JoinColumn(name = "quiz_id"),
	    inverseJoinColumns = @JoinColumn(name = "questions_id")
	)
	private List<Questions> questions = new ArrayList<>();
}
