package com.example.stackOverFlow.service;

import com.example.stackOverFlow.model.QuestionModel;
import com.example.stackOverFlow.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    public List<QuestionModel> getAllQuestions(){
        return questionRepository.findAll();
    }
    public QuestionModel getQuestionById(int id){
       return questionRepository.findById(id).get();
    }
    public List<QuestionModel> getQuestionsByUser(int id){
       return questionRepository.findByUserId(id);
    }
    public void postQuestion(QuestionModel questionModel){
        questionRepository.save(questionModel);
    }
    public void updateQuestion(QuestionModel questionModel,int id){
        QuestionModel old = questionRepository.getOne(id);
        if(questionModel.getQuestion().equals(" ") && old!=null){
               questionModel.setQuestion(old.getQuestion());
        }
        questionRepository.updateQuestion(questionModel.getQuestion(),id);
    }
    public void deleteQuestion(int id){
        questionRepository.deleteById(id);
    }
    public int totalQuestionCount(){
        return questionRepository.totalQuestionCount();
    }

    public int totalQuestionCountUser(int id) {
        return questionRepository.totalQuestionCountUser(id);
    }
}
