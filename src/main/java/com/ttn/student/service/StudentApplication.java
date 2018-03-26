package com.ttn.student.service;

import java.util.Iterator;

import com.ttn.student.Student;

public interface StudentApplication {

	String addStudent(Student student);

	String deleteStudent(int studentId);

	String isStudentPassed(Student student);

	int getStudentId(String studentName);
}
