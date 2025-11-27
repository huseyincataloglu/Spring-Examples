package org.example;

import model.Comment;
import proxies.EmailNotificationProxy;
import repositories.ConsoleCommentRepository;
import services.CommentService;

public class Main {
    public static void main(String[] args) {

        Comment comment = new Comment("Huseyin Cataloglu","In my opinion, Faramir is mightiest charachter in " +
                "lord of the rings world");

        ConsoleCommentRepository consoleCommentRepository = new ConsoleCommentRepository();
        EmailNotificationProxy emailNotificationProxy = new EmailNotificationProxy();
        CommentService commentService = new CommentService(emailNotificationProxy,consoleCommentRepository);
        commentService.publishComment(comment);

    }
}