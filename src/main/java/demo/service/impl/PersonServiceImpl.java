package demo.service.impl;


import demo.entity.Person;
import demo.exception.ResourceNotFoundException;
import demo.repository.PersonRepository;
import demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(Person.class, id));
    }

    @Override
    public Person deletePersonById(Long id) {
        if (personRepository.existsById(id)){
            Person person = personRepository.findById(id).get();
            personRepository.deleteById(id);
            return person;
        }else{
         throw new ResourceNotFoundException(Person.class, id)  ;
        }
    }

    @Override
    public Person upsertPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> searchPerson(String name, String gender, String age) {
        return personRepository.findByNameOrAgeOrGender(
                name,
                age,
                gender
        );
    }


}
