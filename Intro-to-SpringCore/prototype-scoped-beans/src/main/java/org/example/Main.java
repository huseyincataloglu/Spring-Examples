package org.example;


import org.example.config.ProjectConfig;
import org.example.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        CommentService singletonBean = context.getBean("commentService", CommentService.class);
        CommentService singletonBean2 = context.getBean("commentService", CommentService.class);

        System.out.println(singletonBean == singletonBean2); // returns true

        //When we want to acces the same bean more than one
        // Instead of returning the existing bean in the context, Spring returned a new bean with the same name but a new instance.
        // This provides flexibility in time when we have to provide different instances to the objects
        CommentService prototypeBean = context.getBean("commentService2", CommentService.class);
        CommentService prototypeBean2 = context.getBean("commentService2", CommentService.class);

        System.out.println(prototypeBean2 == prototypeBean);


    }
}