package greet.greetingservice.controller;

import greet.greetingservice.domain.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = GreetingController.BASE_MAPPING)
public class GreetingController {

  public static final String BASE_MAPPING = "/greeting";

  @RequestMapping("/{message}")
  public ResponseEntity<?> getGreeting(@PathVariable String message) {

    Greeting greeting = new Greeting("");
    greeting.setContent("Hello World " + message);

    return new ResponseEntity<Greeting>(greeting, HttpStatus.MULTI_STATUS.OK);
  }


}
