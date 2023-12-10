package models;

import java.util.LinkedList;

public class Group {
    private long id;
    private String groupName;
    private String groupDescription;
    private String lenguage;
    private LinkedList<Student> students = new LinkedList<>();
    private LinkedList<Lesson> lessons = new LinkedList<>();

    public Group() {
    }

    public Group(long id, String groupName, String groupDescription, String lenguage, LinkedList<Student> students, LinkedList<Lesson> lessons) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.lenguage = lenguage;
        this.students = students;
        this.lessons = lessons;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getLenguage() {
        return lenguage;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    public LinkedList<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(LinkedList<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", lenguage='" + lenguage + '\'' +
                ", students=" + students +
                ", lessons=" + lessons +
                '}';
    }
}
