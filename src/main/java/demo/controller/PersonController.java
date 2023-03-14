package demo.controller;

import demo.entity.Person;
import demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    /*
    Here I could be using DTOs but the application is too simple and I couldn't find any reasons to, but
    I do understand the importance of DTOs.
    */

    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.getPersonById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Person> deletePersonById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personService.deletePersonById(id));
    }

    @PostMapping()
    public ResponseEntity<Person> upsertPerson(@RequestBody Person person){
        return ResponseEntity.status(HttpStatus.OK).body(personService.upsertPerson(person));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Person>> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String age
    ){
        return ResponseEntity.status(HttpStatus.OK).body(personService.searchPerson(name, gender, age));
    }
}
