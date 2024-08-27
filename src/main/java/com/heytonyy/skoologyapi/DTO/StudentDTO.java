package com.heytonyy.skoologyapi.DTO;

import java.util.List;

public class StudentDTO {
    private int id;
    private String name;
    private String email;
    private List<TeacherSummaryDTO> teachers;

    public StudentDTO() {}

    public StudentDTO(int id, String name, String email, List<TeacherSummaryDTO> teachers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.teachers = teachers;
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

    public List<TeacherSummaryDTO> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<TeacherSummaryDTO> teachers) {
        this.teachers = teachers;
    }
}