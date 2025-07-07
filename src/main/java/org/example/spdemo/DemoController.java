package org.example.spdemo;

import org.example.spdemo.primary.PersonRepository1;
import org.example.spdemo.secondary.PersonRepository2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

    private final PersonRepository1 personRepository1;
    private final PersonRepository2 personRepository2;

    public DemoController(PersonRepository1 personRepository1, PersonRepository2 personRepository2) {
        this.personRepository1 = personRepository1;
        this.personRepository2 = personRepository2;
    }

    @GetMapping("/demo")
    ResponseEntity<String> getDemo() {
        int count1 = personRepository1.getPersonCount();
        int count12 = personRepository1.getPersonCount2();
        int count2 = personRepository2.getPersonCount();
        int count22 = personRepository2.getPersonCount2();
        return ResponseEntity.ok(String.format("Person count1: %d<br>Person count12: %d<br>Person count2: %d<br>Person count22: %d", count1, count12,count2,count22));
    }
}
