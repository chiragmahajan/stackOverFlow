package com.example.stackOverFlow.service;

import com.example.stackOverFlow.model.AnswerModel;
import com.example.stackOverFlow.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;
    public List<AnswerModel> getAllAnswers(){
        return answerRepository.findAll();
    }
    public AnswerModel getAnswerById(int id){
        return answerRepository.findById(id).get();
    }
    public void addAnswer(AnswerModel answerModel){
        answerRepository.save(answerModel);
    }
    public void updateAnswer(AnswerModel answerModel,int id){
        AnswerModel old = answerRepository.getOne(id);
        if((answerModel.getAnswer().equals(" "))&& old!=null){
                answerModel.setAnswer(old.getAnswer());
        }
        answerRepository.updateAnswer(answerModel.getAnswer(),id);
    }
    public List<AnswerModel> getAnswersByQuestionId(int id){
        return answerRepository.findByQuestionId(id);
    }
    public List<AnswerModel> getAnswersByUserId(int id){
        return answerRepository.findByUserId(id);
    }
    public void deleteAnswer(int id){
        answerRepository.deleteById(id);
    }
    public int AnswersCountUser(int id){
        return answerRepository.answerCountUser(id);
    }
    public int AnswersCountQuestion(int id){
        return answerRepository.answerCountQuestion(id);
    }
    public AnswerModel getAnswerByQuestionUserId(int userId,int quesId){
        return answerRepository.getAnswerByQueUserId(userId,quesId).get(0);
    }
    public List<AnswerModel> getBookmarkedAnswersByUser(int userId){
        return answerRepository.getBookmarkedAnswers(userId);
    }
    public List<AnswerModel> getUpVotedAnswersByUser(int userId){
        return answerRepository.getUpVotedAnswers(userId);
    }
    public List<AnswerModel> getDownVotedAnswersByUser(int userId){
        return answerRepository.getDownVotedAnswers(userId);
    }
}
