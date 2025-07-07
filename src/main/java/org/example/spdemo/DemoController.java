package org.example.spdemo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

    private final PersonRepository personRepository;

    public DemoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/demo")
    ResponseEntity<String> getDemo() {
//        long count = personRepository.count();
        int count=personRepository.getPersonCount();
        int count2= personRepository.getPersonCount2();
        return ResponseEntity.ok(String.format("Person count: %d\nPerson count2: %d", count,count2));
    }
}
