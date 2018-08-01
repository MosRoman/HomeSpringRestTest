package com.example.demo778;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Рома on 27.07.2018.
 */
public interface PetsRepository extends JpaRepository<Pets,Long> {

    @Query("SELECT u FROM Pets u where u.id = :id")
    Pets findById(@Param("id") long id);
}
