package org.wso2.msf4j.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.wso2.msf4j.example.model.DTO.PersonDTO;
import org.wso2.msf4j.example.model.Person;
import org.wso2.msf4j.example.repository.PersonRepository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MinhTu on 8/15/2016.
 */
@Component
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public List<PersonDTO> getListPerson(int quantity) {
        List<PersonDTO> list = new ArrayList<>();
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAge(150);
        personDTO.setBirthday(new Date(3));
        personDTO.setName("James Bone");
        personDTO.setSex("male");

        for (int i= 0; i< quantity ; i++){
            list.add(personDTO);
        }
        System.out.println(list);
        return list;

    }

    public List<PersonDTO> getAll() {
        List<PersonDTO> list = new ArrayList<>();
        createPerson();
        List<Person> personList = (List<Person>) personRepository.findUsers();
        for (Person person: personList){
            PersonDTO personDTO = new PersonDTO();
            personDTO.setId(person.getId());
            personDTO.setName(person.getName());
            personDTO.setSex(person.getSex());
            personDTO.setAge(person.getAge());
            personDTO.setBirthday(person.getBirthday());
            list.add(personDTO);
        }
        return list;

    }

    private void createPerson(){
        for (int i = 1 ; i<= 1000; i++){
            Person person = new Person();
            person.setId(i);
            person.setName("Jame"+i);
            person.setAge(30);
            person.setBirthday(new Date());
            person.setSex("male");
            personRepository.createPerson(person);
        }

    }
}
