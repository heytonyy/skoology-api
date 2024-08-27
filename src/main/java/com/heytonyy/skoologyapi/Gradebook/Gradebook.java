package com.heytonyy.skoologyapi.Gradebook;

import com.heytonyy.skoologyapi.Assignment.Assignment;
import com.heytonyy.skoologyapi.Teacher.Teacher;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Gradebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradebookId;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Teacher teacher;

//    @OneToMany(mappedBy = "gradebook", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Assignment> assignments;

    public Gradebook() { }

    public Gradebook(int gradebookId, Teacher teacher) {
        this.gradebookId = gradebookId;
        this.teacher = teacher;
    }

    public int getGradebookId() {
        return gradebookId;
    }

    public void setGradebookId(int gradebookId) {
        this.gradebookId = gradebookId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}