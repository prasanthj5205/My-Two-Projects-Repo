package com.jp.QuizApp.Service;

import com.jp.QuizApp.DAO.QuestionRepo;
import com.jp.QuizApp.Model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }
}
