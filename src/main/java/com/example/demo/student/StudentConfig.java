package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student chaiyanan = new Student(
			"Chaiyanan",
		    "chyn.seekhachon@gmail.com",
				LocalDate.of(2003,Month.APRIL,2)
			// 21
			);

            Student clark = new Student(
                "Clark",
                "clark@gmail.com",
                LocalDate.of(2003,Month.MARCH,3)
                // 21
            );

            repository.saveAll(
               List.of(chaiyanan, clark)
            );
        };
    }
}
