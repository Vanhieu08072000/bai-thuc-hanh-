package com.example.springdatajpa.repository;

import com.example.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student,Long>
{
    @Transactional
    @Modifying
    @Query("update Student s set s.email=?2 where s.id=?1")
    public void update(Long id, String email);

}
