package com.themainevent.maineventspringapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MainEventSpringApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainEventSpringApiApplication.class, args);
    }

}
