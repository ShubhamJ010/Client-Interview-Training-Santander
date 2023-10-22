package com.coforge.springdemo.batch.config;

import com.coforge.springdemo.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserWriter implements ItemWriter<User> {



    @Override
    public void write(List<? extends User> userList) throws Exception {

        log.error("USer List : {}  and Size {}", userList, userList.size());

    }
}
