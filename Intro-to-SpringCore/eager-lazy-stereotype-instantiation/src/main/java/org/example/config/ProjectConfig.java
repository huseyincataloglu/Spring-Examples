package org.example.config;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


// Configuration annotation indicates the class where to define the beans. In this class beans objects are defined and
// stored in Spring application context.
// Spring manages these objects
@Configuration
@ComponentScan(basePackages = {"org.example.proxy","org.example.repository","org.example.services"})
public class ProjectConfig {

}
