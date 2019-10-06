package com.example.stackOverFlow.repository;

import com.example.stackOverFlow.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findByEmail(String email);
    @Modifying
    @Transactional
    @Query(value = "update user_model set email=:email,password=:password WHERE user_id =:id ",nativeQuery = true)
    void updateUser(@RequestParam("email") String email,@RequestParam("password") String password,@RequestParam("id") int id);
    @Query(value = "select * from user_model g INNER JOIN vote_model b ON " +
            "g.user_id = b.user_id where b.answer_id =:ansId and b.vote_value=1",nativeQuery = true)
    List<UserModel> getVoteUpUsers(int ansId);
    @Query(value = "select * from user_model g INNER JOIN vote_model b ON " +
            "g.user_id = b.user_id where b.answer_id =:ansId and b.vote_value=0",nativeQuery = true)
    List<UserModel> getVoteDownUsers(int ansId);
    @Query(value = "select * from user_model g INNER JOIN bookmark_model b ON " +
            "g.user_id = b.user_id where b.answer_id =:ansId",nativeQuery = true)
    List<UserModel> getBookmarkUsers(int ansId);
}
