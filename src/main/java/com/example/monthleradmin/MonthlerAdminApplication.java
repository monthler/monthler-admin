package com.example.monthleradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing    //jpa Auddit 적용
public class MonthlerAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonthlerAdminApplication.class, args);
    }

}
