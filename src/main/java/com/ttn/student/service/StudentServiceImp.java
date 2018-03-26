package com.ttn.student.service;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.metatype.annotations.Designate;

import com.ttn.student.Student;

@Component(service = StudentService.class)
@Designate(ocd = StudentConfiguration.class)
public class StudentServiceImp implements StudentService {

	StudentConfiguration config;
	@Activate
	public void activate(StudentConfiguration config) {
		this.config = config;
		System.out.println("Max Students" + config.maxStudentValue() + " Passing Marks" + config.passingMarks());
	}

	public boolean isClassLimitReached(List list) {
		// TODO Auto-generated method stub
		System.out.println("method");
		System.out.println(list.size());
		return config.maxStudentValue() <= list.size();
	}

	public float getPassingMarks() {
		// TODO Auto-generated method stub
		return config.passingMarks();
	}

}
