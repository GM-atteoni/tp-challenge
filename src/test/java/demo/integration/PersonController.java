package demo.integration;

import demo.entity.Person;
import demo.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonController {

    private final PersonRepository personRepository;

    private final RestTemplate restTemplate;

    private final String URL  ="http://localhost:8080/person/";

    @Autowired
    public PersonController(
            PersonRepository personRepository,
            RestTemplate restTemplate) {
        this.personRepository = personRepository;
        this.restTemplate = restTemplate;
    }

    @Test
    public void shouldGetPerson() throws Exception {
        Person person = restTemplate.getForObject(URL + 1, Person.class);
        Assertions.assertNotNull(person);
    }

//    @Test
//    public void shouldAddPerson() throws Exception {
//
//    }


}
