package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.rest.model.Employee;
import com.example.rest.model.PayRoll;
import com.example.rest.repository.EmployeeRepository;
import com.example.rest.repository.PayRollRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmployeeRepository repository,PayRollRepository repository1) {
    return args -> {
      log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
      log.info("Preloading " + repository1.save(new PayRoll(Long.valueOf(1), 10000)));
      log.info("Preloading " + repository1.save(new PayRoll(Long.valueOf(2), 20000)));

    };
  }
}