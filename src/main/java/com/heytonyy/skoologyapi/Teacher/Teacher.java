package com.heytonyy.skoologyapi.Teacher;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heytonyy.skoologyapi.Gradebook.Gradebook;
import com.heytonyy.skoologyapi.TeacherStudent.TeacherStudent;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherId;
    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TeacherStudent> teacherStudents = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Gradebook gradebook;

    public Teacher() { }

    public Teacher(int teacherId, String name, String email) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
    }

    public void addTeacherStudent(TeacherStudent teacherStudent) {
        this.teacherStudents.add(teacherStudent);
        teacherStudent.setTeacher(this);
    }

    public void removeTeacherStudent(TeacherStudent teacherStudent) {
        this.teacherStudents.remove(teacherStudent);
        teacherStudent.setTeacher(null);
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<TeacherStudent> getTeacherStudents() {
        return teacherStudents;
    }

    public void setTeacherStudents(Set<TeacherStudent> teacherStudents) {
        this.teacherStudents = teacherStudents;
    }

    public Gradebook getGradebook() {
        return gradebook;
    }

    public void setGradebook(Gradebook gradebook) {
        this.gradebook = gradebook;
    }
}
