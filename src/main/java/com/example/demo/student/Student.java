package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )

    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )

    private long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;
    
    // Constructor
    public Student () {}

    public Student(long id, 
        String name,
        String email,
        LocalDate dob
        ) {
        this.id = id;
        this.name = name;
        // this.age = age;
        this.dob = dob;
        this.email = email;
    }

    public Student( 
        String name,
        String email,
        LocalDate dob
        ) {
        this.name = name;
        // this.age = age;
        this.dob = dob;
        this.email = email;
    }
    // Getters
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
    public LocalDate getDob() {
        return dob;
    }
    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", email=" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
