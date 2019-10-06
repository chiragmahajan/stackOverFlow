package com.example.stackOverFlow.service;

import com.example.stackOverFlow.model.BookmarkModel;
import com.example.stackOverFlow.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {
    @Autowired
    BookmarkRepository bookmarkRepository;

    public void addBookmark(BookmarkModel bookmarkModel){
        List<BookmarkModel> old = bookmarkRepository.getBookmarkByUserAndAnswerId(bookmarkModel.getUser().getUser_id()
                                                            ,bookmarkModel.getAnswer().getAnswer_id());
        if(old.size()==0)
           bookmarkRepository.save(bookmarkModel);
        else
            bookmarkRepository.delete(old.get(0));

    }
}
