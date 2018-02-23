package com.cignex.rahul.springbootredis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cignex.rahul.springbootredis.model.Student;
import com.cignex.rahul.springbootredis.services.StudentRepository;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	protected StudentRepository studentRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Optional<Student> getAllStudents(@PathVariable String id) {
		return studentRepository.findById(id);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public String saveStudents(@RequestBody List<Student> students) {

		if (students.size() > 0) {
			for (Student student : students) {
				studentRepository.save(student);
				System.out.println(student);
			}
			return "Record has been inserted";
		}
		return "Something went wrong";
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public String deleteStudentsById(@PathVariable String id) {
		studentRepository.deleteById(id);
		return "Records has been deleted";
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public String deleteAllStudents() {
		studentRepository.deleteAll();
		return "All Records has been deleted";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String deleteStudentsById(@RequestBody Student student) {
		studentRepository.save(student);
		return "Records has been saved";
	}

}
