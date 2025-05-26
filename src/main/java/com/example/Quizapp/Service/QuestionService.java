package com.example.Quizapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Quizapp.Dao.QuestionDao;
import com.example.Quizapp.model.Questions;

@Service
public class QuestionService {
	 @Autowired
 QuestionDao questiondao;

 public ResponseEntity<List<Questions>> getAllquestion() {
	 try {
		return new ResponseEntity(questiondao.findAll(),HttpStatus.OK);
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	 return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
 }
 
 

public ResponseEntity<List<Questions>> getByCategory(String category) {
	try {
	return new ResponseEntity(questiondao.findByCategoryIgnoreCase(category),HttpStatus.FOUND);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	 return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
 }
 



public ResponseEntity<String> addQuestions(Questions question) {
	try {
		questiondao.save(question);
	 return new ResponseEntity<>( "Success",HttpStatus.CREATED);
}catch(Exception e) {
	e.printStackTrace();
}
 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}




public ResponseEntity<String> delQuestions(Questions question) {
	try {
		questiondao.delete(question);
	return new ResponseEntity<>( "deleted",HttpStatus.OK);
}catch(Exception e) {
	e.printStackTrace();
}
 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}

}
