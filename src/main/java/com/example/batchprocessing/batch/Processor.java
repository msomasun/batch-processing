package com.example.batchprocessing.batch;

import com.example.batchprocessing.model.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Person,Person> {

    @Override
    public Person process(Person person) throws Exception {
        System.out.println("inside procssor: adding 00 to its ID of "+ person);
        person.setId(Integer.getInteger("00"+person.getId()));
        return person;
        }
}
