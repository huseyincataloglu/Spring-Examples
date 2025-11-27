package org.example.service;


import org.example.model.Comment;
import org.example.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CommentProcessor {

    private Comment comment;


    private final CommentRepository commentRepository;

    public CommentProcessor(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Comment getComment() {
        return this.comment;
    }

    public void processComment(Comment comment) {
        // changing the comment attribute

    }

    public void validateComment (Comment comment) {
    }
}
