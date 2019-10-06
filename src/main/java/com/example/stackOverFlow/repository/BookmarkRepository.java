package com.example.stackOverFlow.repository;

import com.example.stackOverFlow.model.BookmarkModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<BookmarkModel,Integer> {
    @Query(value = "select * from bookmark_model b WHERE b.user_id =:userId and b.answer_id =:answerId ",nativeQuery = true)
    List<BookmarkModel> getBookmarkByUserAndAnswerId(@Param("userId") int userId, @Param("answerId") int answerId);
}
