package com.example.stackOverFlow.repository;

import com.example.stackOverFlow.model.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuestionRepository  extends JpaRepository<QuestionModel,Integer> {
    @Query(value = "select * FROM question_model WHERE user_id =:userId",nativeQuery = true)
    List<QuestionModel> findByUserId(@Param("userId") int id);
    @Modifying
    @Transactional
    @Query(value = "update  question_model set question=:question WHERE question_id =:id ",nativeQuery = true)
    void updateQuestion(@RequestParam("question") String question,@RequestParam("id") int id);
    @Query(value = "select COUNT(*) FROM question_model",nativeQuery = true)
    int totalQuestionCount();
    @Query(value = "select COUNT(*) FROM question_model  WHERE user_id =:userId",nativeQuery = true)
    int totalQuestionCountUser(@Param("userId") int id);
}
