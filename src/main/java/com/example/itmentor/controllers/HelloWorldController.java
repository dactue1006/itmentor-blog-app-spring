package com.example.itmentor.controllers;

import com.example.itmentor.dto.MyBean;
import com.example.itmentor.dto.Player;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Define Controller
@RestController
public class HelloWorldController {

    // Define method "get" and path "/hello-world"
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World from Spring Boot";
    }

    @GetMapping(path = "/hello-bean")
    public MyBean helloBean() {
        return new MyBean("Hello Bean");
    }

    // Example about path variable
    @GetMapping(path = "/users/{username}/orders/{orderId}")
    public MyBean helloPathVariable(@PathVariable("username") String username,
                                    @PathVariable("orderId") Long orderId) {
        return new MyBean(String.format("username: %s, orderId: %s", username, orderId));
    }

    // Example about request param
    @GetMapping(path = "/players")
    public MyBean helloRequestParam(@RequestParam(defaultValue = "Ronaldo") String name,
                                    @RequestParam(defaultValue = "35") int age) {
        return new MyBean(String.format("name: %s, age: %s", name, age));
    }

    // Example about request body
    @PostMapping(path = "/players")
    public Player helloRequestBody(@RequestBody Player playerRequest) {
        Player myPlayer = new Player(playerRequest.getName(), playerRequest.getAge(), playerRequest.getTeam());
        return myPlayer;
    }

    // Example about response entity
    @GetMapping(path = "/response-entity")
    public ResponseEntity<?> helloResponseEntity(@RequestParam int age) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("My-Header", "itmentor");
        if (age <= 18) {
            return new ResponseEntity<>("Your age is not greater than 18", headers, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Your age is greater than 18", headers, HttpStatus.OK);
    }
}
