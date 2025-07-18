package com.telusko.quizapp.service;

import com.telusko.quizapp.model.Question;
import com.telusko.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    static QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions(){

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public static ResponseEntity<List<Question>> getQuestionsByCategory(String category){

        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addquestions(Question question) {
           questionDao.save(question);

           return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
