import models.Admin;
import models.Group;
import models.Student;
import models.service.*;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Group> allmassive = new LinkedList<>();
        DateBase dateBase = new DateBase(allmassive);
        GroupImpl group = new GroupImpl();
        LessonImpl lesson = new LessonImpl();
        StudenImpl studen = new StudenImpl();
        Admin admin = new Admin();
        admin.setEmail("nurlan@gmail.com");
        admin.setPassword("nurlan21");
        LinkedList<Admin> admins = new LinkedList<>();
        admins.add(admin);
        LOOPMAIIN:
        while (true) {
            System.out.println("""
                    Choice command:
                    1.User
                    2.Admin
                    0.Exit
                    """);
            try {
                int ac = new Scanner(System.in).nextInt();
                switch (ac) {
                    case 1 -> {
                        System.out.println("Write login: ");
                        String lo = new Scanner(System.in).nextLine();
                        System.out.println("Write password: ");
                        String pas = new Scanner(System.in).nextLine();
                        Student currentuser = null;
                        Group group1 = null;
                        for (int i = 0; i < allmassive.size(); i++) {
                            for (int i1 = 0; i1 < allmassive.get(i).getStudents().size(); i1++) {
                                if (allmassive.get(i).getStudents().get(i1).getEmail().equalsIgnoreCase(lo) && allmassive.get(i).getStudents().get(i1).getPassword().equalsIgnoreCase(pas)) {
                                    currentuser = allmassive.get(i).getStudents().get(i1);
                                    group1 = allmassive.get(i);
                                    USERLOOP:
                                    while (true) {
                                        System.out.println("""
                                                Choice command:
                                                1.My profile;
                                                2.My teachers and my Mentors
                                                3.My lessons
                                                0.Exit
                                                """);
                                        try {
                                            int actionUser = new Scanner(System.in).nextInt();
                                            switch (actionUser) {
                                                case 1 -> {
                                                    System.out.println("My last name: " + currentuser.getLastName());
                                                    System.out.println("My name: " + currentuser.getName());
                                                    System.out.println("My age: " + currentuser.getAge());
                                                    System.out.println("My email:" + currentuser.getEmail());
                                                    System.out.println("My password " + currentuser.getPassword());
                                                    System.out.println("My gender: " + currentuser.getGender());
                                                    System.out.println("My telepone number: " + currentuser.getTelephoneNumber());
                                                }
                                                case 2 -> {
                                                    System.out.println("My TecherFullMame  :" + group1.getLessons().get(0).getTecherFullMame());
                                                    System.out.println("My Mentor full name  :" + group1.getLessons().get(0).getMentorsFullMame());
                                                }
                                                case 3 -> {
                                                    System.out.println("My lessons : " + group1.getLessons());
                                                }
                                                case 0 -> {
                                                    break USERLOOP;
                                                }
                                            }
                                        } catch (InputMismatchException exception) {
                                            System.out.println("Write number: ");
                                        }
                                    }
                                }
                            }
                        }
                        System.out.println("Sizdi ali kosho elek");
                    }
                    case 2 -> {
                        System.out.println("Write login: ");
                        String login = new Scanner(System.in).nextLine();
                        System.out.println("Write password: ");
                        String pass = new Scanner(System.in).nextLine();
                        if (login.equalsIgnoreCase(admin.getEmail()) && pass.equalsIgnoreCase(admin.getPassword())) {
                            int saat = ZonedDateTime.now().getHour();
                            ZonedDateTime dateTime = ZonedDateTime.now();
                            DateTimeFormatter men2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String nne = dateTime.format(men2);
                            if (saat >= 5 && saat <= 11){
                                System.out.println("KUTMAN TAN" + nne);
                            } else if (saat >= 12 && saat <= 17) {
                                System.out.println("Kutman KUN"+ nne);
                            } else if (saat >= 17) {
                                System.out.println("Kutman kech!"+ nne);
                            }
                            LOOP1:
                            while (true) {
                                System.out.println("""
                                        \n\n\n ******** Write command ********
                                        1.Add new group
                                        2.Get group by name
                                        3.Update group by name
                                        4.Get all groups
                                        5.Add new Student to Group
                                        6.Update student
                                        7.Find studet by email
                                        8.Get all students by group name
                                        9.Get all student in Lesson
                                        10.Deleta sudent by email
                                        11.Add lesson to group
                                        12.Get lesson by name
                                        13.Get all lesson by Group name
                                        14.Delete lesson by ID
                                        15.Delete group by name
                                        16.All lessons Studenta
                                        0.EXIT        
                                        """);
                                try {
                                    int action = scanner.nextInt();
                                    switch (action) {
                                        case 1 -> {
                                            allmassive = group.addnewGroup(new Group(), allmassive);
                                        }
                                        case 2 -> {
                                            System.out.println(group.getGroupByName(allmassive));
                                        }
                                        case 3 -> {
                                            System.out.println(group.updateGroupByName(allmassive));
                                        }
                                        case 4 -> {
                                            group.getAllGroups(allmassive);
                                        }
                                        case 5 -> {
                                            LinkedList<Group> dd = studen.addnewStudenttoGroup(allmassive);
                                            if (dd != null) {
                                                allmassive = dd;
                                            } else System.out.println("I am nut can search group! ");
                                        }
                                        case 6 -> {
                                            LinkedList<Group> dd = studen.updateStudent(allmassive);
                                            if (dd != null) {
                                                allmassive = dd;
                                            } else System.out.println("Null ");
                                        }
                                        case 7 -> {
                                            System.out.println("Write email: ");
                                            System.out.println(studen.findStudentByEmail(new Scanner(System.in).nextLine(), allmassive));
                                        }
                                        case 8 -> {
                                            System.out.println(studen.getallstudentbyGroupName(new Scanner(System.in).nextLine(), allmassive));
                                        }
                                        case 9 -> {
                                            System.out.println(studen.getallStudentsByLessonName(new Scanner(System.in).nextLong(), allmassive));
                                        }
                                        case 10 -> {
                                            System.out.println(studen.deleteStudentByEmail(new Scanner(System.in).nextLine(), allmassive));
                                        }
                                        case 11 -> {
                                            LinkedList<Group> dd = lesson.addnewLessonToGroup(allmassive);
                                            if (dd != null) {
                                                allmassive = dd;
                                            } else System.out.println("Error!");
                                        }
                                        case 12 -> {
                                            System.out.println(lesson.getLessonByName(allmassive, new Scanner(System.in).nextLong()));
                                        }
                                        case 13 -> {
                                            System.out.println(lesson.getAllLessonByName(allmassive, new Scanner(System.in).nextLine()));
                                        }
                                        case 14 -> {
                                            System.out.println(lesson.deleteLessonById(allmassive, new Scanner(System.in).nextLong()));
                                        }
                                        case 15 -> {
                                            System.out.println("Write name group: ");
                                            System.out.println(group.deleteGroupByName(new Scanner(System.in).nextLine(), allmassive));
                                        }
                                        case 16 -> {
                                            System.out.println("Write e,ail student");
                                            System.out.println(studen.getLessonsStudenta(allmassive, new Scanner(System.in).nextLine()));
                                        }
                                        case 0 -> {
                                            break LOOP1;
                                        }
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Write number!");
                                    scanner.next();
                                }
                            }
                        }
                    }
                    case 0 -> {
                        break LOOPMAIIN;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("San jaz");
                new Scanner(System.in).nextInt();
            }
        }
    }
}