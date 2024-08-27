package com.heytonyy.skoologyapi.DTO;

import java.util.List;

public class TeacherDTO {
    private int id;
    private String name;
    private String email;
    private List<StudentSummaryDTO> students;

    public TeacherDTO() {}

    public TeacherDTO(int id, String name, String email, List<StudentSummaryDTO> students) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.students = students;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<StudentSummaryDTO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentSummaryDTO> students) {
        this.students = students;
    }
}