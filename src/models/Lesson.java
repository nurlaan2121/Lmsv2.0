package models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedList;

public class Lesson {
    private long id;
    private String lessonName;
    private String techerFullMame;
    private String mentorsFullMame;
    private String descriptionLesson;
    private LocalDate dateStartLesson;
    private LocalDate dateFinishLesson;
    private boolean formatLesson;
    private LinkedList<Student> students = new LinkedList<>();

    public Lesson() {
    }

    public Lesson(long id, String lessonName, String techerFullMame, String mentorsFullMame, String descriptionLesson, LocalDate dateStartLesson, LocalDate dateFinishLesson, boolean formatLesson, LinkedList<Student> students) {
        this.id = id;
        this.lessonName = lessonName;
        this.techerFullMame = techerFullMame;
        this.mentorsFullMame = mentorsFullMame;
        this.descriptionLesson = descriptionLesson;
        this.dateStartLesson = dateStartLesson;
        this.dateFinishLesson = dateFinishLesson;
        this.formatLesson = formatLesson;
        this.students = students;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getTecherFullMame() {
        return techerFullMame;
    }

    public void setTecherFullMame(String techerFullMame) {
        this.techerFullMame = techerFullMame;
    }

    public String getMentorsFullMame() {
        return mentorsFullMame;
    }

    public void setMentorsFullMame(String mentorsFullMame) {
        this.mentorsFullMame = mentorsFullMame;
    }

    public String getDescriptionLesson() {
        return descriptionLesson;
    }

    public void setDescriptionLesson(String descriptionLesson) {
        this.descriptionLesson = descriptionLesson;
    }

    public LocalDate getDateStartLesson() {
        return dateStartLesson;
    }

    public void setDateStartLesson(LocalDate dateStartLesson) {
        this.dateStartLesson = dateStartLesson;
    }

    public LocalDate getDateFinishLesson() {
        return dateFinishLesson;
    }

    public void setDateFinishLesson(LocalDate dateFinishLesson) {
        this.dateFinishLesson = dateFinishLesson;
    }

    public boolean isFormatLesson() {
        return formatLesson;
    }

    public void setFormatLesson(boolean formatLesson) {
        this.formatLesson = formatLesson;
    }

    public LinkedList<Student> getStudents() {
        return students;
    }

    public void setStudents(LinkedList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", techerFullMame='" + techerFullMame + '\'' +
                ", mentorsFullMame='" + mentorsFullMame + '\'' +
                ", descriptionLesson='" + descriptionLesson + '\'' +
                ", dateStartLesson=" + dateStartLesson +
                ", dateFinishLesson=" + dateFinishLesson +
                ", formatLesson=" + formatLesson +
                '}';
    }
}
