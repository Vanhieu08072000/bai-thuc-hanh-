package com.example.springdatajpa;

import com.example.springdatajpa.entity.Student;
import com.example.springdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {
    @Autowired
    private StudentRepository studentReponsitory;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(StudentRepository e) {
        return (args) -> {
           add(new Student("le","hieu", "thieugia7878@email.com"));
  //          delete((long) 1);
   //         update((long) 2,"Doan");
            System.out.println(e.findAll());
        };
    }
    private Student add(Student student) {
        return studentReponsitory.save(student);
    }
    private void delete(Long id) {

        studentReponsitory.deleteById(id);
        System.out.println(id);
    }
    private void update(long id,String email){

        studentReponsitory.update(id,email);
        System.out.println("update complete employee: "+ studentReponsitory.findById(id));
    }

}
