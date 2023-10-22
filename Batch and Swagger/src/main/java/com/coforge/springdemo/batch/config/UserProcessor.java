package com.coforge.springdemo.batch.config;

import com.coforge.springdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) throws Exception {
        log.info("Processing record for user id : {}", user.getUserId());
        User userOut = new User();
        userOut.setUserId(user.getUserId());
        userOut.setFirstName(user.getFirstName().trim().toUpperCase());
        userOut.setLastName(user.getLastName().trim().toUpperCase());
        userOut.setEmail(user.getEmail().trim().toLowerCase());
        return userOut;
    }
}
