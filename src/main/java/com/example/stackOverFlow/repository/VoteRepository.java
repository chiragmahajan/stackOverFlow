package com.example.stackOverFlow.repository;

import com.example.stackOverFlow.model.VoteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<VoteModel,Integer> {
    @Query(value = "select * from vote_model WHERE user_id=:userId and answer_id=:answerId ",nativeQuery = true)
    List<VoteModel> getVoteByUserAndAnswerId(@Param("userId") int user_id, @Param("answerId") int answer_id);
    @Modifying
    @Transactional
    @Query(value = "update vote_model set vote_value=:voteValue WHERE vote_id=:id ",nativeQuery = true)
    void updateVote(@Param("voteValue") int voteValue,@Param("id") int vote_id);
    @Query(value = "select COUNT(*) from vote_model WHERE answer_id=:answerId and vote_value=1",nativeQuery = true)
    int getTotalCountOnAnswer(@Param("answerId") int id);
    @Query(value = "select COUNT(*) from vote_model WHERE answer_id=:answerId and vote_value=0",nativeQuery = true)
    int getDownTotalCountOnAnswer(@Param("answerId") int id);
}
