package com.sample.quizApp.controller;

import com.sample.quizApp.model.Question;
import com.sample.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return  quizService.getAllQuestions();

    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return quizService.getQuestionByCATEGORY(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question) {
        quizService.addQuestion(question);
        return "success";
    }
    @DeleteMapping ("remove")
    public String removeQuestion(@RequestBody Question question) {
        quizService.removeQuestion(question);
        return "success";
    }
}
