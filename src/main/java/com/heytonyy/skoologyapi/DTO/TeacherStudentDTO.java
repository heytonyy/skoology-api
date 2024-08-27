package com.heytonyy.skoologyapi.DTO;

public class TeacherStudentDTO {
    private int teacherId;
    private int studentId;
    private int period;

    public TeacherStudentDTO() {}

    public TeacherStudentDTO(int teacherId, int studentId, int period) {
        this.teacherId = teacherId;
        this.studentId = studentId;
        this.period = period;
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

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
}
