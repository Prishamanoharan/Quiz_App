package com.example.Quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quizapp.Service.QuestionService;
import com.example.Quizapp.model.Questions;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/question")
public class QuestionController {
@Autowired
	QuestionService questionservice;
	
@GetMapping("/allquestion")
public ResponseEntity<List<Questions>> getAllquestion() {
	return questionservice.getAllquestion();
}

@GetMapping("/category/{category}")	
public ResponseEntity<List<Questions>> getByCategory(@PathVariable String category){
	return questionservice.getByCategory(category);
	
}
@PostMapping("/add")
public ResponseEntity<String> addQuestions(@RequestBody Questions question){
	return questionservice.addQuestions(question);
}

@DeleteMapping("delete")
public ResponseEntity<String> delQuestions(@RequestBody Questions question) {
	return questionservice.delQuestions(question);
}
	
	
}
