package org.example;


import org.example.config.ProjectConfig;
import org.example.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // We have defined comment service singleton bean
        //This means only one instance of it takes place in the context
//        CommentService commentService = context.getBean(CommentService.class);
//        CommentService commentService1 = context.getBean(CommentService.class);

//        System.out.println(commentService1 == commentService);// this will evaluate true because comment service is singleton

        //Also this single commentservice bean has single commentprocessor bean even if we have declared it as prototype scoped
//      System.out.println(commentService1.getCommentProcessor() == commentService.getCommentProcessor()); // true
        // But this will generate race condition because when many people use this comment service , they will use the same comment processor bean.
        // They will use the same data and can try to access them concurrently
        // However commentprocces type holds comment but peoples will change each other's comments and this will cause race-condition

        CommentService commentService = context.getBean(CommentService.class);
        CommentService commentService1 = context.getBean(CommentService.class);

        System.out.println(commentService1);




    }
}