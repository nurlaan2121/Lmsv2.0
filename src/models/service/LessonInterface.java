package models.service;

import models.Group;
import models.Lesson;

import java.util.LinkedList;

public interface LessonInterface {
    LinkedList<Group> addnewLessonToGroup(LinkedList<Group> groups);
    Lesson getLessonByName(LinkedList<Group> groups,Long id);
    LinkedList<Lesson> getAllLessonByName(LinkedList<Group> groups,String name);
    String deleteLessonById(LinkedList<Group> groups,Long id);



}
