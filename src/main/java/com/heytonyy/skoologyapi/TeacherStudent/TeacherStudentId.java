package com.heytonyy.skoologyapi.TeacherStudent;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TeacherStudentId implements Serializable {
    private int teacherId;
    private int studentId;

    public TeacherStudentId() {}

    public TeacherStudentId(int teacherId, int studentId) {
        this.teacherId = teacherId;
        this.studentId = studentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeacherStudentId that = (TeacherStudentId) o;
        return teacherId == that.teacherId && studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, studentId);
    }
}
