package org.example.repository;

import org.example.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class DbCommentRepository implements CommentRepository{

    @Override
    public void storeComment(Comment comment) {
        System.out.println("The comment(%s) is added".formatted(comment));
    }
}
