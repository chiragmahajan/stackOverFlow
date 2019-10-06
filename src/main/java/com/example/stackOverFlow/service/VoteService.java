package com.example.stackOverFlow.service;

import com.example.stackOverFlow.model.VoteModel;
import com.example.stackOverFlow.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoteService {
    @Autowired
    private VoteRepository voteRepository;

    public void upVote(VoteModel voteModel){
        List<VoteModel> old = voteRepository.getVoteByUserAndAnswerId(voteModel.getUser().getUser_id(),voteModel.getAnswer().getAnswer_id());
        if(old.size()==0) {
            voteModel.setVoteValue(1);
            voteRepository.save(voteModel);
        }
        else if(old.get(0).getVoteValue()==0)
            voteRepository.updateVote(1,old.get(0).getVote_id());
    }
    public void downVote(VoteModel voteModel){
        List<VoteModel> old = voteRepository.getVoteByUserAndAnswerId(voteModel.getUser().getUser_id(),voteModel.getAnswer().getAnswer_id());
        if(old.size()==0) {
            voteModel.setVoteValue(0);
            voteRepository.save(voteModel);
        }
        else if(old.get(0).getVoteValue()==1)
            voteRepository.updateVote(0,old.get(0).getVote_id());
    }
    public int totalUpVotesOnAnswer(int id){
      return voteRepository.getTotalCountOnAnswer(id);
    }

    public int totalDownVotesOnAnswer(int id) {
        return voteRepository.getDownTotalCountOnAnswer(id);
    }
}
