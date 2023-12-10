package models.service;

import models.Group;
import models.Lesson;
import models.Student;

import java.util.LinkedList;

public interface StudentInterface {
    LinkedList<Group> addnewStudenttoGroup(LinkedList<Group> groups);
    LinkedList<Group> updateStudent(LinkedList<Group> groups);
    Student findStudentByEmail(String email,LinkedList<Group> groups);
    LinkedList<Student> getallstudentbyGroupName(String name,LinkedList<Group> groups);
    Lesson getallStudentsByLessonName(Long id, LinkedList<Group> groups);
    String deleteStudentByEmail(String email,LinkedList<Group> groups);
    LinkedList<Lesson> getLessonsStudenta(LinkedList<Group> groups,String email);

}
