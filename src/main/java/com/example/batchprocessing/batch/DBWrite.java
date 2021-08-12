package com.example.batchprocessing.batch;

import com.example.batchprocessing.model.Person;
import com.example.batchprocessing.repository.PersonRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWrite implements ItemWriter<Person> {

    @Autowired
    private PersonRepository personRepo;

    @Override
    public void write(List<? extends Person> persons) throws Exception {
        personRepo.saveAll(persons);
        persons.forEach(System.out::println);
        System.out.println("data is saved to db"+persons);
    }

}