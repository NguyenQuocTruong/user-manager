package com.busship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UserManagementApplication {



    private static final Logger log = LoggerFactory.getLogger(UserManagementApplication.class);

    private final Environment env;

    public UserManagementApplication(Environment env) {
        this.env = env;
    }

    public static void main(String[] args) {

        SpringApplication.run(UserManagementApplication.class, args);
    }


}
