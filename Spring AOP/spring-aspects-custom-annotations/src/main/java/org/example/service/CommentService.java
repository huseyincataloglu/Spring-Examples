package org.example.service;


import org.example.annotations.ToLog;
import org.example.annotations.ValidateComment;
import org.example.model.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    @ToLog
    public String publishComment(Comment comment) {
        return "Publish has succeded.";
    }
    @ToLog
    public String deleteComment(Comment comment){
        return "Success!";
    }
}
