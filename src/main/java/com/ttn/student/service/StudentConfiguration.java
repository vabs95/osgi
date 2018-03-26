package com.ttn.student.service;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

import com.ttn.student.*;

@ObjectClassDefinition(name = "Student service configuration" , description="Service Configuration")
public @interface StudentConfiguration {

	@AttributeDefinition(name = "Max Students", description = "Number of students allowed")
	int maxStudentValue();
	
	@AttributeDefinition(name = "Passing Marks", description = "Marks required to pass")
	float passingMarks();
	
}
