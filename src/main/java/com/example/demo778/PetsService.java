package com.example.demo778;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PetsService {
    @Autowired
    private PetsRepository petsRepository;

    @Transactional
    public void addPet(Pets pets) {
        petsRepository.save(pets);
    }

    @Transactional
    public List<Pets> findAll() {
        return petsRepository.findAll();
    }

    @Transactional
    public Pets findPet(long id) {
        return petsRepository.findById(id);
    }


}
