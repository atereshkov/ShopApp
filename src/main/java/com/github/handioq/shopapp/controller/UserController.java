package com.github.handioq.shopapp.controller;

import com.github.handioq.shopapp.model.entity.User;
import com.github.handioq.shopapp.service.UserService;
import com.github.handioq.shopapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.API_URL + Constants.URL_USERS)
public class UserController {

    @Autowired
    private UserService userService;

/*    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getByEmail(@RequestParam("email") String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }*/

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        User user = userService.findOne(id);

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBytId(@PathVariable("id") long id) {
        User user = userService.findOne(id);

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getUsers() {
        List<User> users = userService.findAll();

        if (users.isEmpty()) {
            return new ResponseEntity<>("Empty", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
