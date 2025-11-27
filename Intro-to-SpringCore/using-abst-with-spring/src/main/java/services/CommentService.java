package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;

@Component
public class CommentService {
    private final CommentNotificationProxy commentNotificationProxy;
    private final CommentRepository commentRepository;

    // We have declared first parameter as asbtract but there are two beans of that type.
    // So to clarify that which bean will be used by spring we used qualifier annotation also and passed name of it
    @Autowired
    public CommentService(@Qualifier("Email") CommentNotificationProxy commentNotificationProxy, CommentRepository commentRepository){
        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }


    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
