package com.example.stackOverFlow.controller;

import com.example.stackOverFlow.model.QuestionModel;
import com.example.stackOverFlow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/getAllQuestions", method = { RequestMethod.GET })
    public List<QuestionModel> getAllQuestions(){
         return questionService.getAllQuestions();
    }
    @RequestMapping(value = "/getQuestion/{id}", method = { RequestMethod.GET })
    public QuestionModel getQuestionById(@PathVariable int id){
         return questionService.getQuestionById(id);
    }
    @RequestMapping(value = "/getQuestionUser/{id}", method = { RequestMethod.GET })
    public List<QuestionModel> getAllQuestionsByUser(@PathVariable int id){
         return questionService.getQuestionsByUser(id);
    }
    @RequestMapping(value = "/addQuestion",method = {RequestMethod.POST},consumes = "application/json")
    public void addQuestion(@RequestBody QuestionModel questionModel){
        questionService.postQuestion(questionModel);
    }
    @RequestMapping(value = "/updateQuestion/{id}" ,method = { RequestMethod.PUT }, consumes = "application/json")
    public void updateQuestion(@RequestBody QuestionModel questionModel,@PathVariable int id){
        questionService.updateQuestion(questionModel,id);
    }
    @RequestMapping(value = "/deleteQuestion/{id}", method = { RequestMethod.GET })
    public void deleteQuestion(@PathVariable int id){
        questionService.deleteQuestion(id);
    }
    @RequestMapping(value = "/getQuestionCount", method = { RequestMethod.GET })
    public int getQuestionCount(){
        return questionService.totalQuestionCount();
    }
    @RequestMapping(value = "/getQuestionCountUser/{id}", method = { RequestMethod.GET })
    public int getQuestionCountUser(@PathVariable int id){
        return questionService.totalQuestionCountUser(id);
    }
}
