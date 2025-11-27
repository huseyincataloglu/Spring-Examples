package org.example.service;


import org.example.model.Comment;
import org.springframework.stereotype.Service;



@Service
public class CommentService {


    public void publishcComment(Comment comment) {
    }
    public String deleteComment(Comment comment){
        return "Success!";
    }
}
