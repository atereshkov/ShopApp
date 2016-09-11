package com.github.handioq.shopapp.controller;

import com.github.handioq.shopapp.model.User;
import com.github.handioq.shopapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@RequestMapping("/api/v1")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/create")
    @ResponseBody
    public ResponseEntity<?> create(String email, String name, String password) {
        User user;

        try {
            user = new User(email, name, password);
            userService.save(user);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            User user = new User(id);
            userService.delete(user);
        } catch (Exception ex) {
            return "Error deleting the user:" + ex.toString();
        }
        return "User successfully deleted!";
    }

    @RequestMapping("/get-by-email")
    @ResponseBody
    public ResponseEntity<?> getByEmail(String email) {
        User user = userService.findByEmail(email);

        if (user == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping("/update")
    @ResponseBody
    public String updateUser(long id, String email, String name) {
        try {
            User user = userService.findOne(id);
            user.setEmail(email);
            user.setUsername(name);
            userService.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User successfully updated!";
    }

}
