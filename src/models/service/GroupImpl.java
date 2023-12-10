package models.service;

import models.Gender;
import models.Group;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class GroupImpl extends Proverkalar implements GroupInterface {
    @Override
    public LinkedList<Group> addnewGroup(Group group, LinkedList<Group> groups) {
        while (true) {
            System.out.println("Write name: ");
            String name = new Scanner(System.in).nextLine();
            if (proverka(name) && proverkaUnicalNameGroup(name, groups)) {
                group.setGroupName(name);
                break;
            }
        }
        while (true) {
            System.out.println("Write deckription: ");
            String des = new Scanner(System.in).nextLine();
            if (proverka(des)) {
                group.setGroupDescription(des);
                break;
            }
        }
        group.setId(GeneratorId.generatorId());
        while (true) {
            System.out.println("Write langage: ");
            String lan = new Scanner(System.in).nextLine();
            if (proverka(lan)) {
                group.setLenguage(lan);
                break;
            }
        }
        groups.add(group);
        return groups;
    }

    @Override
    public Group getGroupByName(LinkedList<Group> groups) {
        System.out.println("Write name group: ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < groups.size(); i++) {
            if (name.equalsIgnoreCase(groups.get(i).getGroupName())) {
                return groups.get(i);
            }
        }
        return null;
    }

    @Override
    public String updateGroupByName(LinkedList<Group> groups) {
        System.out.println("Write name group: ");
        String name = new Scanner(System.in).nextLine();
        for (int i = 0; i < groups.size(); i++) {
            if (name.equalsIgnoreCase(groups.get(i).getGroupName())) {
                System.out.println("Choice command: ");
                System.out.println("""
                        1.Name
                        2.Deckription
                        3.Language
                        """);
                try {
                    int num = new Scanner(System.in).nextInt();
                    switch (num) {
                        case 1 -> {
                            while (true) {
                                System.out.println("Write name");
                                String setGroupName = new Scanner(System.in).nextLine();
                                if (proverkaUnicalNameGroup(setGroupName, groups)) {
                                    groups.get(i).setGroupName(setGroupName);
                                    break;
                                }
                            }
                        }case 2->{
                            while (true){
                                System.out.println("Write deckription: ");
                                String des = new Scanner(System.in).nextLine();
                                if (proverka(des)){
                                    groups.get(i).setGroupDescription(des);
                                    break;
                                }
                            }
                        }case 3->{
                            while (true){
                                System.out.println("Write language: ");
                                String lan  = new Scanner(System.in).nextLine();
                                if (proverka(lan)){
                                    groups.get(i).setLenguage(lan);
                                    break;
                                }
                            }
                        }
                    }

                }catch (InputMismatchException exception){
                    System.out.println("Write number!");
                    new Scanner(System.in).next();
                }
            }else return "Not takoi gruppa";
        }
        return "Success";
    }

    @Override
    public void getAllGroups(LinkedList<Group> groups) {
        System.out.println(groups);

    }

    @Override
    public String deleteGroupByName(String name,LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            if (name.equalsIgnoreCase(groups.get(i).getGroupName())){
                groups.remove(i);
                return "Success!";
            }
        }
        return "Net takoi gruppa";
    }
}
