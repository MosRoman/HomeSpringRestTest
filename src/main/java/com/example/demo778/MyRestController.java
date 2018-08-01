package com.example.demo778;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MyRestController {

    @Autowired
    PetsService petsService;


    @GetMapping
    @RequestMapping("/readPets")
    Collection<Pets> readPets(){ return  petsService.findAll();}


    @PostMapping
    @RequestMapping("/addPets")
    @ResponseStatus(HttpStatus.CREATED)
    void addCategory(@RequestBody Pets pets){
        this.petsService.addPet(pets);
    }

}
