package org.peterpark.storage;

import org.peterpark.storage.service.springlifecycle.SpringHook;
import org.peterpark.storage.util.SpringContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        SpringContextUtil.getBean("springHook", SpringHook.class);
    }

} 
