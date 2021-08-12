package com.example.batchprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <com.example.batchprocessing.model.Person,Integer> {
}
