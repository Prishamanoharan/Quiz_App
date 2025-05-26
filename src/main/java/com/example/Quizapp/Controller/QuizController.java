package com.example.Quizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Quizapp.Service.QuizService;
import com.example.Quizapp.model.QuestionWrapper;
import com.example.Quizapp.model.Response;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(
        @RequestParam String category,
        @RequestParam String title,
        @RequestParam int numQ) {
        return quizService.createQuiz(category, title, numQ);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(
        @PathVariable Integer id,
        @RequestBody List<Response> responses) {
        return quizService.CalculateResponse(id, responses);
    }
}
