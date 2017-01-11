package com.niwodai.image.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"spring/image-context.xml" })
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

} 
