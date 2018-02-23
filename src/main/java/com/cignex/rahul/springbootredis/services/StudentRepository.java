package com.cignex.rahul.springbootredis.services;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cignex.rahul.springbootredis.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {

}
