package demo.service;

import demo.entity.Person;
import java.util.List;

public interface PersonService {

    Person getPersonById(Long id);

    Person deletePersonById(Long id);

    Person upsertPerson(Person person);

    List<Person> searchPerson(String name, String gender, String age);
}
