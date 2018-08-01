package com.example.demo778;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(final PetsService petsService) {
        return arg -> {
            for(int i=0;i<10;i++) {
                petsService.addPet(new Pets("cat "+i, "black "+i));
                petsService.addPet(new Pets("dog "+i, "rudy "+i));
            }
        };
    }
}

