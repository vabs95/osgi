package com.ttn.student.service;

import com.ttn.student.Student;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.Iterator;

@Component(service = StudentApplication.class, immediate = true)
public class StudentApplicationImp implements StudentApplication {
    @Reference
    StudentService service;

    ArrayList<Student> studentList = new ArrayList<>();

    public String addStudent(Student student) {
        if (service.isClassLimitReached(studentList)) {
            return ("Can't add student; Class limit reached");
        } else {
            studentList.add(student);
            return ("Student Added");
        }
    }

    public String deleteStudent(int studentId) {
        Iterator iterator = studentList.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            Student studentTemp = (Student) iterator.next();
            if (studentTemp.getId() == studentId) {
                studentList.remove(studentTemp);
                flag = true;


            }
        }
        if (!flag)
            return ("Cannot delete student");
        else
            return ("Student deleted");
    }

    public String isStudentPassed(Student student) {
        if (service.getPassingMarks() <= student.getMarks())
            return "Passed";
        else
            return "Failed";
    }

    public int getStudentId(String studentName) {
        Iterator iterator = studentList.iterator();

        int id = 0;
        while (iterator.hasNext()) {
            Student studentTemp = (Student) iterator.next();
            if (studentTemp.getName() == studentName) {
                id = studentTemp.getId();
            }
        }
        return id;

    }
}
