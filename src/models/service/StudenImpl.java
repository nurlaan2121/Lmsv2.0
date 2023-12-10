package models.service;

import models.Gender;
import models.Group;
import models.Lesson;
import models.Student;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudenImpl extends Proverkalar implements StudentInterface {
    String[] allocods = {"500", "501", "502", "503", "504", "505", "506", "507", "508", "509",
            "700", " 701", "702", "703", "704", "705", "706", "707", "708", "709",
            "550", "551", "552", "553", "554", "555", "556", "557", "559",
            "770", "771", "772", "773", "774", "775", "776", "777", "778", "779", "220", "221", "222", "223", "224"};

    @Override
    public LinkedList<Group> addnewStudenttoGroup(LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Write name group: ");
            String name = new Scanner(System.in).nextLine();
            if (name.equalsIgnoreCase(groups.get(i).getGroupName())) {
                Proverkalar proverkalar = new Proverkalar();
                Student student = new Student();
                while (true) {
                    System.out.println("Write name: ");
                    String nn = new Scanner(System.in).nextLine();
                    if (proverka(nn)) {
                        student.setName(nn);
                        proverkalar.setName(nn);
                        break;
                    }
                }
                student.setId(GeneratorId.generatorIdStudent());
                while (true) {
                    System.out.println("Write last name: ");
                    String nn = new Scanner(System.in).nextLine();
                    if (proverka(nn)) {
                        student.setLastName(nn);
                        proverkalar.setLastName(nn);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write gender(M||F) :");
                    String nn = new Scanner(System.in).nextLine();
                    if (nn.equalsIgnoreCase("M")) {
                        student.setGender(Gender.MALE);
                        break;
                    } else if (nn.equalsIgnoreCase("F")) {
                        student.setGender(Gender.FEMALE);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write age student: ");
                    try {
                        int nn = new Scanner(System.in).nextInt();
                        if (nn > 18 && nn < 70) {
                            student.setAge(nn);
                            proverkalar.setAge(nn);
                            break;
                        }
                    }catch (InputMismatchException exception){
                        System.out.println("San jazz");
                        new Scanner(System.in).next();
                    }

                }
                LOOOP:
                while (true) {
                    System.out.println("Write telephone number: ");
                    String nn = new Scanner(System.in).nextLine();
                    for (int j = 0; j < allocods.length; j++) {
                        if (nn.startsWith(allocods[j]) && nn.length() == 9) {
                            student.setTelephoneNumber("+996" + nn);
                            break LOOOP;
                        }
                    }
                }
                while (true) {
                    System.out.println("Write  format uchenia :(Online || Offline)");
                    String nn = new Scanner(System.in).nextLine();
                    if (nn.equalsIgnoreCase("Online")) {
                        student.setFormat(true);
                        break;
                    } else if (nn.equalsIgnoreCase("offline")) {
                        student.setFormat(false);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write email: ");
                    String nn = new Scanner(System.in).nextLine();
                    if (proverkaUnicalNameStudent(nn, groups) && nn.endsWith("@gmail.com")&& nn.length() > 11) {
                        student.setEmail(nn);
                        break;
                    }
                }
                while (true) {
                    System.out.println("Write password: ");
                    System.out.println("RECOMENTASIA PAROL: " + proverkalar.generatorParol(proverkalar));
                    String nn = new Scanner(System.in).nextLine();
                    if (nn.length() > 4) {
                        student.setPassword(nn);
                        break;
                    }
                }
                LinkedList<Student> newmas = groups.get(i).getStudents();
                newmas.add(student);
                groups.get(i).setStudents(newmas);
                return groups;
            }
        }
        return null;
    }

    @Override
    public LinkedList<Group> updateStudent(LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            for (int i1 = 0; i1 < groups.get(i).getStudents().size(); i1++) {
                System.out.println("Write email student ");
                String email = new Scanner(System.in).nextLine();
                if (email.equalsIgnoreCase(groups.get(i).getStudents().get(i1).getEmail())) {
                    System.out.println("Choice command: ");
                    System.out.println("""
                            1.Name
                            2.Last name
                            3.Gender
                            4.Email
                            5.Password
                            6.Format
                            7.Age
                            8.Telephone number
                                                   
                            """);
                    try {
                        int num = new Scanner(System.in).nextInt();
                        switch (num) {
                            case 1 -> {
                                while (true) {
                                    System.out.println("Write name: ");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (proverka(nn)) {
                                        groups.get(i).getStudents().get(i1).setName(nn);
                                        break;
                                    }
                                }
                            }
                            case 2 -> {
                                while (true) {
                                    System.out.println("Write last name: ");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (proverka(nn)) {
                                        groups.get(i).getStudents().get(i1).setLastName(nn);
                                        break;
                                    }
                                }
                            }
                            case 3 -> {
                                while (true) {
                                    System.out.println("Write gender(M||F) :");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (nn.equalsIgnoreCase("M")) {
                                        groups.get(i).getStudents().get(i1).setGender(Gender.MALE);
                                        break;
                                    } else if (nn.equalsIgnoreCase("F")) {
                                        groups.get(i).getStudents().get(i1).setGender(Gender.FEMALE);
                                        break;
                                    }
                                }
                            }
                            case 4 -> {
                                while (true) {
                                    System.out.println("Write email: ");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (proverkaUnicalNameStudent(nn, groups) && nn.endsWith("@gmail.com")&& nn.length() > 11) {
                                        groups.get(i).getStudents().get(i1).setEmail(nn);
                                        break;
                                    }
                                }
                            }
                            case 5 -> {
                                while (true) {
                                    System.out.println("Write password: ");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (nn.length() > 4) {
                                        groups.get(i).getStudents().get(i1).setPassword(nn);
                                        break;
                                    }
                                }
                            }
                            case 6 -> {
                                while (true) {
                                    System.out.println("Write  format uchenia :");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (nn.equalsIgnoreCase("Online")) {
                                        groups.get(i).getStudents().get(i1).setFormat(true);
                                        break;
                                    } else if (nn.equalsIgnoreCase("offline")) {
                                        groups.get(i).getStudents().get(i1).setFormat(false);
                                        break;
                                    }
                                }
                            }
                            case 7 -> {
                                while (true) {
                                    System.out.println("Write age student: ");
                                    try {
                                        int nn = new Scanner(System.in).nextInt();
                                        if (nn > 18 && nn < 70) {
                                            groups.get(i).getStudents().get(i1).setAge(nn);
                                            break;
                                        }
                                    }catch (InputMismatchException exception){
                                        System.out.println("San jaz!");
                                    }

                                }
                            }
                            case 8 -> {
                                while (true) {
                                    System.out.println("Write telephone number: ");
                                    String nn = new Scanner(System.in).nextLine();
                                    if (proverka(nn)) {
                                        groups.get(i).getStudents().get(i1).setTelephoneNumber(nn);
                                        break;
                                    }
                                }
                            }

                        }
                    }catch (InputMismatchException exception){
                        System.out.println("San jazz!");
                        new Scanner(System.in).next();
                    }
                    return groups;
                }
            }
        }
        return null;
    }

    @Override
    public Student findStudentByEmail(String email, LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            for (int i1 = 0; i1 < groups.get(i).getStudents().size(); i1++) {
                if (email.equalsIgnoreCase(groups.get(i).getStudents().get(i1).getEmail())){
                    return groups.get(i).getStudents().get(i1);
                }
            }
        }
        return null;
    }

    @Override
    public LinkedList<Student> getallstudentbyGroupName(String name, LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            if (name.equalsIgnoreCase(groups.get(i).getGroupName())){
                return groups.get(i).getStudents();
            }
        }
        return null;
    }

    @Override
    public Lesson getallStudentsByLessonName(Long id, LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            for (int i1 = 0; i1 < groups.get(i).getLessons().size(); i1++) {
                if (id == groups.get(i).getLessons().get(i1).getId()){
                    return groups.get(i).getLessons().get(i1);
                }
            }
        }
        return null;
    }

    @Override
    public String deleteStudentByEmail(String email, LinkedList<Group> groups) {
        for (int i = 0; i < groups.size(); i++) {
            for (int i1 = 0; i1 < groups.get(i).getStudents().size(); i1++) {
                if (email.equalsIgnoreCase(groups.get(i).getStudents().get(i1).getEmail())){
                    groups.get(i).getStudents().remove(i1);
                    return "Success!";
                }
            }
        }
        return null;
    }

    @Override
    public LinkedList<Lesson> getLessonsStudenta(LinkedList<Group> groups, String email) {
        for (int i = 0; i < groups.size(); i++) {
            for (int i1 = 0; i1 < groups.get(i).getStudents().size(); i1++) {
                if (groups.get(i).getStudents().get(i1).getEmail().equalsIgnoreCase(email)){
                    return groups.get(i).getLessons();
                }
            }
        }
        return null;
    }
}
