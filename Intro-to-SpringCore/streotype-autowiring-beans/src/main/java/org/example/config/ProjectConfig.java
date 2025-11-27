package org.example.config;


import org.example.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Configuration annotation indicates the class where to define the beans. In this class beans objects are defined and
// stored in Spring application context.
// Spring manages these objects
@Configuration
@ComponentScan(basePackages = "org.example.model")
public class ProjectConfig {



}
