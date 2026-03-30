package com.student.tracker.config;

import com.student.tracker.model.User;
import com.student.tracker.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            if (userRepository.count() == 0) {
                User teacher = new User();
                teacher.setUsername("teacher1");
                teacher.setPassword("pass123");
                teacher.setFullName("Dr. Smith");
                teacher.setRole("TEACHER");
                teacher.setSectionCode("TCH001");
                userRepository.save(teacher);

                User student = new User();
                student.setUsername("student1");
                student.setPassword("pass123");
                student.setFullName("Bhanu Prakash");
                student.setRole("STUDENT");
                student.setSectionCode("TCH001");
                userRepository.save(student);

                System.out.println("Database Initialized with Teacher and Student");
            }
        };
    }
}
