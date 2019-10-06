package com.example.stackOverFlow.controller;

import com.example.stackOverFlow.model.VoteModel;
import com.example.stackOverFlow.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VoteController {
    @Autowired
    private VoteService voteService;
    @RequestMapping(value = "/getUpVotesOnAnswer/{id}", method = { RequestMethod.GET })
    public int totalUpVotesOnAnswer(@PathVariable int id){
        return voteService.totalUpVotesOnAnswer(id);
    }
    @RequestMapping(value = "/getDownVotesOnAnswer/{id}", method = { RequestMethod.GET })
    public int totalDownVotesOnAnswer(@PathVariable int id){
        return voteService.totalDownVotesOnAnswer(id);
    }

    @RequestMapping(value = "/upVote",method = {RequestMethod.POST},consumes = "application/json")
    public void upVote(@RequestBody VoteModel voteModel){
        voteService.upVote(voteModel);
    }
    @RequestMapping(value = "/downVote",method = {RequestMethod.POST},consumes = "application/json")
    public void downVote(@RequestBody VoteModel voteModel){
        voteService.downVote(voteModel);
    }
}
