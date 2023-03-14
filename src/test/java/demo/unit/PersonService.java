package demo.unit;

import demo.entity.Person;
import demo.exception.ResourceNotFoundException;
import demo.repository.PersonRepository;
import demo.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static java.lang.String.format;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class PersonService {

    @InjectMocks
    private PersonServiceImpl personService;

    @Mock
    private PersonRepository personRepository;

    @Test
    public void shouldCreatePerson(){
        Person expectedPerson = Person.builder().name("Giuseppe Matteoni").age("25").gender("Male").build();

        when(personRepository.save(expectedPerson)).thenReturn(expectedPerson);

        Person actualPerson = personService.upsertPerson(expectedPerson);

        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    public void shouldGetPerson(){
        Person expectedPerson = Person.builder().name("Giuseppe Matteoni").age("25").gender("Male").build();

        when(personRepository.findById(expectedPerson.getId())).thenReturn(Optional.of(expectedPerson));

        Person actualPerson = personService.getPersonById(expectedPerson.getId());

        assertEquals(expectedPerson.getId(), actualPerson.getId());
    }

    @Test
    public void getPersonShouldThrowWhenInvalidId(){
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class,
                () -> personService.getPersonById(155548454L));

        assertEquals(format("Person %s not found", 155548454L), exception.getMessage());
    }
}
