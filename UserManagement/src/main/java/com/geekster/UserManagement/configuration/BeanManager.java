package com.geekster.UserManagement.configuration;


import com.geekster.UserManagement.model.Type;
import com.geekster.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
class BeanManager {

    @Bean
    public List<User> getInitializedList()
    {
        User initUser = new User(87,"Rishi","rishirajrd4@gmail.com","open","7004463389",24, LocalDate.of(1998,11,19), Type.ADMIN);
        List<User> initList = new ArrayList<>();
        initList.add(initUser);

        return initList;
    }
}
