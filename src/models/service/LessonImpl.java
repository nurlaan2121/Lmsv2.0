package models.service;

import models.Group;
import models.Lesson;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Scanner;

public class LessonImpl extends Proverkalar implements LessonInterface {
    @Override
    public LinkedList<Group> addnewLessonToGroup(LinkedList<Group> groups) {
        Lesson lesson = new Lesson();
        System.out.println("Write name group: ");
        String nnn = new Scanner(System.in).nextLine();
        for (int i = 0; i < groups.size(); i++) {
            if (nnn.equalsIgnoreCase(groups.get(i).getGroupName())) {
                while (true) {
                    System.out.println("Write name lesson: ");
                    String setname = new Scanner(System.in).nextLine();
                    if (proverka(setname)) {
                        lesson.setLessonName(setname);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write description: ");
                    String setname = new Scanner(System.in).nextLine();
                    if (proverka(setname)) {
                        lesson.setDescriptionLesson(setname);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write format (Online || Offline): ");
                    String setname = new Scanner(System.in).nextLine();
                    if (setname.equalsIgnoreCase("Online")) {
                        lesson.setFormatLesson(true);
                        break;
                    } else if (setname.equalsIgnoreCase("Offline")) {
                        lesson.setFormatLesson(false);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write teacher full name: ");
                    String setname = new Scanner(System.in).nextLine();
                    if (proverka(setname)) {
                        lesson.setTecherFullMame(setname);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write mentor full name: ");
                    String setname = new Scanner(System.in).nextLine();
                    if (proverka(setname)) {
                        lesson.setMentorsFullMame(setname);
                        break;
                    }
                }
                lesson.setId(GeneratorId.generatorIdLesson());
                lesson.setStudents(groups.get(i).getStudents());
                System.out.println("Write start day lesson: ");
                lesson.setDateStartLesson(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                System.out.println("Write finish day lesson: ");
                lesson.setDateStartLesson(LocalDate.of(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
                LinkedList<Lesson> eee = groups.get(i).getLessons();
                eee.add(lesson);
                groups.get(i).setLessons(eee);
                return groups;
            }
        }
        return null;
    }


    @Override
    public Lesson getLessonByName(LinkedList<Group> groups, Long id) {
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).getLessons().size(); j++) {
                if (id == groups.get(i).getLessons().get(j).getId()){
                    return groups.get(i).getLessons().get(j);
                }
            }
        }return null;
    }

    @Override
    public LinkedList<Lesson> getAllLessonByName(LinkedList<Group> groups, String name) {
        for (int i = 0; i < groups.size(); i++) {
            if (name.equalsIgnoreCase(groups.get(i).getGroupName())){
                return groups.get(i).getLessons();
            }
        }
        return null;
    }

    @Override
    public String deleteLessonById(LinkedList<Group> groups, Long id) {
        for (int i = 0; i < groups.size(); i++) {
            for (int j = 0; j < groups.get(i).getLessons().size(); j++) {
                if (id == groups.get(i).getLessons().get(j).getId()){
                    groups.get(i).getLessons().remove(j);
                    return "Success!";
                }
            }
        }
        return null;
    }
}
