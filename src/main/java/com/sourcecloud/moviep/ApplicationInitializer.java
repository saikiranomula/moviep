package com.sourcecloud.moviep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sourcecloud")
public class ApplicationInitializer 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ApplicationInitializer.class, args);
    }
}
