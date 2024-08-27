package com.heytonyy.skoologyapi.TeacherStudent;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heytonyy.skoologyapi.Student.Student;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import jakarta.persistence.*;

@Entity
public class TeacherStudent {
    @EmbeddedId
    private TeacherStudentId id;

    @JsonIgnore
    @ManyToOne
    @MapsId("teacherId")
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @JsonIgnore
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    private int period;

    public TeacherStudent() {}

    public TeacherStudent(TeacherStudentId id, Teacher teacher, Student student, int period) {
        this.id = id;
        this.teacher = teacher;
        this.student = student;
        this.period = period;
    }

    public TeacherStudentId getId() {
        return id;
    }

    public void setId(TeacherStudentId id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
