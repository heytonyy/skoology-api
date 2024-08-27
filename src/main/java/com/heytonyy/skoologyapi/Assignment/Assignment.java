package com.heytonyy.skoologyapi.Assignment;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assignmentId;
    private String name;
    private String description;
    private Date dueDate;
    private int totalPoints;

//    @ManyToOne
//    @JoinColumn(name = "gradebook_id")
//    private Gradebook gradebook;
//
//    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<StudentGrade> studentGrades;

    // Constructors, getters, and setters
}