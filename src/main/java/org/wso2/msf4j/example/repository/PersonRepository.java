package org.wso2.msf4j.example.repository;

import org.springframework.stereotype.Component;
import org.wso2.msf4j.example.model.Person;
import org.wso2.msf4j.example.model.User;

import javax.persistence.EntityManagerFactory;
import java.util.List;

/**
 * Created by Longlaptop on 8/18/2016.
 */
@Component
public class PersonRepository extends AbstractRepository {
    public PersonRepository(EntityManagerFactory emf) {
        super(emf);
    }

    public void createPerson(Person person) {
        create(person);
    }

    public void removePerson(Person person) {
        remove(person);
    }

    public User findPerson(long id) {
        return find(id);
    }

    public List<Person> findUsers() {
        return findAll(User.class);
    }
}
