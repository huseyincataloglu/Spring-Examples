package org.example.service;

import org.example.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

//    @Autowired
//    private CommentProcessor commentProcessor;
//
//    public void sendComment(Comment comment){
//        commentProcessor.setComment(comment);
//        commentProcessor.processComment(comment);
//        commentProcessor.validateComment (comment);
//
//        Comment processedComment = commentProcessor.getComment();
//        // do something further
//    }

//    public CommentProcessor getCommentProcessor() {
//        return commentProcessor;
//    }

    @Autowired
    private ApplicationContext applicationContext;

    public void sendComment(Comment comment){
        CommentProcessor cmdProcessor = applicationContext.getBean(CommentProcessor.class); // we will create different processors for every getBean call
        // Because we have declared proccessor type as prototype scope

        cmdProcessor.setComment(comment);
        cmdProcessor.processComment(comment);
        cmdProcessor.validateComment(comment);
        Comment processedComment = cmdProcessor.getComment();
        // do something further
    }


}

