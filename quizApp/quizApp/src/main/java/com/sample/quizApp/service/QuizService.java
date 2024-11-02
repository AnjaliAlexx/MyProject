package com.sample.quizApp.service;

import com.sample.quizApp.dao.QuestionDAO;
import com.sample.quizApp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity< List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
    }

    public ResponseEntity< List<Question>> getQuestionByCATEGORY(String category) {

        return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
    }

    public void addQuestion(Question question) {
        questionDAO.save(question);
    }

    public void removeQuestion(Question question) {
        questionDAO.delete(question);
    }
}
