package org.example.config;

import org.example.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProjectConfig {

    @Bean
    public CommentService commentService(){
        return new CommentService();
    }

    //prototype scope allows different approach for creating beans
    @Bean
    @Scope("prototype")
    public CommentService commentService2(){
        return new CommentService();
    }

}
