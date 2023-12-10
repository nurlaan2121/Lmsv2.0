package models.service;

import models.Group;
import models.Student;

import java.util.LinkedList;
import java.util.List;

public class Proverkalar extends GeneratorPArol{

    public static boolean proverka(String name){
        if (name.length()>2){
            return true;
        }
        return false;
    }
    public static boolean proverkaUnicalNameGroup(String name, LinkedList<Group> groups){
        for (int i = 0; i < groups.size(); i++) {
            if (groups.get(i).getGroupName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }

    public static boolean proverkaUnicalNameStudent(String nam,LinkedList<Group> groups){
        for (int i = 0; i < groups.size(); i++) {
            for (int i1 = 0; i1 < groups.get(i).getStudents().size(); i1++) {
                if (groups.get(i).getStudents().get(i1).getEmail().equalsIgnoreCase(nam)){
                    return false;
                }
            }
        }
        return true;
    }
}