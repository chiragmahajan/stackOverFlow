package com.example.stackOverFlow.controller;

import com.example.stackOverFlow.model.AnswerModel;
import com.example.stackOverFlow.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnswerController {
    @Autowired
    private AnswerService answerService;
    @RequestMapping(value = "/getAllAnswers", method = { RequestMethod.GET })
    public List<AnswerModel> getAllAnswers(){
        return answerService.getAllAnswers();
    }
    @RequestMapping(value = "/getAnswerById/{id}", method = { RequestMethod.GET })
    public AnswerModel getAnswerById(@PathVariable int id){
        return answerService.getAnswerById(id);
    }
    @RequestMapping(value = "/getAnswersByQuestionId/{id}", method = { RequestMethod.GET })
    public List<AnswerModel> getAnswersByQuestionId(@PathVariable int id){
        return answerService.getAnswersByQuestionId(id);
    }
    @RequestMapping(value = "/getAnswersByUserId/{id}", method = { RequestMethod.GET })
    public List<AnswerModel> getAnswersByUserId(@PathVariable int id){
        return answerService.getAnswersByUserId(id);
    }
    @RequestMapping(value = "/updateAnswer/{id}" ,method = { RequestMethod.PUT }, consumes = "application/json")
    public void updateAnswer(@RequestBody AnswerModel answerModel,@PathVariable int id){
        answerService.updateAnswer(answerModel,id);
    }
    @RequestMapping(value = "/addAnswer",method = {RequestMethod.POST},consumes = "application/json")
    public void addAnswer(@RequestBody AnswerModel answerModel){
        answerService.addAnswer(answerModel);
    }
    @RequestMapping(value = "/deleteAnswer/{id}", method = { RequestMethod.GET })
    public void deleteAnswer(@PathVariable int id){
        answerService.deleteAnswer(id);
    }
    @RequestMapping(value = "/getAnswerCountUser/{id}", method = { RequestMethod.GET })
    public int getAnswerCountUser(@PathVariable int id){
        return answerService.AnswersCountUser(id);
    }
    @RequestMapping(value = "/getAnswerCountQuestion/{id}", method = { RequestMethod.GET })
    public int getAnswerCountQuestion(@PathVariable int id){
        return answerService.AnswersCountQuestion(id);
    }

    @RequestMapping(value = "/getAnswerByQuestionAndUserId", method = { RequestMethod.GET })
    public AnswerModel getAnswersByQuestionAndUserId(@RequestParam("userId") int userId,@RequestParam("quesId") int quesId){
        return answerService.getAnswerByQuestionUserId(userId,quesId);
    }
    @RequestMapping(value = "/getBookmarkedAnswers/{id}", method = { RequestMethod.GET })
    public List<AnswerModel> getBookmarkedAnswers(@PathVariable int id){
        return answerService.getBookmarkedAnswersByUser(id);
    }
    @RequestMapping(value = "/getUpVotedAnswers/{id}", method = { RequestMethod.GET })
    public List<AnswerModel> getUpVotedAnswers(@PathVariable int id){
        return answerService.getUpVotedAnswersByUser(id);
    }
    @RequestMapping(value = "/getDownVotedAnswers/{id}", method = { RequestMethod.GET })
    public List<AnswerModel> getDownVotedAnswers(@PathVariable int id){
        return answerService.getDownVotedAnswersByUser(id);
    }
}
