package com.example.stackOverFlow.repository;

import com.example.stackOverFlow.model.AnswerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerModel,Integer> {
    @Query(value = "Select * FROM answer_model g WHERE g.question_id =:questionId",nativeQuery = true)
    List<AnswerModel> findByQuestionId(@Param("questionId") int id);
    @Query(value = "Select * FROM answer_model g WHERE g.user_id =:userId",nativeQuery = true)
    List<AnswerModel> findByUserId(@Param("userId")int id);
    @Modifying
    @Transactional
    @Query(value = "update answer_model set answer=:answer WHERE answer_id =:id ",nativeQuery = true)
    void updateAnswer(String answer, int id);
    @Query(value = "Select COUNT(*) FROM answer_model g WHERE g.user_id =:userId",nativeQuery = true)
    int answerCountUser(@Param("userId") int id);
    @Query(value = "Select COUNT(*) FROM answer_model g WHERE g.question_id =:questionId",nativeQuery = true)
    int answerCountQuestion(@Param("questionId") int id);

    @Query(value = "select * from answer_model g WHERE g.user_id =:user_id and g.question_id =:question_id",nativeQuery = true)
    List<AnswerModel> getAnswerByQueUserId(@Param("user_id") int userId,@Param("question_id") int quesId);


    @Query(value = "select * from answer_model g INNER JOIN bookmark_model b ON " +
            "g.answer_id = b.answer_id where b.user_id =:userId ",nativeQuery = true)
    List<AnswerModel> getBookmarkedAnswers(@Param("userId") int userId);
    @Query(value = "select * from answer_model g INNER JOIN vote_model b ON " +
            "g.answer_id = b.answer_id where b.user_id =:userId and b.vote_value=1",nativeQuery = true)
    List<AnswerModel> getUpVotedAnswers(int userId);
    @Query(value = "select * from answer_model g INNER JOIN vote_model b ON " +
            "g.answer_id = b.answer_id where b.user_id =:userId and b.vote_value=0",nativeQuery = true)
    List<AnswerModel> getDownVotedAnswers(int userId);
}
