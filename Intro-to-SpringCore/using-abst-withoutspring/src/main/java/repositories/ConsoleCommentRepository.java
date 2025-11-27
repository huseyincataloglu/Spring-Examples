package repositories;

import model.Comment;

public class ConsoleCommentRepository implements CommentRepository{

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Comment is : %s by %s".formatted(comment.getText(),comment.getAuthor()));
    }
}
