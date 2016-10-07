package com.github.handioq.shopapp.service;

import com.github.handioq.shopapp.Application;
import com.github.handioq.shopapp.model.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringApplicationConfiguration(Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void init() {

    }

    @Test
    public void findByUsernameTest() throws Exception {
        User user = userService.findOne(2); // got "Andrew"
        String username = user.getUsername();

        Assert.assertEquals(user.getUsername(), userService.findByUsername(username).getUsername()); // user equals error
    }

}
