package io.djk.loginservice.controller;

import io.djk.loginservice.domain.User;
import io.djk.loginservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dkothari on 2/22/19.
 */
@Controller
public class LoginServiceRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public @ResponseBody
    String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Boolean> createUser(@RequestBody User user) {
        userRepository.save(user);
    }


}
