package com.heytonyy.skoologyapi.Student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heytonyy.skoologyapi.TeacherStudent.TeacherStudent;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TeacherStudent> teacherStudents = new HashSet<>();

//    TODO: add grade mapping
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<StudentGrade> grades;

    public Student() { }

    public Student(int studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
    }

    public Set<TeacherStudent> getTeacherStudents() {
        return teacherStudents;
    }

    public void setTeacherStudents(Set<TeacherStudent> teacherStudents) {
        this.teacherStudents = teacherStudents;
    }

    public void addTeacherStudent(TeacherStudent teacherStudent) {
        this.teacherStudents.add(teacherStudent);
        teacherStudent.setStudent(this);
    }

    public void removeTeacherStudent(TeacherStudent teacherStudent) {
        this.teacherStudents.remove(teacherStudent);
        teacherStudent.setStudent(null);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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


    // Constructors, getters, and setters
}
