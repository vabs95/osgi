package com.ttn.student;


import com.ttn.student.service.StudentApplication;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.scripting.SlingScriptHelper;
import org.apache.sling.scripting.sightly.pojo.Use;

import javax.script.Bindings;

public class Application implements Use {
    String addStudent;
    String deleteStudent;
    int studentId;
    String isStudentPassed;

    @Override
    public void init(Bindings bindings) {
        Resource resource = (Resource) bindings.get("resource");
        String path = (String) resource.getValueMap().get("path");
        SlingScriptHelper slingScriptHelper = (SlingScriptHelper) bindings.get("sling");
        StudentApplication studentApplication = slingScriptHelper.getService(StudentApplication.class);

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Vaibhav");
        student1.setMarks(95f);
        student1.setAge(22);

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Akash");
        student2.setMarks(85f);
        student2.setAge(24);

        addStudent = studentApplication.addStudent(student1);
        //addStudent = studentApplication.addStudent(student2);


        isStudentPassed = studentApplication.isStudentPassed(student1);
        //isStudentPassed = studentApplication.isStudentPassed(student2);

        studentId = studentApplication.getStudentId("Vaibhav");
        //studentId = studentApplication.getStudentId("Akash");


        deleteStudent = studentApplication.deleteStudent(2);


    }

    public String getAddStudent() {
        return addStudent;
    }

    public String getDeleteStudent() {
        return deleteStudent;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getIsStudentPassed() {
        return isStudentPassed;
    }
}
