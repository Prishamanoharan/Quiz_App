package com.example.Quizapp.Service;

import java.util.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Quizapp.Dao.QuestionDao;
import com.example.Quizapp.Dao.QuizDao;
import com.example.Quizapp.model.QuestionWrapper;
import com.example.Quizapp.model.Questions;
import com.example.Quizapp.model.Quiz;
import com.example.Quizapp.model.Response;

@Service
public class QuizService {
 @Autowired
	QuizDao quizdao;
 @Autowired
  QuestionDao questiondao;
 public ResponseEntity<String> createQuiz( String category,String title, int numQ){
	 List<Questions>questions=questiondao.findRandomQuestionByCategoryNum(category,numQ);
 Quiz quiz=new Quiz();
 quiz.setTitle(title);
 quiz.setQuestions(questions);

 System.out.println("Questions fetched: " + questions.size());

 quizdao.save(quiz);
  
 return new ResponseEntity<>("done",HttpStatus.CREATED);
 
 
	 
 }
 public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
     Optional<Quiz> quiz = quizdao.findById(id);

     if (quiz.isEmpty()) {
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }

     List<Questions> questionfromDb = quiz.get().getQuestions();
     List<QuestionWrapper> questionforuser = new ArrayList<>();

	 for (Questions q : questionfromDb) {
         QuestionWrapper qw = new QuestionWrapper(
             q.getId(),
             q.getCategory(),
             q.getDifficultylevel(),
             q.getOption1(),
             q.getOption2(),
             q.getOption3(),
             q.getAns(),
             q.getTitle()
         );
         questionforuser.add(qw);
     }

     System.out.println("Questions retrieved: " + questionfromDb.size());

     return new ResponseEntity<>(questionforuser, HttpStatus.OK);
 }
 
 public ResponseEntity<Integer> CalculateResponse(Integer id, List<Response> responses) {
	    // Fetch the quiz
	    Quiz quiz = quizdao.findById(id)
	            .orElseThrow(() -> new RuntimeException("Quiz not found"));

	    List<Questions> questions = quiz.getQuestions();

	    int right = 0;

	  
	    for (Response response : responses) {
	        
	        Questions question = null;
	        for (Questions q : questions) {
	            if (q.getId().equals(response.getId())) {
	                question = q;
	                break;
	            }
	        }

	        if (question != null) {
	            String correct = question.getAns();
	            String user = String.valueOf(response.getResponse());

	            System.out.println("Q" + question.getId() +
	                ": correct=" + correct + " (" + (correct != null ? correct.getClass().getSimpleName() : "null") + ")" +
	                ", user=" + user + " (" + (user != null ? user.getClass().getSimpleName() : "null") + ")");

	            if (correct != null && user != null &&
	                    correct.trim().equalsIgnoreCase(user.trim())) {
	                right++;
	            }
	        } else {
	            System.out.println("Question ID " + response.getId() + " not found in quiz.");
	        }
	    }

	    return new ResponseEntity<>(right, HttpStatus.OK);
	}




}
