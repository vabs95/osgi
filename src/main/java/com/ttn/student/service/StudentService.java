package com.ttn.student.service;

import java.util.List;

import com.ttn.student.Student;

public interface StudentService {
	
	boolean isClassLimitReached(List list);
	float getPassingMarks();

}
