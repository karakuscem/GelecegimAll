package com.allianz.example.controller;

import com.allianz.example.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example")
public class ExampleController {

        @GetMapping("hello-world")
        public ResponseEntity<String> helloWorldApi() {
                return new ResponseEntity<>("Hello World!", HttpStatus.OK);
        }

        @GetMapping("person")
        public ResponseEntity<Person> personApi() {
                Person person = new Person();
                person.setName("John Doe");
                person.setAge(30);
                person.setAddress("123 Main St.");
                person.setPhoneNumber("555-555-5555");
                return new ResponseEntity<>(person, HttpStatus.OK);
        }
}
