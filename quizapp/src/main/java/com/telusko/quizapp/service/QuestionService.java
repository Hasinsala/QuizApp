package com.telusko.quizapp.service;

import com.telusko.quizapp.Question;
import com.telusko.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    static QuestionDao questionDao;
    public List<Question> getAllQuestions(){

       return questionDao.findAll();

    }

    public static List<Question> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }

    public String addquestions(Question question) {
           questionDao.save(question);

           return "success";
    }
}
