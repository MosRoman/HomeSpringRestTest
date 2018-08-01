package com.example.demo778;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MyRestController {

    @Autowired
    PetsService petsService;


    @GetMapping
    @RequestMapping("/readPets" )
    @ResponseBody
    Collection<Pets> readPets(){ return  petsService.findAll();}


//    @PostMapping
    @RequestMapping(value = "/addPets", method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    void addCategory(@RequestBody Pets pets){
        this.petsService.addPet(pets);
    }

}
