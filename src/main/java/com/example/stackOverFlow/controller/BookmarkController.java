package com.example.stackOverFlow.controller;

import com.example.stackOverFlow.model.BookmarkModel;
import com.example.stackOverFlow.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookmarkController {
    @Autowired
    BookmarkService bookmarkService;
    @RequestMapping(value = "/addBookmark",method = {RequestMethod.POST},consumes = "application/json")
    public void addBookmark(@RequestBody BookmarkModel bookmarkModel){
        bookmarkService.addBookmark(bookmarkModel);
    }
}
